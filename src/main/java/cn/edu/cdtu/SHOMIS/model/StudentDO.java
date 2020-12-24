package cn.edu.cdtu.SHOMIS.model;

import javax.persistence.*;

/**
 * @author mars_sea
 * 学生实体类
 */
@Entity
@Table(name = "students")
public class StudentDO {

	@Id
	private Integer sno;

	@Column(length = 20)
	private String sname;

	@Column
	private Integer sage;

	@Column(length = 5)
	private String ssex;

	@Column(length = 20)
	private String spwd;

	public StudentDO() {
	}

	public StudentDO(Integer sno, String sname, Integer sage, String ssex, String spwd) {
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
		this.spwd = spwd;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	@Override
	public String toString() {
		return "StudentDO{" +
				"sno=" + sno +
				", sname='" + sname + '\'' +
				", sage=" + sage +
				", ssex='" + ssex + '\'' +
				", spwd='" + spwd + '\'' +
				'}';
	}
}
