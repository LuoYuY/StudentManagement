package manage.model;

public class Course {
	String luoyy_cno;
	String luoyy_cname;
	int luoyy_ctime;
	String luoyy_ctype;
	int luoyy_ccredit;
	public Course(String luoyy_cno, String luoyy_cname, int luoyy_ctime, String luoyy_ctype, int luoyy_ccredit) {
		super();
		this.luoyy_cno = luoyy_cno;
		this.luoyy_cname = luoyy_cname;
		this.luoyy_ctime = luoyy_ctime;
		this.luoyy_ctype = luoyy_ctype;
		this.luoyy_ccredit = luoyy_ccredit;
	}
	public Course() {
		super();
	}

	public String getLuoyy_cno() {
		return luoyy_cno;
	}

	public void setLuoyy_cno(String luoyy_cno) {
		this.luoyy_cno = luoyy_cno;
	}

	public String getLuoyy_cname() {
		return luoyy_cname;
	}

	public void setLuoyy_cname(String luoyy_cname) {
		this.luoyy_cname = luoyy_cname;
	}

	public int getLuoyy_ctime() {
		return luoyy_ctime;
	}

	public void setLuoyy_ctime(int luoyy_ctime) {
		this.luoyy_ctime = luoyy_ctime;
	}

	public String getLuoyy_ctype() {
		return luoyy_ctype;
	}

	public void setLuoyy_ctype(String luoyy_ctype) {
		this.luoyy_ctype = luoyy_ctype;
	}

	public int getLuoyy_ccredit() {
		return luoyy_ccredit;
	}

	public void setLuoyy_ccredit(int luoyy_ccredit) {
		this.luoyy_ccredit = luoyy_ccredit;
	}
	
	
}
