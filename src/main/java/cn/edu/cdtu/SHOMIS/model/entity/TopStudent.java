package cn.edu.cdtu.SHOMIS.model.entity;

public class TopStudent {
	private String sname;
	private String sno;
	private String sfrequency;

	public TopStudent(){}
	public TopStudent(String sname, String sno, String sfrequency) {
		this.sname = sname;
		this.sno = sno;
		this.sfrequency = sfrequency;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSfrequency() {
		return sfrequency;
	}

	public void setSfrequency(String sfrequency) {
		this.sfrequency = sfrequency;
	}
}
