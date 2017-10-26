package cn.bug.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bug.bean.Manager;

public class MgrLoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request  = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		Manager mgr = (Manager) request.getSession().getAttribute("mgr");
		if(mgr!=null){
			arg2.doFilter(request, response);
		}else{
			response.sendRedirect("mgrlogin.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
