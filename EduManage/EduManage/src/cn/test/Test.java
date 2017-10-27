package cn.test;

import java.awt.EventQueue;

import cn.view.LoginView;

public class Test {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LoginView login = new LoginView();
					login.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
