package cn.edu.cdtu.SHOMIS.model.entity;

import java.util.Date;

public class Today {
	private String sname;
	private String dname;
	private String time;
	private String sno;
	private String id;

	public Today(){}

	public Today(String sname, String dname, String time, String sno, String id) {
		this.sname = sname;
		this.dname = dname;
		this.time = time;
		this.sno = sno;
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
