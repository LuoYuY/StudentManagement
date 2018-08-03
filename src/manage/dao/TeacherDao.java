package manage.dao;


import java.sql.*;
import java.util.ArrayList;

import manage.model.Course;
import manage.model.NameScore;
import manage.model.Rank;
import manage.model.Reports;
import manage.model.Teach;
import manage.model.Teacher;

public class TeacherDao extends BaseDao {
	

	
	
	//查询教师个人信息
	public Teacher queryTeacher(String luoyy_tno) {
		String sql = "SELECT * FROM luoyy_Teachers WHERE luoyy_tno=?";
		Teacher teacher = null;
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,luoyy_tno);
			ResultSet rst = pstmt.executeQuery();
				if(rst.next()) {
					teacher = new Teacher();
					teacher.setLuoyy_tno(rst.getString("luoyy_tno"));
					teacher.setLuoyy_tname(rst.getString("luoyy_tname"));
					teacher.setLuoyy_tsex(rst.getString("luoyy_tsex"));
					teacher.setLuoyy_tbirthday(rst.getString("luoyy_tbirthday"));
					teacher.setLuoyy_profess(rst.getString("luoyy_profess"));
					teacher.setLuoyy_tel(rst.getString("luoyy_tel"));
				}
				return teacher;
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
			System.out.println(sql);
				while(rst.next()) {
					Teach teach = new Teach();
					teach.setLuoyy_tno(rst.getString("编号"));
					teach.setLuoyy_tname(rst.getString("姓名"));
					teach.setLuoyy_cno(rst.getString("课程号"));
					teach.setLuoyy_cname(rst.getString("课程名"));
					teach.setLuoyy_term(rst.getString("授课学期"));
					teach.setLuoyy_mno(rst.getString("专业号"));
					teach.setLuoyy_classno(rst.getString("班级号"));
					
					list.add(teach);
				}
				return list;
		} catch (SQLException se) {
			return null;
		}
	}
	
	
	

	//插入成绩
	public boolean insertReports(Reports reports) {
		
			String sql = "INSERT INTO luoyy_Reports VALUES(?,?,?,?,?)";
			
			String sql2 = "exec PRO_createCredit ?,?,?,?";
			try (Connection conn = dataSource.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql);
					PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {
				
				pstmt.setString(3, reports.getLuoyy_cno());
				pstmt.setString(1, reports.getLuoyy_term());
				pstmt.setString(4,reports.getLuoyy_tno());
				pstmt.setString(2, reports.getLuoyy_sno());
				pstmt.setInt(5, reports.getLuoyy_score());
				
				pstmt2.setString(3, reports.getLuoyy_cno());
				pstmt2.setString(1, reports.getLuoyy_term());
				pstmt2.setString(4,reports.getLuoyy_tno());
				pstmt2.setString(2, reports.getLuoyy_sno());
				int res = pstmt.executeUpdate();
				pstmt2.execute();
				return true;
			}
			 catch (SQLException se) {
				return false;
			}
			
		
	}

	public ArrayList<Rank> queryRank(String luoyy_cno, String luoyy_term, String luoyy_tno) {

		
		ArrayList<Rank> list = new ArrayList<Rank>();
		String sql = "SELECT 学生姓名,得分 FROM luoyy_RankAndEqual WHERE 课程编号=? and 学期=? and 教师编号=? ORDER BY 得分 desc";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1,luoyy_cno);
			pstmt.setString(2,luoyy_term);
			pstmt.setString(3,luoyy_tno);
			ResultSet rst = pstmt.executeQuery();
			int i=1;
			while (rst.next()) {
				Rank rank = new Rank();
				
				rank.setLuoyy_sname(rst.getString("学生姓名"));
				rank.setLuoyy_score(rst.getInt("得分"));
				
				rank.setNum(i);
				list.add(rank);
				i++;
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public int queryEqual(String luoyy_cno, String luoyy_term, String luoyy_tno) {

		int result = 0;
		String sql = "SELECT AVG(得分) 平均分  FROM luoyy_RankAndEqual \r\n" + 
				"GROUP BY 课程编号,学期,教师编号\r\n" + 
				"HAVING 课程编号=? and 学期=? and 教师编号=?";
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1,luoyy_cno);
			pstmt.setString(2,luoyy_term);
			pstmt.setString(3,luoyy_tno);
			ResultSet rst = pstmt.executeQuery();
			
			if (rst.next()) {
				result = rst.getInt("平均分");
			}
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Course queryCourse(String luoyy_cno) {
		String sql = "SELECT * FROM luoyy_Courses WHERE luoyy_cno=?";
		Course course = null;
		System.out.println("luoyy_cno"+luoyy_cno);
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,luoyy_cno);
			ResultSet rst = pstmt.executeQuery();
				if(rst.next()) {
					System.out.println("find one");
					course = new Course();
					course.setLuoyy_cno(rst.getString("luoyy_cno"));
					course.setLuoyy_cname(rst.getString("luoyy_cname"));
					course.setLuoyy_ctime(rst.getInt("luoyy_ctime"));
					course.setLuoyy_ctype(rst.getString("luoyy_ctype"));
					course.setLuoyy_ccredit(rst.getInt("luoyy_ccredit"));
					
				}
				return course;
		} catch (SQLException se) {
			return null;
		}
	}
	public ArrayList<NameScore> queryNameScore(String luoyy_tno, String luoyy_cno, String luoyy_term,
			String luoyy_mno, String luoyy_classno) {
		String sql = "SELECT * FROM namescore \r\n" + 
				"WHERE luoyy_tno=? and luoyy_cno=? and luoyy_term=? and luoyy_mno=? and luoyy_classno=?";
		ArrayList<NameScore> list = new ArrayList<NameScore>();
	
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,luoyy_tno);
			pstmt.setString(2,luoyy_cno);
			pstmt.setString(3,luoyy_term);
			pstmt.setString(4,luoyy_mno);
			pstmt.setString(5,luoyy_classno);
			
			ResultSet rst = pstmt.executeQuery();
				while(rst.next()) {
					System.out.println("find one");
					NameScore namescore = new NameScore();
					namescore.setLuoyy_sno(rst.getString("luoyy_sno"));
					namescore.setLuoyy_sname(rst.getString("luoyy_sname"));
					namescore.setLuoyy_score(rst.getInt("luoyy_score"));
					list.add(namescore);
				}
				return list;
		} catch (SQLException se) {
			return null;
		}
	}

	public boolean updateReport(Reports report) {
		
		String sql = "UPDATE luoyy_Reports SET luoyy_score=? WHERE luoyy_term=? and luoyy_sno=? and luoyy_cno=? and luoyy_tno=?";
		try (Connection conn = dataSource.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, report.getLuoyy_score());
			pstmt.setString(2, report.getLuoyy_term());
			pstmt.setString(3, report.getLuoyy_sno());
			pstmt.setString(4, report.getLuoyy_cno());
			pstmt.setString(5, report.getLuoyy_tno());
			int res = pstmt.executeUpdate();
			return true;
		}
		 catch (SQLException se) {
			return false;
		}
	}
	
	
}
