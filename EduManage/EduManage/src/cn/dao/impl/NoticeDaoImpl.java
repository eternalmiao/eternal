package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bean.Notice;
import cn.dao.NoticeDao;
import cn.dbc.BaseDao;

public class NoticeDaoImpl implements NoticeDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	@Override
	public boolean updateNotice(Notice notice) {
		String sql = "update notice set stucontent=?,teacontent=?";
		List<Object> parms =  new ArrayList<>();
		parms.add(notice.getStucontent());
		parms.add(notice.getTeacontent());
		return BaseDao.operUpdate(sql, parms);
	}

	@Override
	public Notice findNotice() {
		Notice notice = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql ="select * from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				notice = new Notice();
				notice.setStucontent(rs.getString(1));
				notice.setTeacontent(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.close(conn, pstmt, rs);
		}
		return notice;
	}

}
