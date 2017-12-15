package cn.wsg.iovyw_search.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 持久层
 * @author zhuzhijie
 *
 */
public class SearchDao {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 得到连接
	 * @return
	 */
	private Connection getConnection() {
		// 连接mysql数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://mt.iovyw.com:33060/e3g", "root", "maipue3g");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 通过sn查询dn
	 */
	public String findDnBySn(String sn) {
		String dn = null;
		try {
			connection = this.getConnection();
			// 执行的sql语句
			String sql = "select d.sn,c.dn from e3g_device d,e3g_customer c where d.company=c.id and d.del=0 and d.sn=?";
			// 创建预编译对象
			ps = connection.prepareStatement(sql);
			ps.setString(1, sn);
			rs = ps.executeQuery();
			// 从结果集中取内容
			while (rs.next()) {
				dn = rs.getString("dn");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dn;
	}
	
	/**
	 * 通过IMSI查询dn
	 */
	public String findDnByIMSI(String imsi) {
		String dn = null;
		try {
			connection = this.getConnection();
			// 执行的sql语句
			String sql = "select s.imsi,c.dn from e3g_sim s,e3g_customer c where s.company=c.id and s.del=0 and s.imsi=?";
			// 创建预编译对象
			ps = connection.prepareStatement(sql);
			ps.setString(1, imsi);
			rs = ps.executeQuery();
			// 从结果集中取内容
			while (rs.next()) {
				dn = rs.getString("dn");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭连接
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dn;
	}

}
