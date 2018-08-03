package manage.model;

public class Reports {
	String luoyy_cno;
	String luoyy_term;
	String luoyy_tno;
	String luoyy_sno;
	int luoyy_score;
	public Reports(String luoyy_cno, String luoyy_term, String luoyy_tno, String luoyy_sno, int luoyy_score) {
		super();
		this.luoyy_cno = luoyy_cno;
		this.luoyy_term = luoyy_term;
		this.luoyy_tno = luoyy_tno;
		this.luoyy_sno = luoyy_sno;
		this.luoyy_score = luoyy_score;
	}
	public Reports() {
		super();
	}

	public String getLuoyy_cno() {
		return luoyy_cno;
	}

	public void setLuoyy_cno(String luoyy_cno) {
		this.luoyy_cno = luoyy_cno;
	}

	public String getLuoyy_term() {
		return luoyy_term;
	}

	public void setLuoyy_term(String luoyy_term) {
		this.luoyy_term = luoyy_term;
	}

	public String getLuoyy_tno() {
		return luoyy_tno;
	}

	public void setLuoyy_tno(String luoyy_tno) {
		this.luoyy_tno = luoyy_tno;
	}

	public String getLuoyy_sno() {
		return luoyy_sno;
	}

	public void setLuoyy_sno(String luoyy_sno) {
		this.luoyy_sno = luoyy_sno;
	}

	public int getLuoyy_score() {
		return luoyy_score;
	}

	public void setLuoyy_score(int luoyy_score) {
		this.luoyy_score = luoyy_score;
	}

}
