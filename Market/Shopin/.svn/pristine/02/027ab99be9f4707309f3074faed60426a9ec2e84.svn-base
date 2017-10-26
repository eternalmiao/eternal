package cn.bug.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.framework.Action;

@SuppressWarnings("serial")
public class Controller extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//通过下列的getAction方法将请求链放入Action中
		//假设提交Login，该步骤类似于   Action action = new LoginServlet();
         Action action=getAction(request);
         //根据子类实现，调用了子类重写的execute方法并传入request和response
         String path=action.execute(request, response);
         //通过返回的路径进行跳转到指定的页面
         request.getRequestDispatcher(path).forward(request, response);
	}
	
	private Action getAction(HttpServletRequest request) 
	{
		Action action=null;
		//获得请求中的路径
		String path=request.getServletPath();
		//通过“/”开始，截取.do结束的中间部分
		String className=path.substring(path.lastIndexOf("/")+1,path.length()-3);
	
		className="cn.bug.action."+className+"Servlet";
		try
		{
			//通过加载路径形成类
			@SuppressWarnings("rawtypes")
			Class clazz=Class.forName(className);
			//通过反射，获取到类的对象
			action=(Action)clazz.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return action;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
         this.doGet(request, response);
	}

}
