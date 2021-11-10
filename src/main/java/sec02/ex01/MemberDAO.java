package sec02.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	public boolean overlappedID(String id) {
		
		boolean result = false;
		
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			DataSource dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
			Connection con = dataFactory.getConnection();
			
			String query = "select decode(count(*),1,'true','false') as result from t_member";
			query +=" where id=?";
			System.out.println("prepareStatement : "+query);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			
			rs.close();
			pstmt.close();
			con.close();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
}


