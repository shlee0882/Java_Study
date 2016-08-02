package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestEmployees {

	public static void main(String[] args) {
		
		// 1. Driver Class Loading
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. Connection 객체 생성
		// 오라클에서 쓰는 포트번호 xe db
		// driver type 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		// tnsnames.ora 의 적혀있는 포트번호 1521
		String user = "hr";
		String pass = "hr";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url,user,pass); // connection 인터페이스
			System.out.println(con.getClass().getName()); 
			// 3. Statement 객체 생성
			stmt = con.createStatement(); // Statement 인터페이스
			// new OracleStatementrapper 쓰지않게 하기 위해 종속적으로 쓰지않기위해
			System.out.println(stmt.getClass().getName());
			// 4. SQL문 실행 및 SQL 결과값 처리
			// String sql = "select * from employees where employee_id=100";
			// String sql = "select * from employees order by employee_id";
			// String sql = "select * from employees";
			String sql = "select * from EMPLOYEES order by EMPLOYEE_ID desc";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs.getClass().getName());
			while(rs.next()){ // next()커서 이동, 데이터있으면 true
				System.out.println(rs.getInt("employee_id")+" "+rs.getString("first_name")+" "+rs.getDate("hire_date"));
			}
			// 5. 사용한 resource(connection, statement, resultset) 종료
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{ // 결국에는 궁극적으로는 
			
			try {
				if(stmt != null)stmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
