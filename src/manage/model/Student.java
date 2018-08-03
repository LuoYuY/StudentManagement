package manage.model;

import java.io.Serializable;

public class Student  implements Serializable{
	String luoyy_sno;
	String luoyy_sname;
	String luoyy_ssex;
	String luoyy_sbirthday;
	String luoyy_birthplace ;
	int luoyy_scredit;
	String luoyy_mno;
	String luoyy_classno;
	
	
	
	public Student() {
		super();
	}
	
	public Student(String luoyy_sno, String luoyy_sname, String luoyy_ssex, String luoyy_sbirthday, String luoyy_birthplace,
			int luoyy_scredit,String luoyy_mno,  String luoyy_classno) {
		super();
		this.luoyy_sno = luoyy_sno;
		this.luoyy_sname = luoyy_sname;
		this.luoyy_ssex = luoyy_ssex;
		this.luoyy_sbirthday = luoyy_sbirthday;
		this.luoyy_birthplace = luoyy_birthplace;
		this.luoyy_scredit = luoyy_scredit;
		this.luoyy_classno = luoyy_classno;
		this.luoyy_mno = luoyy_mno;
	}

	/**
	 * @return the luoyy_sno
	 */
	public String getLuoyy_sno() {
		return luoyy_sno;
	}
	/**
	 * @param luoyy_sno the luoyy_sno to set
	 */
	public void setLuoyy_sno(String luoyy_sno) {
		this.luoyy_sno = luoyy_sno;
	}
	/**
	 * @return the luoyy_sname
	 */
	public String getLuoyy_sname() {
		return luoyy_sname;
	}
	/**
	 * @param luoyy_sname the luoyy_sname to set
	 */
	public void setLuoyy_sname(String luoyy_sname) {
		this.luoyy_sname = luoyy_sname;
	}
	/**
	 * @return the luoyy_ssex
	 */
	public String getLuoyy_ssex() {
		return luoyy_ssex;
	}
	/**
	 * @param luoyy_ssex the luoyy_ssex to set
	 */
	public void setLuoyy_ssex(String luoyy_ssex) {
		this.luoyy_ssex = luoyy_ssex;
	}
	/**
	 * @return the date
	 */
	public String getLuoyy_sbirthday() {
		return luoyy_sbirthday;
	}
	/**
	 * @param date the date to set
	 */
	public void setLuoyy_sbirthday(String luoyy_sbirthday) {
		this.luoyy_sbirthday = luoyy_sbirthday;
	}
	/**
	 * @return the luoyy_birthplace
	 */
	public String getLuoyy_birthplace() {
		return luoyy_birthplace;
	}
	/**
	 * @param luoyy_birthplace the luoyy_birthplace to set
	 */
	public void setLuoyy_birthplace(String luoyy_birthplace) {
		this.luoyy_birthplace = luoyy_birthplace;
	}
	/**
	 * @return the luoyy_scredi
	 */
	public int getLuoyy_scredit() {
		return luoyy_scredit;
	}
	/**
	 * @param luoyy_scredi the luoyy_scredi to set
	 */
	public void setLuoyy_scredit(int luoyy_scredit) {
		this.luoyy_scredit = luoyy_scredit;
	}
	/**
	 * @return the luoyy_classno
	 */
	public String getLuoyy_classno() {
		return luoyy_classno;
	}
	/**
	 * @param luoyy_classno the luoyy_classno to set
	 */
	public void setLuoyy_classno(String luoyy_classno) {
		this.luoyy_classno = luoyy_classno;
	}
	/**
	 * @return the luoyy_mno
	 */
	public String getLuoyy_mno() {
		return luoyy_mno;
	}
	/**
	 * @param luoyy_mno the luoyy_mno to set
	 */
	public void setLuoyy_mno(String luoyy_mno) {
		this.luoyy_mno = luoyy_mno;
	}
	
}
