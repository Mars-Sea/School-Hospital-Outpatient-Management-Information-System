package cn.edu.cdtu.SHOMIS.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mars_sea
 * 管理员信息实体类
 */
@Entity
@Table(name = "admins")
public class AdminDO {

	@Id
	@Column(length = 20)
	private Integer ano;

	@Column(length = 10)
	private String apwd;

	@Column(length = 20)
	private String name;

	public AdminDO() {
	}

	public AdminDO(Integer ano, String apwd, String name) {
		this.ano = ano;
		this.apwd = apwd;
		this.name = name;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AdminDO{" +
				"ano='" + ano + '\'' +
				", apwd='" + apwd + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
