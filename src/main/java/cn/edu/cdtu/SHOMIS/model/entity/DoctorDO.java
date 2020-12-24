package cn.edu.cdtu.SHOMIS.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mars_sea
 * 医生信息实体类
 */
@Entity
@Table(name = "doctors")
public class DoctorDO {

	@Id
	private Integer dno;

	@Column(length = 20, nullable = false)
	private String dname;

	@Column(length = 3)
	private Integer dage;

	@Column(length = 5)
	private String dsex;

	@Column(length = 20)
	private String dpwd;

	public DoctorDO() {
	}

	public DoctorDO(Integer dno, String dname, Integer dage, String dsex, String dpwd) {
		this.dno = dno;
		this.dname = dname;
		this.dage = dage;
		this.dsex = dsex;
		this.dpwd = dpwd;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getDage() {
		return dage;
	}

	public void setDage(Integer dage) {
		this.dage = dage;
	}

	public String getDsex() {
		return dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
	}

	public String getDpwd() {
		return dpwd;
	}

	public void setDpwd(String dpwd) {
		this.dpwd = dpwd;
	}

	@Override
	public String toString() {
		return "DoctorDO{" +
				"dno=" + dno +
				", dname='" + dname + '\'' +
				", dage=" + dage +
				", dsex='" + dsex + '\'' +
				", dpwd='" + dpwd + '\'' +
				'}';
	}
}
