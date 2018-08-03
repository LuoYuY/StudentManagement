package manage.dao;


import java.sql.*;
import java.util.ArrayList;

import manage.model.Course;
import manage.model.Reports;
import manage.model.Score;
import manage.model.Student;
import manage.model.Teach;

public class StudentDao extends BaseDao {

	//查询学生个人信息
	public Student queryStudent(String luoyy_sno) {
		String sql = "SELECT * FROM luoyy_Students WHERE luoyy_sno=?";
		Student student = null;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,luoyy_sno);
			ResultSet rst = pstmt.executeQuery();
				if(rst.next()) {
					
					student = new Student();
					
					
					student.setLuoyy_sno(rst.getString("luoyy_sno"));
					student.setLuoyy_sname(rst.getString("luoyy_sname"));
					student.setLuoyy_ssex(rst.getString("luoyy_ssex"));
					student.setLuoyy_sbirthday(rst.getString("luoyy_sbirthday"));
					student.setLuoyy_birthplace(rst.getString("luoyy_birthplace"));
					student.setLuoyy_scredit(rst.getInt("luoyy_scredit"));
					student.setLuoyy_mno(rst.getString("luoyy_mno"));
					student.setLuoyy_classno(rst.getString("luoyy_classno"));
					
				}
				return student;
		} catch (SQLException se) {
			return null;
		}
	}
	
	//查询教师授课信息
	public ArrayList<Teach> queryTeach(String luoyy_tno) {
		String sql = "SELECT * FROM luoyy_TeachInfo WHERE 编号=?";
		ArrayList<Teach> list = new ArrayList<Teach>();
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,luoyy_tno);
			ResultSet rst = pstmt.executeQuery();
				while(rst.next()) {
					
					Teach teach = new Teach();
					teach.setLuoyy_tno(rst.getString("编号"));
					teach.setLuoyy_tname(rst.getString("姓名"));
					teach.setLuoyy_cno(rst.getString("课程号"));
					teach.setLuoyy_cname(rst.getString("课程名"));
					teach.setLuoyy_term(rst.getString("授课学期"));
					list.add(teach);
				}
				return list;
		} catch (SQLException se) {
			return null;
		}
	}
	
	
	//更新学生操作
	public boolean updateStudent(Student student) {
		String sql = "UPDATE luoyy_Students SET luoyy_sname=?,luoyy_ssex=?,luoyy_sbirthday=?,luoyy_birthplace=?,luoyy_scredit=?,luoyy_mno=?,luoyy_classno=? WHERE luoyy_sno=?";
		try (Connection conn = dataSource.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, student.getLuoyy_sname());
			pstmt.setString(2, student.getLuoyy_ssex());
			pstmt.setString(3, student.getLuoyy_sbirthday());
			pstmt.setString(4, student.getLuoyy_birthplace());
			pstmt.setInt(5, student.getLuoyy_scredit());
			pstmt.setString(6, student.getLuoyy_mno());
			pstmt.setString(7, student.getLuoyy_classno());
			pstmt.setString(8,student.getLuoyy_sno());
			int res = pstmt.executeUpdate();
			return true;
		}
		 catch (SQLException se) {
			return false;
		}
		
	}
	
	

	//查询课表
	public ArrayList<Course> queryMyCourses(String luoyy_sno,String luoyy_term) {
		String sql = null;
		ArrayList<Course> list = new ArrayList<Course>();
		if(luoyy_term.equals("all")) {
			sql = "SELECT *\r\n" + 
					"FROM luoyy_Courses\r\n" + 
					"WHERE luoyy_Courses.luoyy_cno IN\r\n" + 
					"(SELECT DISTINCT luoyy_cno\r\n" + 
					"FROM luoyy_SetupCourse,luoyy_Students\r\n" + 
					"WHERE luoyy_Students.luoyy_mno = luoyy_SetupCourse.luoyy_mno and luoyy_Students.luoyy_classno = luoyy_SetupCourse.luoyy_classno AND luoyy_sno=?)\r\n" + 
					" ";
		}
		else {
			 sql = "SELECT *\r\n" + 
					"FROM luoyy_Courses\r\n" + 
					"WHERE luoyy_Courses.luoyy_cno IN\r\n" + 
					"(SELECT DISTINCT luoyy_cno\r\n" + 
					"FROM luoyy_SetupCourse,luoyy_Students\r\n" + 
					"WHERE luoyy_Students.luoyy_mno = luoyy_SetupCourse.luoyy_mno and luoyy_Students.luoyy_classno = luoyy_SetupCourse.luoyy_classno AND luoyy_sno=? AND luoyy_term=?)\r\n" + 
					" ";
		}
		
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			
			pstmt.setString(1,luoyy_sno);
			if(!luoyy_term.equals("all")) pstmt.setString(2,luoyy_term);
			ResultSet rst = pstmt.executeQuery();
			
			while (rst.next()) {
				
				Course course = new Course();
				course.setLuoyy_cno(rst.getString("luoyy_cno"));
				course.setLuoyy_cname(rst.getString("luoyy_cname"));
				course.setLuoyy_ctime(rst.getInt("luoyy_ctime"));
				course.setLuoyy_ctype(rst.getString("luoyy_ctype"));
				course.setLuoyy_ccredit(rst.getInt("luoyy_ccredit"));
				list.add(course);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	//查成绩
	public ArrayList<Score> queryMyScore(String luoyy_sno,String luoyy_term) {
		ArrayList<Score> list = new ArrayList<Score>();
		String sql = null;
		if(!luoyy_term.equals("all")) {
		sql = "SELECT 学号,课程名,学期,luoyy_tname,得分\r\n" + 
				"FROM luoyy_RankAndEqual,luoyy_Teachers\r\n" + 
				"WHERE 学号=? and 学期=? and luoyy_RankAndEqual.教师编号 = luoyy_Teachers.luoyy_tno";}
		else {
			sql = "SELECT 学号,课程名,学期,luoyy_tname,得分\r\n" + 
					"FROM luoyy_RankAndEqual,luoyy_Teachers\r\n" + 
					"WHERE 学号=? and luoyy_RankAndEqual.教师编号 = luoyy_Teachers.luoyy_tno";
		}
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1,luoyy_sno);
			if(!luoyy_term.equals("all")) {
				pstmt.setString(2,luoyy_term);
			}
			ResultSet rst = pstmt.executeQuery();
			
			while (rst.next()) {
				Score score = new Score();
				score.setLuoyy_sno(rst.getString("学号"));
				score.setLuoyy_cname(rst.getString("课程名"));
				score.setLuoyy_term(rst.getString("学期"));
				score.setLuoyy_tname(rst.getString("luoyy_tname"));
				score.setLuoyy_score(rst.getInt("得分"));
				list.add(score);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	//查班级开设课程信息
	public ArrayList<Course> queryCourses(String luoyy_classno, String luoyy_mno, String luoyy_term) {
		
				ArrayList<Course> list = new ArrayList<Course>();
		String sql = "SELECT * FROM luoyy_ClassAndCourse WHERE luoyy_classno=? and luoyy_mno=? and luoyy_term=?";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1,luoyy_classno);
			pstmt.setString(2,luoyy_mno);
			pstmt.setString(3,luoyy_term);
			ResultSet rst = pstmt.executeQuery();
			
			while (rst.next()) {
				Course course = new Course();
				course.setLuoyy_cno(rst.getString("luoyy_cno"));
				course.setLuoyy_cname(rst.getString("luoyy_cname"));
				course.setLuoyy_ctime(rst.getInt("luoyy_ctime"));
				course.setLuoyy_ctype(rst.getString("luoyy_ctype"));
				course.setLuoyy_ccredit(rst.getInt("luoyy_ccredit"));
				list.add(course);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	}

	public ArrayList<Student> queryAllStudent(String luoyy_mno, String luoyy_classno, String luoyy_sno) {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = null;
		
		
		try (Connection conn = dataSource.getConnection();) {
			System.out.println("luoyy_mno"+luoyy_mno);
			System.out.println("luoyy_classno"+luoyy_classno);
			System.out.println("luoyy_sno"+luoyy_sno);
			
			PreparedStatement pstmt = null;
			 if(!luoyy_sno.equals("")){ 
					System.out.println("in   1");
					sql = "SELECT * FROM luoyy_Students WHERE luoyy_sno=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, luoyy_sno);
				}
			 else if(!luoyy_mno.equals("all") ) {
				 if(luoyy_classno.equals("all")) {
					 System.out.println("in   2");
					 sql = "SELECT * FROM luoyy_Students WHERE luoyy_mno=?";
					 pstmt = conn.prepareStatement(sql);
					 pstmt.setString(1, luoyy_mno);
				 }
				 else {
					 System.out.println("in   3");
						sql = "SELECT * FROM luoyy_Students WHERE luoyy_mno=? and luoyy_classno=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, luoyy_mno);
						pstmt.setString(2, luoyy_classno);
				 }
			}
			else {
				if(luoyy_classno.equals("all")) {
					System.out.println("in   4");
					sql = "SELECT * FROM luoyy_Students";
					pstmt = conn.prepareStatement(sql);
				}
				else return null;
			}
			
			
			
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setLuoyy_sno(rst.getString("luoyy_sno"));
				student.setLuoyy_sname(rst.getString("luoyy_sname"));
				student.setLuoyy_ssex(rst.getString("luoyy_ssex"));
				student.setLuoyy_sbirthday(rst.getString("luoyy_sbirthday"));
				student.setLuoyy_birthplace(rst.getString("luoyy_birthplace"));
				student.setLuoyy_scredit(rst.getInt("luoyy_scredit"));
				student.setLuoyy_mno(rst.getString("luoyy_mno"));
				student.setLuoyy_classno(rst.getString("luoyy_classno"));
				list.add(student);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
