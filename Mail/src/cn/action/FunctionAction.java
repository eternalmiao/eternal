package cn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Function;
import cn.bean.User;

import cn.dao.FunctionDao;

public class FunctionAction extends ActionSupport {
	private FunctionDao functionDao;
	private Function func;
	private String white="0";
	private String black="0";
	private String keyword="0";
	private String bayes="0";
	
	public FunctionDao getFunctionDao() {
		return functionDao;
	}
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}
	public String getWhite() {
		return white;
	}
	public void setWhite(String white) {
		this.white = white;
	}
	public String getBlack() {
		return black;
	}
	public void setBlack(String black) {
		this.black = black;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBayes() {
		return bayes;
	}
	public void setBayes(String bayes) {
		this.bayes = bayes;
	}
	
	public Function getFunc() {
		return func;
	}
	public void setFunc(Function func) {
		this.func = func;
	}
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		func = functionDao.findFunction(user);
		if(func == null) {
			func.setUser(user);
			functionDao.insertFunction(func);
		}
		return super.execute();
	}
	
	public String change() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		func.setUser(user);
		if(white.equals("0/")) {
			func.setWhite(0);
		} else {
			func.setWhite(1);
		}
		
		if(black.equals("0/")) {
			func.setBlack(0);
		} else {
			func.setBlack(1);
		}
		
		if(keyword.equals("0/")) {
			func.setKeyword(0);
		} else {
			func.setKeyword(1);
		}
		
		if(bayes.equals("0/")) {
			func.setBayes(0);
		} else {
			func.setBayes(1);
		}
		functionDao.insertFunction(func);
		return super.execute();
	}
}
