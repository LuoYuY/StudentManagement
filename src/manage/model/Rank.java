package manage.model;

public class Rank {
	String luoyy_sname;
	int luoyy_score;
	int num;
	public Rank(String luoyy_sname, int luoyy_score, int num) {
		super();
		this.luoyy_sname = luoyy_sname;
		this.luoyy_score = luoyy_score;
		this.num = num;
	}
	public Rank() {
		super();
	}

	public String getLuoyy_sname() {
		return luoyy_sname;
	}

	public void setLuoyy_sname(String luoyy_sname) {
		this.luoyy_sname = luoyy_sname;
	}

	public int getLuoyy_score() {
		return luoyy_score;
	}

	public void setLuoyy_score(int luoyy_score) {
		this.luoyy_score = luoyy_score;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
