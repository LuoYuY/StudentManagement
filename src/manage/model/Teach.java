package manage.model;

public class Teach {
	String luoyy_tno;
	String luoyy_tname;
	String luoyy_cno;
	String luoyy_cname; 
	String luoyy_term;
	String luoyy_mno;
	String luoyy_classno;
	public Teach(String luoyy_tno, String luoyy_tname, String luoyy_cno,String luoyy_cname, String luoyy_term, String luoyy_mno,String luoyy_classno) {
		super();
		this.luoyy_tno = luoyy_tno;
		this.luoyy_tname = luoyy_tname;
		this.luoyy_cno = luoyy_cno;
		this.luoyy_cname = luoyy_cname;
		this.luoyy_term = luoyy_term;
		this.luoyy_mno= luoyy_mno;
		this.luoyy_classno = luoyy_classno;
		
	}
	public Teach() {
		super();
	}

	public String getLuoyy_tno() {
		return luoyy_tno;
	}

	public void setLuoyy_tno(String luoyy_tno) {
		this.luoyy_tno = luoyy_tno;
	}

	public String getLuoyy_tname() {
		return luoyy_tname;
	}

	public void setLuoyy_tname(String luoyy_tname) {
		this.luoyy_tname = luoyy_tname;
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

	public String getLuoyy_term() {
		return luoyy_term;
	}

	public void setLuoyy_term(String luoyy_term) {
		this.luoyy_term = luoyy_term;
	}
	
	public String getLuoyy_mno() {
		return luoyy_mno;
	}

	public void setLuoyy_mno(String luoyy_mno) {
		this.luoyy_mno = luoyy_mno;
	}

	public String getLuoyy_classno() {
		return luoyy_classno;
	}

	public void setLuoyy_classno(String luoyy_classno) {
		this.luoyy_classno = luoyy_classno;
	}
	
}
