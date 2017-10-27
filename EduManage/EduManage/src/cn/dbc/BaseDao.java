package cn.dbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest?characterEncoding=utf-8","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	public static boolean operUpdate(String sql,List<Object> parms){
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = null;
			for (int i = 0; i < parms.size(); i++) {
				pstmt.setObject(i+1, parms.get(i));
			}
			int lin = pstmt.executeUpdate();
			if (lin > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		
		return false;
	}
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
