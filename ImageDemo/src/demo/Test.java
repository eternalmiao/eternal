package demo;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public class Test extends JFrame implements ActionListener
{        
    Image iImage, iImage2, oImage;
    BufferedImage bImage; 
    String fName;
    
    int   iw, ih;
    int[] pixels;          
             
    boolean loadflag  = false,
            loadflag2 = false,    //第2幅图像载入标志
            runflag   = false,    //图像处理执行标志 
            seeflag   = false;    //预览标志 
    
    //参数选择面板
    Parameters p;
    JButton okButton, seeButton;
	JDialog dialog;  
      
    Common common;
    ImageEnhance enhance;
    
    public Test()
    {    
        setTitle("数字图像处理");
        this.setBackground(Color.lightGray);        
              
        //菜单界面
        setMenu();
        
        common  = new Common();
        enhance = new ImageEnhance();
                
        //关闭窗口
        closeWin();
                
        setSize(530, 330);
        setLocation(700, 10);
        setVisible(true);        
    }

    public void actionPerformed(ActionEvent evt)
    {
    	Graphics graph = getGraphics();
    	      	  
        if (evt.getSource() == openItem) 
        {
        	//文件选择对话框
            JFileChooser chooser = new JFileChooser();
            common.chooseFile(chooser, "./images", 0);//设置默认目录,过滤文件
            int r = chooser.showOpenDialog(null);
                        
            MediaTracker tracker = new MediaTracker(this);
            
            if(r == JFileChooser.APPROVE_OPTION) 
            {  
                String name = chooser.getSelectedFile().getAbsolutePath();

                if(runflag)
                { 
                    loadflag  = false;
                    runflag   = false;
                }   
			    if(!loadflag)
			    {
	                //装载图像
				    iImage = common.openImage(name, tracker);    
				    //取载入图像的宽和高
				    iw = iImage.getWidth(null);
				    ih = iImage.getHeight(null);				    
				    loadflag = true;
				    repaint();				    
			    }	
			    fName = chooser.getSelectedFile().getName();
            }            
        }
        else if (evt.getSource() == stretchItem)
        {
        	setTitle(" 对比度扩展  ");
        	if(loadflag)        	
        	{
        		p = new Parameters();
        	    setPanelI(p, "对比度扩展", 1);
        	    showSpaceEnhance(graph, 0, "对比度扩展");        	    					
			}
        }
        else if (evt.getSource() == balanceItem)
        {
        	setTitle(" 直方图均匀化   ");
        	if(loadflag)        	
        	    showSpaceEnhance(graph, 1, "直方图均匀化");    	    						
		}
        else if (evt.getSource() == histItem)
        {        	
        	if(loadflag)
        	{        		
	            pixels = common.grabber(iImage, iw, ih);
	            
				//显示图像的直方图
				Hist h = new Hist("均匀化前");
				
				//传送数据
				h.getData(pixels, iw, ih);
				h.setLocation(10, 320);								
			}
			if(runflag)
        	{
        		pixels = common.grabber(oImage, iw, ih);
	            
				//显示图像的直方图
				Hist h = new Hist("均匀化后");
				
				//传送数据
				h.getData(pixels, iw, ih);
				h.setLocation(310, 320);
        	}					
        }
        else if(evt.getSource() == seeButton)//预览
        {    
			p = new Parameters();
			common.draw(graph, p.getx1(), p.gety1(), p.getx2(), p.gety2(), 
			            "对比度扩展可视化预览");           	
        }
        else if (evt.getSource() == threshItem)
        {
        	setTitle(" 阈值滤波  ");
        	if(loadflag)       	
        	    showSpaceEnhance(graph, 2, "阈值滤波");        	    
        }
        else if (evt.getSource() == averItem)
        {
        	setTitle(" 均值滤波  ");
        	if(loadflag)       	
        	    showSpaceEnhance(graph, 3, "均值滤波");        	    
        }
        else if (evt.getSource() == medianItem)
        {
        	setTitle(" 中值滤波  ");
        	if(loadflag)        	
        	{
        		p = new Parameters("窗口选择", "3X3", "1X5", "5X1", "5X5");
        	    setPanelI(p, "中值滤波", 0);
        	    showSpaceEnhance(graph, 4, "中值滤波");        	    	   	
        	}
        }
        else if (evt.getSource() == lowItem)
        {
        	setTitle(" 低通模板滤波  ");
        	if(loadflag)
        	{
        		p = new Parameters("模板选择", "h1", "h2", "h3");
        	    setPanelI(p, "低通模板滤波", 0);
        	    showSpaceEnhance(graph, 5, "低通模板滤波");        	    
        	}
        }
        else if (evt.getSource() == highItem)
        {
        	setTitle(" 高通模板滤波  ");
        	if(loadflag)       	
        	{
        	    p = new Parameters("模板选择", "H1", "H2", "H3", "H4", "H5");
        	    setPanelI(p, "高通模板滤波", 0);
        	    showSpaceEnhance(graph, 6, "高通模板滤波");        	    
        	}
        }
        else if (evt.getSource() == okButton)
           	dialog.dispose(); 
        else if (evt.getSource() == exitItem) 
            System.exit(0);       
    }
        
    public void paint(Graphics g) 
    {    	  
        if (loadflag)
        {
        	g.clearRect(0, 0, 260, 350); 
        	g.drawImage(iImage, 5, 50, null);
            g.drawString("原图", 120, 320);
            setBackground(Color.white);
        }             
    }
    
    /*******************************************************
     * type -- 0:仅有一个okButton; 1:有二个Button
     *******************************************************/
    private void setPanelI(Parameters p, String s, int type)
    {
    	JPanel buttonsPanel = new JPanel();
    	dialog = new JDialog(this, s + " 参数选择", true);     
        Container contentPane = getContentPane();
		Container dialogContentPane = dialog.getContentPane();

		dialogContentPane.add(p, BorderLayout.CENTER);
		dialogContentPane.add(buttonsPanel, BorderLayout.SOUTH);
		
		if(type == 1)
		{
		    seeButton    = new JButton("预览");  
	        seeButton.addActionListener(this);		
            buttonsPanel.add(seeButton);
        }
        okButton     = new JButton("确定");				
        okButton.addActionListener(this);
        buttonsPanel.add(okButton);
        dialog.pack();
		dialog.setLocation(0,320);     //设置对话框在屏幕上坐标
        dialog.show();	        
    }
    
    /*************************************************
     * type - 型号. 0:BLPF 1:BHPF 2:ELPF 3:EHPF
     * name - 输出图像标题字符串
     *************************************************/    
    public void showSpaceEnhance(Graphics graph, int type, String name)
    {
    	pixels = common.grabber(iImage, iw, ih);
		switch(type)
		{
			case 0: //对比度扩展
			        int[] pixMap = enhance.pixelsMap(p.getx1(), p.gety1(), 
			                                         p.getx2(), p.gety2()); 
			        pixels = enhance.stretch(pixels, pixMap, iw, ih);
			        break;
			case 1: //直方图均匀化
				    int[] histogram = common.getHist(pixels, iw, ih);//取直方图
				    pixels = enhance.histequal(pixels, histogram, iw, ih);
				    break;		
	        case 2: pixels = enhance.threshold(pixels, iw, ih);
	                break;
	        case 3: pixels = enhance.average(pixels, iw, ih);
	                break;
	        case 4: pixels = enhance.median(pixels, iw, ih, p.getRadioState4());
	                break;
	        case 5: pixels = enhance.lowpass(pixels, iw, ih, p.getRadioState3());
	                break;
	        case 6: pixels = enhance.highpass(pixels, iw, ih, p.getRadioState5());
	                break;
	    }    
	    //将数组中的象素产生一个图像
		ImageProducer ip = new MemoryImageSource(iw, ih, pixels, 0, iw);
		oImage = createImage(ip);
		bImage = new BufferedImage(iw,ih,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = bImage.getGraphics();
		try {
			g.drawImage(oImage, 0, 0, null);
			String format = fName.substring(fName.lastIndexOf(".")+1);
			ImageIO.write(bImage, format, new File("D:\\" + fName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		common.draw(graph, iImage, "原图", oImage, name);
		runflag = true;		
    }
    
    
    public static void main(String[] args) 
    {  
        new Test();        
    }
    
    private void closeWin()
    {
    	addWindowListener(new WindowAdapter()
        {  
            public void windowClosing(WindowEvent e) 
            {  
                System.exit(0);
            }
        });
    }
    
    private void setMenu()
    {
    	//菜单界面
        Menu fileMenu = new Menu("文件");
        openItem = new MenuItem("打开");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        exitItem = new MenuItem("退出");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);
        
        //空域增强---------------------------    
        Menu spaceMenu = new Menu("处理");
        
   
        stretchItem = new MenuItem("对比度扩展");
        stretchItem.addActionListener(this);
        spaceMenu.add(stretchItem);
        
        spaceMenu.addSeparator();        
        balanceItem = new MenuItem("直方图均匀化");
        balanceItem.addActionListener(this);
        spaceMenu.add(balanceItem);
               
        histItem = new MenuItem("显示直方图");
        histItem.addActionListener(this);
        spaceMenu.add(histItem);
        
        spaceMenu.addSeparator();        
        threshItem = new MenuItem("阈值滤波");
        threshItem.addActionListener(this);
        spaceMenu.add(threshItem);
        
        
        averItem = new MenuItem("均值滤波");
        averItem.addActionListener(this);
        spaceMenu.add(averItem);
        
        spaceMenu.addSeparator();        
        medianItem = new MenuItem("中值滤波");
        medianItem.addActionListener(this);
        spaceMenu.add(medianItem);
        
        
        spaceMenu.addSeparator();        
        lowItem = new MenuItem("低通模板滤波");
        lowItem.addActionListener(this);
        spaceMenu.add(lowItem);
        
        highItem = new MenuItem("高通模板滤波");
        highItem.addActionListener(this);
        spaceMenu.add(highItem);

                
        MenuBar menuBar = new MenuBar();
        menuBar.add(fileMenu);
        menuBar.add(spaceMenu);
        setMenuBar(menuBar);
             
    }
    
    MenuItem openItem;
    MenuItem exitItem;
    MenuItem stretchItem;
    MenuItem balanceItem; //均匀化
    MenuItem histItem;    //显示直方图
    
    MenuItem threshItem;
    MenuItem averItem;
    MenuItem medianItem;
    MenuItem lowItem;     //低通模板滤波
    MenuItem highItem;    //高通模板滤波

}
