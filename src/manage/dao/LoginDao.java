package manage.dao;
import java.sql.*;

public class LoginDao extends BaseDao {
	
	public boolean checkStudent(String luoyy_sno,String luoyy_scode)
	{
		String sql = "SELECT * FROM luoyy_snc WHERE luoyy_sno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, luoyy_sno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				
				if(rst.getString("luoyy_scode").trim().equals(luoyy_scode)) 
					{
						
						return true;
					
					}
			}
			return false;
		} catch (SQLException se) {
			return false;
		}
	}

	public boolean checkTeacher(String luoyy_tno,String luoyy_tcode) {
		String sql = "SELECT * FROM luoyy_tnc WHERE luoyy_tno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, luoyy_tno);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				if(rst.getString("luoyy_tcode").trim().equals(luoyy_tcode)) return true;
			}
			return false;
		} catch (SQLException se) {
			return false;
		}
	}
	
}
