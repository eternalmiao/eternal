package cn.bug.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T>
{
	protected Connection conn;
	protected PreparedStatement pst;
	ResultSet rs=null;
	protected Connection getConnection(){
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","vincent","123456");
		} catch (ClassNotFoundException e)
		{
			System.out.println("驱动加载失败！"+e.getMessage());
		} catch (SQLException e)
		{
			System.out.println("数据库链接失败！"+e.getMessage());
		}
		return conn;
	}
	
	/**
	 * 
	 * 更新操作
	 * @return
	 */
	protected int executUpdate(String sql,Object...obj){
		try
		{
			pst = getConnection().prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					pst.setObject(i+1, obj[i]);
				}
			}
			return pst.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println("创建Prepare实例失败！"+e.getMessage());
		}finally{
			this.closeAll(null, pst, conn);
		}		
		return 0;
	}
	/**
	 * 查询通用语句，返回resultset结果
	 */
	protected ResultSet executeQuery(String sql,Object...obj){
		try
		{
			pst= getConnection().prepareStatement(sql);
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					pst.setObject(i+1, obj[i]);
				}
			}
			return pst.executeQuery();
		} catch (SQLException e)
		{
			System.out.println("创建Prepare实例失败！"+e.getMessage());
		}
		return null;
	}
	protected List<T> executQuery(String sql,Object...obj)
	{
		List<T> list=new ArrayList<T>();		
			try {
				pst=getConnection().prepareStatement(sql);
				if(obj!=null){
					for(int i=0;i<obj.length;i++){
						pst.setObject(i+1, obj[i]);
					}
				}
				rs=pst.executeQuery();
				while(rs.next()){
					list.add(this.getEntity(rs));//调用的子类的重写方法 
				}
			} catch (Exception e) {
				System.out.println("创建Prepare实例失败！"+e.getMessage());
			}finally{
				this.closeAll(rs, pst, conn);
			}
		
		return list;
	}
	
	/**
	 * 获取总记录数
	 * @param rs
	 * @return
	 */
	protected int getCount(String sql,Object...obj){
		try
		{
			pst = getConnection().prepareStatement("select count(*) from ("+sql+")");
			if(obj!=null){
				for(int i=0;i<obj.length;i++){
					pst.setObject(i+1, obj[i]);
				}
			}
			rs = pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e)
		{
			System.out.println("创建Prepare实例失败！"+e.getMessage());
		}
		return 0;
	}
	
	/**
	 * 关闭资源
	 * @param rs
	 * @param sta
	 * @param con
	 */
	protected void closeAll(ResultSet rs,Statement sta,Connection con){
		try {
			if(rs!=null){
				rs.close();
			}
			if(sta!=null){
				sta.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public abstract T getEntity(ResultSet rs);
}
