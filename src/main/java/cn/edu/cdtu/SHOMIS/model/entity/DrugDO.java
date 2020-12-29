package cn.edu.cdtu.SHOMIS.model.entity;

import javax.persistence.*;
import java.sql.Date;

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
	//批发价
	@Column
	private Float pDprice;
	//零售价
	@Column
	private Float lDprice;
	//生产厂家
	@Column
	private String SCCJ;
	//进货日期
	@Column
	@Temporal(TemporalType.DATE)
	private Date JHRQ;
	//生产日期
	@Column
	@Temporal(TemporalType.DATE)
	private Date SCRQ;

	//失效日期
	@Column
	@Temporal(TemporalType.DATE)
	private Date SXRQ;

	//备注
	@Column
	private String memo;


	public DrugDO(String dno, String dname, Integer inventory, Float pDprice, Float lDprice, String SCCJ, Date JHRQ, Date SCRQ, Date SXRQ, String memo) {
		this.dno = dno;
		this.dname = dname;
		this.inventory = inventory;
		this.pDprice = pDprice;
		this.lDprice = lDprice;
		this.SCCJ = SCCJ;
		this.JHRQ = JHRQ;
		this.SCRQ = SCRQ;
		this.SXRQ = SXRQ;
		this.memo = memo;
	}

	public DrugDO() {

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

	public Float getpDprice() {
		return pDprice;
	}

	public void setpDprice(Float pDprice) {
		this.pDprice = pDprice;
	}

	public Float getlDprice() {
		return lDprice;
	}

	public void setlDprice(Float lDprice) {
		this.lDprice = lDprice;
	}

	public String getSCCJ() {
		return SCCJ;
	}

	public void setSCCJ(String SCCJ) {
		this.SCCJ = SCCJ;
	}

	public Date getJHRQ() {
		return JHRQ;
	}

	public void setJHRQ(Date JHRQ) {
		this.JHRQ = JHRQ;
	}

	public Date getSCRQ() {
		return SCRQ;
	}

	public void setSCRQ(Date SCRQ) {
		this.SCRQ = SCRQ;
	}

	public Date getSXRQ() {
		return SXRQ;
	}

	public void setSXRQ(Date SXRQ) {
		this.SXRQ = SXRQ;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "DrugDO{" +
				"dno='" + dno + '\'' +
				", dname='" + dname + '\'' +
				", inventory=" + inventory +
				", pDprice=" + pDprice +
				", lDprice=" + lDprice +
				", SCCJ='" + SCCJ + '\'' +
				", JHRQ=" + JHRQ +
				", SCRQ=" + SCRQ +
				", SXRQ=" + SXRQ +
				", memo='" + memo + '\'' +
				'}';
	}
}
