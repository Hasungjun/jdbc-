package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.douzon.jdbc.bookshop.vo.BookVo;

import employee.vo.EmployeeVo;

public class EmployeeDao {
	
	
	
	
public boolean select(String name) {
		
		EmployeeVo vo = new EmployeeVo();
		vo.setName(name);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql =
				"select * from employee where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			rs = pstmt.executeQuery();
			boolean count = pstmt.execute(); 
			while(rs.next()) {
				long no = rs.getLong(1);
				String name2 = rs.getString(2);
				String email = rs.getString(3);
				String cell = rs.getString(4);
				Date hire = rs.getDate(5);
				
				System.out.println(name2+ " " + email +" "+ cell +" "+ hire);
				
			}
			
			result = count;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


public boolean select(int low,int high) {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean result = false;
	try {
		conn = getConnection();
		String sql =
			"select name, money from employee where money >= ? and money <= ? order by money";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, low);
		pstmt.setInt(2, high);	
		rs = pstmt.executeQuery();
		boolean count = pstmt.execute(); 
		
		while(rs.next()) {
			String name = rs.getString(1);
			int money = rs.getInt(2);
			
			System.out.println(name+ " " + money);
			
		}
		
		result = count;
	} catch (SQLException e) {
		System.out.println("error:" + e);
	} finally {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return result;
}

	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}
	
	
}
