package cn.edu.cdtu.SHOMIS.model;

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
	private String ano;

	@Column(length = 10)
	private String apwd;

	@Column(length = 20)
	private String name;

	public AdminDO() {
	}
	public AdminDO(String ano, String apwd, String name) {
		this.ano = ano;
		this.apwd = apwd;
		this.name = name;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
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
