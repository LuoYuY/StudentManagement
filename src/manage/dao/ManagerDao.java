package manage.dao;


import java.sql.*;

import java.util.HashMap;
import java.util.Map;

import manage.model.Student;
import manage.model.TeachInfo;
import manage.model.Teacher;

public class ManagerDao extends BaseDao {
	//删除学生
	public int deleteStudent(String luoyy_mno, String luoyy_classno, String luoyy_sno)
	{
		String sql = null;
		
		try (Connection conn = dataSource.getConnection();) {
			PreparedStatement pstmt = null;
			
			if(!luoyy_sno.equals("")){ 
				sql = "DELETE FROM luoyy_Students WHERE luoyy_sno=?";
				 pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, luoyy_sno);
			}
		 else if(!luoyy_mno.equals("all") ) {
			 if(luoyy_classno.equals("all")) {
				 sql = "DELETE FROM luoyy_Students WHERE luoyy_mno=?";
				 pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, luoyy_mno);
			 }
			 else {
				
				 sql = "DELETE FROM luoyy_Students WHERE luoyy_mno=? and luoyy_classno=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, luoyy_mno);
					pstmt.setString(2, luoyy_classno);
			 }
		}
		else {
			return 0;
		}
			int res = pstmt.executeUpdate();
			System.out.println("删除的行数"+res);;
			return res;
		} catch (SQLException se) {
			return 0;
		}
	}
	
	//删除教师
	public boolean deleteTeacher(String id)
	{
		String sql = "DELETE FROM luoyy_Teachers WHERE luoyy_tno=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			int res = pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			return false;
		}
	}

	//增加学生
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO luoyy_Students VALUES(?,?,?,?,?,?,?,?)";
		String sql2 = "exec PRO_createStudentUser ?";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
			pstmt.setString(1, student.getLuoyy_sno());
			pstmt.setString(2, student.getLuoyy_sname());
			pstmt.setString(3, student.getLuoyy_ssex());
			pstmt.setString(4, student.getLuoyy_sbirthday());
			pstmt.setString(5, student.getLuoyy_birthplace());
			pstmt.setInt(6, student.getLuoyy_scredit());
			pstmt.setString(7, student.getLuoyy_mno());
			pstmt.setString(8, student.getLuoyy_classno());
			pstmt2.setString(1, student.getLuoyy_sno());
			
			pstmt.executeUpdate();
			pstmt2.execute();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	//增加教师
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO luoyy_Teachers VALUES(?,?,?,?,?,?)";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teacher.getLuoyy_tno());
			pstmt.setString(2, teacher.getLuoyy_tname());
			pstmt.setString(3, teacher.getLuoyy_tsex());
			pstmt.setString(4, teacher.getLuoyy_tbirthday());
			pstmt.setString(5, teacher.getLuoyy_profess());
			pstmt.setString(6, teacher.getLuoyy_tel());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	
	
	
	//查询生源人数
	public Map<String,Integer> showArea(){

		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT * FROM luoyy_Areapop";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
			while (rst.next()) {
				map.put(rst.getString("生源地"),new Integer(rst.getInt("人数")));
			}
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	



	public boolean addTeachInfo(TeachInfo teachinfo) {
		String sql = "INSERT INTO luoyy_Teach VALUES(?,?,?,?,?)";
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, teachinfo.getLuoyy_tno());
			pstmt.setString(2, teachinfo.getLuoyy_cno());
			pstmt.setString(3, teachinfo.getLuoyy_term());
			pstmt.setString(4, teachinfo.getLuoyy_classno());
			pstmt.setString(5, teachinfo.getLuoyy_mno());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
