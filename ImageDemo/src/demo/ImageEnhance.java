package demo;

import java.awt.image.ColorModel;

public class ImageEnhance
{
	//对比度扩展======================================
            
    //计算灰度映射表
    public int[] pixelsMap(int x1,int y1,int x2,int y2)
    {
    	int[] pMap = new int[256];    //映射表
    	
    	if(x1 > 0)
    	{    	
    	   	double k1 = y1/x1;        //第1段钭率k1
	    	
	    	//按第1段钭率k1线性变换
	    	for(int i = 0; i <= x1; i++)
	    	    pMap[i] = (int)(k1*i);		
	    }
    	
    	double k2 = (y2-y1)/(x2-x1);  //第2段钭率k2
    	
    	//按第2段钭率k2线性变换
    	for(int i = x1+1; i <= x2; i++)
    		if(x2 != x1)
    		    pMap[i] = y1 + (int)(k2*(i-x1));
    		else
    		    pMap[i] = y1;    		    
    	    	
    	if(x2<255)
    	{    	
	    	double k3 = (255-y2)/(255-x2);//第2段钭率k2
	    	
	    	//按第3段钭率k3线性变换
	    	for(int i = x2+1; i< 256; i++)
	    		pMap[i] = y2 + (int)(k3*(i-x2)); 		    		    
	    }
    	return pMap;
    }
    
    //对比度扩展
    public int[] stretch(int[] pix, int[] map, int iw, int ih)
    {		
		ColorModel cm = ColorModel.getRGBdefault();
		int r, g, b;
		for(int i = 0; i < iw*ih; i++) 
		{
			r = map[cm.getRed(pix[i])];
			g = map[cm.getGreen(pix[i])];
			b = map[cm.getBlue(pix[i])];
			
			if(r >= 255) r = 255;
			if(r < 0)    r = 0;
			if(g >= 255) g = 255;
			if(g < 0)    g = 0;
			if(b >= 255) b = 255;
			if(b < 0)    b = 0;
			
			pix[i] = 255 << 24|r << 16|g << 8|b;
		}
		return pix;
	}    
    
	//直方图均匀化==================================
	
	public int[] histequal(int[] pix, int[] hist, int iw, int ih)
	{	
		double c  = (double)255/(iw*ih);
		double[] sum  = new double[256];
		int[]    outg = new int[256];
		int g,   area = 256*256;
		
		sum[0] = hist[0];
		for(int i = 1; i < 256; i++) 
			sum[i] = sum[i-1] + hist[i];
		
		//灰度变换:i-->outg[i]	
		for(int i = 0; i < 255; i++)
			outg[i]  = (int)(c*sum[i]);
			
		for(int i = 0; i < iw*ih; i++)
		{
			g = pix[i]&0xff;
			pix[i] = 255 << 24|outg[g] <<16|outg[g] << 8|outg[g];			
		}
		return pix;
    }
     
    //滤波=========================================
    
    //3X3阈值滤波
    public int[] threshold(int[] pix, int iw, int ih)
    {
    	int[] opix = new int[iw*ih];
    	int avr,          //灰度平均 
            sum,          //灰度和
            num = 0,      //计数器
            nT  = 4,      //计数器阈值
            T   = 10;     //阈值
        int pij, pkl,     //(i,j),(i+k,j+l)处灰度值
            err;          //误差
            
        for (int j = 1; j < ih - 1; j++)
        {
            for (int i = 1; i < iw - 1; i++)
            {
                //3X3块像素和
                opix[i+j*iw] = pix[i+j*iw];
                sum = 0;
                for (int k = -1; k < 2; k++)
                {
                    for (int l = -1; l < 2; l++)
                    {
                        if ((k != 0) || (l != 0))
                        {
                            pkl = pix[i+k+(j+l)*iw]&0xff; 
                            pij = pix[i+j*iw]&0xff;
                            err = Math.abs(pkl - pij);
                            sum = sum + pkl;
                            if (err > T) num++;
                        }
                    }
                }
                int a = (int)(sum / 8.0f);         //均值
                if (num > nT)
                   opix[i + j * iw] = 255 << 24|a << 16|a << 8|a;                                       
            }
        }
        return opix;
    }
    
    //3X3均值滤波
    public int[] average(int[] pix, int iw, int ih)
    {
        int[] opix = new int[iw*ih];
    	int a, pkl, sum;          
            
        for (int j = 1; j < ih - 1; j++)
        {
            for (int i = 1; i < iw - 1; i++)
            {                
                opix[i+j*iw] = pix[i+j*iw];
                sum = 0;
                //3X3块像素和
                for (int k = -1; k < 2; k++)
                    for (int l = -1; l < 2; l++){
                        pkl = pix[i+k+(j+l)*iw]&0xff;
                        sum = sum + pkl;
                    }       
                a = (int)(sum / 9.0f);         //均值                
                opix[i + j * iw] = 255 << 24|a << 16|a << 8|a;
                
                System.out.println(opix[i+j*iw]);	
            }
        }
        return opix;
    }
    
    //中值滤波===================================
    
    /**************************************************
     * type -- 0: 3X3窗口
     *         1: 1X5窗口
     *         2: 5X1窗口
     *      -- 3: 5X5窗口
     **************************************************/
    public int[] median(int[] pix, int iw, int ih, int type)
    {
        int[] opix = new int[iw*ih];
        
        for (int j = 2; j < ih - 2; j++)
        {
            int[] dt;
            for (int i = 2; i < iw - 2; i++)
            {
            	opix[i+j*iw] = pix[i+j*iw];
                int m = 0, r = 0;
                                    
                if (type == 0)
                {
                    dt = new int[9];

                    //3X3窗口
                    for (int k = -1; k < 2; k++)
                    {
                        for (int l = -1; l < 2; l++)
                        {
                            dt[m] = pix[i+k+(j+l)*iw]&0xff;
                            m++;
                        }
                    }
                    r = median_sorter(dt, 9); //中值                        
                }
                else if (type == 1)
                {
                    dt = new int[5];

                    //1X5窗口
                    dt[0] = pix[i+(j-2)*iw]&0xff;
                    dt[1] = pix[i+(j-1)*iw]&0xff;
                    dt[2] = pix[i+j*iw]&0xff;
                    dt[3] = pix[i+(j+1)*iw]&0xff;
                    dt[4] = pix[i+(j+2)*iw]&0xff;				
                    r = median_sorter(dt, 5);   //中值                        
                }
                else if (type == 2)
                {
                    dt = new int[5];

                    //5X1窗口
                    dt[0] = pix[i-2+j*iw]&0xff;
                    dt[1] = pix[i-1+j*iw]&0xff;
                    dt[2] = pix[i+j*iw]&0xff;
                    dt[3] = pix[i+1+j*iw]&0xff;
                    dt[4] = pix[i+2+j*iw]&0xff;		
                    r = median_sorter(dt, 5);  //中值                      
                }
                else if (type == 3)
                {
                    dt = new int[25];

                    //5X5窗口
                    for (int k = -2; k < 3; k++)
                    {
                        for (int l = -2; l < 3; l++)
                        {
                            dt[m] = pix[i+k+(j+l)*iw]&0xff;
                            m++;
                        }
                    }
                    r = median_sorter(dt, 25); //中值                        
                }
                opix[i + j * iw] = 255 << 24|r << 16|r << 8|r;                 
            }
        }
        return opix;
    }

    //冒泡排序,输出中值
    public int median_sorter(int[] dt, int m)
    {
        int tem;
        for (int k = m - 1; k >= 1; k--)
            for (int l = 1; l <= k; l++)
                if (dt[l - 1] > dt[l])
                {
                    tem = dt[l];
                    dt[l] = dt[l - 1];
                    dt[l - 1] = tem;
                }
        return dt[(int)(m / 2)];
    }
    
    //模板滤波=====================================
          
    //3X3低通滤波方法
	public int[] lowpass(int[] pix, int iw, int ih, int n)
	{		
		int[] opix = new int[iw*ih];
		
		//定义扩展输入图像矩阵
		int[][] ex_inpix = exinpix(pix, iw, ih);
		
		int r = 0, sum;
		
		//低通模板		
		int[][] h = low_matrix(n);
		
		//低通滤波
		for(int j = 1; j < ih+1; j++)	
		{
			for(int i = 1; i < iw+1; i++)	
			{
				//求3X3窗口9个像素加权和
			    sum = 0;
				for(int k =- 1; k <= 1; k++)
					for(int l =- 1; l <= 1; l++)					
						sum = sum + h[k+1][l+1]*ex_inpix[i+k][j+l];							
			
				if(n == 0)
				    r = (int)(sum/9);       //h1平均值
				else if(n == 1)
				    r = (int)(sum/10);      //h2平均值
				else if(n == 2)
				    r = (int)(sum/16);      //h3平均值   	
																			
				opix[(i-1)+(j-1)*iw] = 255 << 24|r << 16|r << 8|r;
			}
		}
		return opix;	
	}
	
	//3X3高通滤波方法
	public int[] highpass(int[] pix, int iw, int ih, int n)
	{		
		int[] opix = new int[iw*ih];
		
		//定义扩展输入图像矩阵
		int[][] ex_inpix = exinpix(pix, iw, ih);
		
		//高通模板				
        int[][] H = high_matrix(n);
                
		//高通滤波
		for(int j = 1; j < ih+1; j++)	
		{
			for(int i = 1; i < iw+1; i++)	
			{
				int r = 0, sum = 0 ;								
				
			    //求3X3窗口9个像素加权和
				for(int k =- 1; k <= 1; k++)
					for(int l =- 1; l <= 1; l++)					
						sum = sum + H[k+1][l+1]*ex_inpix[i+k][j+l];							
				
				if(n == 3)
				    r = (int)(sum/7);      //H4平均值
				else if(n == 4)
				    r = (int)(sum/2);      //H5
				else
				    r = sum;               //H1~H3   
				if(r > 255)     r = 255;
				else if( r < 0) r = 0;												
				opix[(i-1)+(j-1)*iw] = 255 << 24|r << 16|r << 8|r;
			}
		}
		return opix;	
	}
		
	//定义扩展输入图像矩阵
    public int[][] exinpix(int[] pix, int iw, int ih)
    {   
        int[][] ex_inpix = new int[iw+2][ih+2];
        
        //获取非边界灰度值
		for(int j = 0; j < ih; j++)	
			for(int i = 0; i < iw; i++)				
				ex_inpix[i+1][j+1] = pix[i+j*iw]&0xff;
			
		//四角点处理
		ex_inpix[0][0] = ex_inpix[1][1];
		ex_inpix[0][ih+1] = ex_inpix[1][ih];
		ex_inpix[iw+1][0] = ex_inpix[iw][1];
		ex_inpix[iw+1][ih+1] = ex_inpix[iw][ih];
		
		//上下边界处理
		for(int j = 1; j < ih + 1; j++){
			ex_inpix[0][j]    = ex_inpix[1][j]; //上边界 
			ex_inpix[iw+1][j] = ex_inpix[iw][j];//下边界
		}
		  
		//左右边界处理
		for(int i = 1; i < iw + 1; i++){
			ex_inpix[i][0]    = ex_inpix[i][1]; //左边界 
			ex_inpix[i][ih+1] = ex_inpix[i][ih];//右边界
		}
		return ex_inpix;
	}
	
	//低通滤波模板
	public int[][] low_matrix(int n)
	{
		int[][] h = new int[3][3];
	    if(n == 0)//h1
	    {
	    	h[0][0] = 1; h[0][1] = 1; h[0][2] = 1;
	    	h[1][0] = 1; h[1][1] = 1; h[1][2] = 1;
	    	h[2][0] = 1; h[2][1] = 1; h[2][2] = 1;
	    }
	    else if(n == 1)//h2
	    {
	    	h[0][0] = 1; h[0][1] = 1; h[0][2] = 1;
	    	h[1][0] = 1; h[1][1] = 2; h[1][2] = 1;
	    	h[2][0] = 1; h[2][1] = 1; h[2][2] = 1;
	    }	
	    else if(n == 2)//h3
	    {
	    	h[0][0] = 1; h[0][1] = 2; h[0][2] = 1;
	    	h[1][0] = 2; h[1][1] = 4; h[1][2] = 2;
	    	h[2][0] = 1; h[2][1] = 2; h[2][2] = 1;
	    }
	    return h;
	}
	
	//高通滤波模板 
	public int[][] high_matrix(int n)
	{
		int[][] H = new int[3][3];
	    if(n == 0)//H1
	    {
	    	H[0][0] =  0; H[0][1] = -1; H[0][2] =  0;
	    	H[1][0] = -1; H[1][1] =  5; H[1][2] = -1;
	    	H[2][0] =  0; H[2][1] = -1; H[2][2] =  0;
	    }
	    else if(n == 1)//H2
	    {
	    	H[0][0] = -1; H[0][1] = -1; H[0][2] = -1;
	    	H[1][0] = -1; H[1][1] =  9; H[1][2] = -1;
	    	H[2][0] = -1; H[2][1] = -1; H[2][2] = -1;
	    }	
	    else if(n == 2)//H3
	    {
	    	H[0][0] = 1;  H[0][1] = -2; H[0][2] = 1;
	    	H[1][0] = -2; H[1][1] =  5; H[1][2] = -2;
	    	H[2][0] = 1;  H[2][1] = -2; H[2][2] = 1;
	    }
	    else if(n == 3)//H4
	    {
	    	H[0][0] = -1; H[0][1] = -2; H[0][2] = -1;
	    	H[1][0] = -2; H[1][1] = 19; H[1][2] = -2;
	    	H[2][0] = -1; H[2][1] = -2; H[2][2] = -1;
	    }
	    else if(n == 4)//H5
	    {
	    	H[0][0] = -2; H[0][1] = 1; H[0][2] = -2;
	    	H[1][0] =  1; H[1][1] = 6; H[1][2] =  1;
	    	H[2][0] = -2; H[2][1] = 1; H[2][2] = -2;
	    }
	    return H;
	}

}