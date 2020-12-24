package cn.edu.cdtu.SHOMIS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mars_sea
 * 药品信息实体类
 */
@Entity
@Table(name = "drugs")
public class DrugDO {
	@Id
	@Column(length = 25)
	private String dno;

	@Column(length = 50)
	private String dname;

	@Column
	private Integer inventory;

	@Column
	private Float dprice;

	public DrugDO() {
	}
	public DrugDO(String dno, String dname, Integer inventory, Float dprice) {
		this.dno = dno;
		this.dname = dname;
		this.inventory = inventory;
		this.dprice = dprice;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Float getDprice() {
		return dprice;
	}

	public void setDprice(Float dprice) {
		this.dprice = dprice;
	}

	@Override
	public String toString() {
		return "DrugDO{" +
				"dno='" + dno + '\'' +
				", dname='" + dname + '\'' +
				", inventory=" + inventory +
				", dprice=" + dprice +
				'}';
	}
}
