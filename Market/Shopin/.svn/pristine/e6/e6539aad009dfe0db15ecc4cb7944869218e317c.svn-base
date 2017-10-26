package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bug.bean.Trend;
import cn.bug.dao.GoodsDao;
import cn.bug.dao.TrendDao;
import cn.bug.util.BaseDao;
/**
 * 
 * @author ffpff
 *
 */
public class TrendDaoImpl extends BaseDao<Trend> implements TrendDao {

	@Override
	public boolean AddTrendDao(Trend trend) {
		// TODO Auto-generated method stub
		String sql="insert into trend (gid) values (?)";
		int num=executUpdate(sql, trend.getGoods().getGid());
		if (num>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean DeleteTrend(int tid) {
		String sql="delete from trend where trid=?";
		int num=executUpdate(sql, tid);
		if (num>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean UpdateTrend(Trend trend) {
		String sql="update trend set gid=? where trid=?";
		int num=executUpdate(sql, trend.getGoods().getGid(),trend.getTid());
		if (num>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Trend> FindAllTrend() {
		String sql="select * from trend";
		List<Trend> list=executQuery(sql);
		return list;
	}

	@Override
	public Trend getEntity(ResultSet rs) {
		// TODO Auto-generated method stub
		GoodsDao gDao = new GoodsDaoImpl();
		Trend trend = null;
		try {
				trend = new Trend();
				trend.setTid(rs.getInt(1));
				trend.setGoods(gDao.findGoodsById(rs.getInt(2)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trend;
	}

}
