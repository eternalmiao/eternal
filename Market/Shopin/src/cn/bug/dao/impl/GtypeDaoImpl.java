package cn.bug.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bug.bean.Gtype;
import cn.bug.dao.GtypeDao;
import cn.bug.util.BaseDao;

public class GtypeDaoImpl extends BaseDao<Gtype> implements GtypeDao {

	@Override
	public List<Gtype> FindAllGtype() {
		String sql = "select * from gtype";
		List<Gtype> list = executQuery(sql);
		return list;
	}

	@Override
	public Gtype FindGtypeByGid(int tid) {
		String sql = "select * from gtype where tid = ?";
		ResultSet res = executeQuery(sql, tid);
		Gtype gtype =null;
		try {
			while(res.next()){
				gtype = getEntity(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(res, null, null);
		}
		return gtype;
	}

	@Override
	public Gtype getEntity(ResultSet rs) {
		Gtype gtype = null;
		try {
				gtype = new Gtype();
				gtype.setTid(rs.getInt(1));
				gtype.setTname(rs.getString(2));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return gtype;

	}

}
