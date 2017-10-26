package cn.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Assortment;
import cn.bean.Function;
import cn.bean.Mail;
import cn.bean.User;
import cn.dao.AssortmentDao;
import cn.dao.FunctionDao;
import cn.util.BayesFilter;
import cn.util.BlackFilter;
import cn.util.KeywordFilter;
import cn.util.WhiteFilter;

public class FilterAction extends ActionSupport {
	private AssortmentDao assortmentDao;
	private FunctionDao functionDao;
	private WhiteFilter whiteFilter;
	private BlackFilter blackFilter;
	private KeywordFilter keywordFilter;
	private BayesFilter bayesFilter;

	public AssortmentDao getAssortmentDao() {
		return assortmentDao;
	}

	public void setAssortmentDao(AssortmentDao assortmentDao) {
		this.assortmentDao = assortmentDao;
	}

	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	public WhiteFilter getWhiteFilter() {
		return whiteFilter;
	}

	public void setWhiteFilter(WhiteFilter whiteFilter) {
		this.whiteFilter = whiteFilter;
	}

	public BlackFilter getBlackFilter() {
		return blackFilter;
	}

	public void setBlackFilter(BlackFilter blackFilter) {
		this.blackFilter = blackFilter;
	}

	public KeywordFilter getKeywordFilter() {
		return keywordFilter;
	}

	public void setKeywordFilter(KeywordFilter keywordFilter) {
		this.keywordFilter = keywordFilter;
	}

	public BayesFilter getBayesFilter() {
		return bayesFilter;
	}

	public void setBayesFilter(BayesFilter bayesFilter) {
		this.bayesFilter = bayesFilter;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Mail> list = (List<Mail>)ActionContext.getContext().getSession().get("list");
		Function function = functionDao.findFunction(user);
		if(function != null && list !=null) {
			for(int i=0; i<list.size(); i++) {
				String tag = "";
				//白名单过滤				
				if(function.getWhite()==1) {
					if(whiteFilter.filter(list.get(i),user) == "spam") {
						tag = "spam";
					} else {
						tag = "normal";
					}
				} else {
					//黑名单过滤
					if(function.getBlack()==1 && blackFilter.filter(list.get(i), user) == "spam") {
						tag = "spam";
					//关键字过滤
					} else if(function.getKeyword()==1 && keywordFilter.filter(list.get(i), user) == "spam") {
						tag = "spam";
					//贝叶斯过滤
					} else if(function.getBayes()==1 && bayesFilter.filter(list.get(i)) == "spam") {
						tag = "spam";
					} else {
						tag = "normal";
					}	
				}

				Assortment assortment = new Assortment(list.get(i), tag);
				assortmentDao.insertAssortment(assortment);	
			}
		} 

		return super.execute();
	}
}
