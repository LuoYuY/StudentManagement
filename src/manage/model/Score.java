package manage.model;

public class Score {
	
	String luoyy_sno;
	String luoyy_cname;
	String luoyy_term;
	String luoyy_tname;
	int luoyy_score;
	public Score() {
		super();
	}
	public Score(String luoyy_sno, String luoyy_cname, String luoyy_term, String luoyy_tname, int luoyy_score) {
		super();
		this.luoyy_sno = luoyy_sno;
		this.luoyy_cname = luoyy_cname;
		this.luoyy_term = luoyy_term;
		this.luoyy_tname = luoyy_tname;
		this.luoyy_score = luoyy_score;
	}

	public String getLuoyy_sno() {
		return luoyy_sno;
	}

	public void setLuoyy_sno(String luoyy_sno) {
		this.luoyy_sno = luoyy_sno;
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

	public String getLuoyy_tname() {
		return luoyy_tname;
	}

	public void setLuoyy_tname(String luoyy_tname) {
		this.luoyy_tname = luoyy_tname;
	}

	public int getLuoyy_score() {
		return luoyy_score;
	}

	public void setLuoyy_score(int luoyy_score) {
		this.luoyy_score = luoyy_score;
	}
	
}
