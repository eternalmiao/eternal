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
            loadflag2 = false,    //��2��ͼ�������־
            runflag   = false,    //ͼ����ִ�б�־ 
            seeflag   = false;    //Ԥ����־ 
    
    //����ѡ�����
    Parameters p;
    JButton okButton, seeButton;
	JDialog dialog;  
      
    Common common;
    ImageEnhance enhance;
    
    public Test()
    {    
        setTitle("����ͼ����");
        this.setBackground(Color.lightGray);        
              
        //�˵�����
        setMenu();
        
        common  = new Common();
        enhance = new ImageEnhance();
                
        //�رմ���
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
        	//�ļ�ѡ��Ի���
            JFileChooser chooser = new JFileChooser();
            common.chooseFile(chooser, "./images", 0);//����Ĭ��Ŀ¼,�����ļ�
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
	                //װ��ͼ��
				    iImage = common.openImage(name, tracker);    
				    //ȡ����ͼ��Ŀ�͸�
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
        	setTitle(" �Աȶ���չ  ");
        	if(loadflag)        	
        	{
        		p = new Parameters();
        	    setPanelI(p, "�Աȶ���չ", 1);
        	    showSpaceEnhance(graph, 0, "�Աȶ���չ");        	    					
			}
        }
        else if (evt.getSource() == balanceItem)
        {
        	setTitle(" ֱ��ͼ���Ȼ�   ");
        	if(loadflag)        	
        	    showSpaceEnhance(graph, 1, "ֱ��ͼ���Ȼ�");    	    						
		}
        else if (evt.getSource() == histItem)
        {        	
        	if(loadflag)
        	{        		
	            pixels = common.grabber(iImage, iw, ih);
	            
				//��ʾͼ���ֱ��ͼ
				Hist h = new Hist("���Ȼ�ǰ");
				
				//��������
				h.getData(pixels, iw, ih);
				h.setLocation(10, 320);								
			}
			if(runflag)
        	{
        		pixels = common.grabber(oImage, iw, ih);
	            
				//��ʾͼ���ֱ��ͼ
				Hist h = new Hist("���Ȼ���");
				
				//��������
				h.getData(pixels, iw, ih);
				h.setLocation(310, 320);
        	}					
        }
        else if(evt.getSource() == seeButton)//Ԥ��
        {    
			p = new Parameters();
			common.draw(graph, p.getx1(), p.gety1(), p.getx2(), p.gety2(), 
			            "�Աȶ���չ���ӻ�Ԥ��");           	
        }
        else if (evt.getSource() == threshItem)
        {
        	setTitle(" ��ֵ�˲�  ");
        	if(loadflag)       	
        	    showSpaceEnhance(graph, 2, "��ֵ�˲�");        	    
        }
        else if (evt.getSource() == averItem)
        {
        	setTitle(" ��ֵ�˲�  ");
        	if(loadflag)       	
        	    showSpaceEnhance(graph, 3, "��ֵ�˲�");        	    
        }
        else if (evt.getSource() == medianItem)
        {
        	setTitle(" ��ֵ�˲�  ");
        	if(loadflag)        	
        	{
        		p = new Parameters("����ѡ��", "3X3", "1X5", "5X1", "5X5");
        	    setPanelI(p, "��ֵ�˲�", 0);
        	    showSpaceEnhance(graph, 4, "��ֵ�˲�");        	    	   	
        	}
        }
        else if (evt.getSource() == lowItem)
        {
        	setTitle(" ��ͨģ���˲�  ");
        	if(loadflag)
        	{
        		p = new Parameters("ģ��ѡ��", "h1", "h2", "h3");
        	    setPanelI(p, "��ͨģ���˲�", 0);
        	    showSpaceEnhance(graph, 5, "��ͨģ���˲�");        	    
        	}
        }
        else if (evt.getSource() == highItem)
        {
        	setTitle(" ��ͨģ���˲�  ");
        	if(loadflag)       	
        	{
        	    p = new Parameters("ģ��ѡ��", "H1", "H2", "H3", "H4", "H5");
        	    setPanelI(p, "��ͨģ���˲�", 0);
        	    showSpaceEnhance(graph, 6, "��ͨģ���˲�");        	    
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
            g.drawString("ԭͼ", 120, 320);
            setBackground(Color.white);
        }             
    }
    
    /*******************************************************
     * type -- 0:����һ��okButton; 1:�ж���Button
     *******************************************************/
    private void setPanelI(Parameters p, String s, int type)
    {
    	JPanel buttonsPanel = new JPanel();
    	dialog = new JDialog(this, s + " ����ѡ��", true);     
        Container contentPane = getContentPane();
		Container dialogContentPane = dialog.getContentPane();

		dialogContentPane.add(p, BorderLayout.CENTER);
		dialogContentPane.add(buttonsPanel, BorderLayout.SOUTH);
		
		if(type == 1)
		{
		    seeButton    = new JButton("Ԥ��");  
	        seeButton.addActionListener(this);		
            buttonsPanel.add(seeButton);
        }
        okButton     = new JButton("ȷ��");				
        okButton.addActionListener(this);
        buttonsPanel.add(okButton);
        dialog.pack();
		dialog.setLocation(0,320);     //���öԻ�������Ļ������
        dialog.show();	        
    }
    
    /*************************************************
     * type - �ͺ�. 0:BLPF 1:BHPF 2:ELPF 3:EHPF
     * name - ���ͼ������ַ���
     *************************************************/    
    public void showSpaceEnhance(Graphics graph, int type, String name)
    {
    	pixels = common.grabber(iImage, iw, ih);
		switch(type)
		{
			case 0: //�Աȶ���չ
			        int[] pixMap = enhance.pixelsMap(p.getx1(), p.gety1(), 
			                                         p.getx2(), p.gety2()); 
			        pixels = enhance.stretch(pixels, pixMap, iw, ih);
			        break;
			case 1: //ֱ��ͼ���Ȼ�
				    int[] histogram = common.getHist(pixels, iw, ih);//ȡֱ��ͼ
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
	    //�������е����ز���һ��ͼ��
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
		common.draw(graph, iImage, "ԭͼ", oImage, name);
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
    	//�˵�����
        Menu fileMenu = new Menu("�ļ�");
        openItem = new MenuItem("��");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        exitItem = new MenuItem("�˳�");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);
        
        //������ǿ---------------------------    
        Menu spaceMenu = new Menu("����");
        
   
        stretchItem = new MenuItem("�Աȶ���չ");
        stretchItem.addActionListener(this);
        spaceMenu.add(stretchItem);
        
        spaceMenu.addSeparator();        
        balanceItem = new MenuItem("ֱ��ͼ���Ȼ�");
        balanceItem.addActionListener(this);
        spaceMenu.add(balanceItem);
               
        histItem = new MenuItem("��ʾֱ��ͼ");
        histItem.addActionListener(this);
        spaceMenu.add(histItem);
        
        spaceMenu.addSeparator();        
        threshItem = new MenuItem("��ֵ�˲�");
        threshItem.addActionListener(this);
        spaceMenu.add(threshItem);
        
        
        averItem = new MenuItem("��ֵ�˲�");
        averItem.addActionListener(this);
        spaceMenu.add(averItem);
        
        spaceMenu.addSeparator();        
        medianItem = new MenuItem("��ֵ�˲�");
        medianItem.addActionListener(this);
        spaceMenu.add(medianItem);
        
        
        spaceMenu.addSeparator();        
        lowItem = new MenuItem("��ͨģ���˲�");
        lowItem.addActionListener(this);
        spaceMenu.add(lowItem);
        
        highItem = new MenuItem("��ͨģ���˲�");
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
    MenuItem balanceItem; //���Ȼ�
    MenuItem histItem;    //��ʾֱ��ͼ
    
    MenuItem threshItem;
    MenuItem averItem;
    MenuItem medianItem;
    MenuItem lowItem;     //��ͨģ���˲�
    MenuItem highItem;    //��ͨģ���˲�

}
