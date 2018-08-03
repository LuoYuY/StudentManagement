package manage.model;


import java.io.Serializable;

public class Teacher  implements Serializable{
	String luoyy_tno;
	String luoyy_tname;
	String luoyy_tsex;
	String luoyy_tbirthday;
	String luoyy_profess ;
	String luoyy_tel;
	public Teacher(String luoyy_tno, String luoyy_tname, String luoyy_tsex, String luoyy_tbirthday,
			String luoyy_profess, String luoyy_tel) {
		super();
		this.luoyy_tno = luoyy_tno;
		this.luoyy_tname = luoyy_tname;
		this.luoyy_tsex = luoyy_tsex;
		this.luoyy_tbirthday = luoyy_tbirthday;
		this.luoyy_profess = luoyy_profess;
		this.luoyy_tel = luoyy_tel;
	}
	public Teacher() {
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

	public String getLuoyy_tsex() {
		return luoyy_tsex;
	}

	public void setLuoyy_tsex(String luoyy_tsex) {
		this.luoyy_tsex = luoyy_tsex;
	}

	public String getLuoyy_tbirthday() {
		return luoyy_tbirthday;
	}

	public void setLuoyy_tbirthday(String luoyy_tbirthday) {
		this.luoyy_tbirthday = luoyy_tbirthday;
	}

	public String getLuoyy_profess() {
		return luoyy_profess;
	}

	public void setLuoyy_profess(String luoyy_profess) {
		this.luoyy_profess = luoyy_profess;
	}

	public String getLuoyy_tel() {
		return luoyy_tel;
	}

	public void setLuoyy_tel(String luoyy_tel) {
		this.luoyy_tel = luoyy_tel;
	}
	

}
