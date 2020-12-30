package cn.edu.cdtu.SHOMIS.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author mars_sea
 * 挂号信息表实体类
 */
@Entity
@Table(name = "registers")
public class RegisteredDO {
	/**
	 * strategy 设置使用数据库主键自增策略；
	 * generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
	 */
	@Id
	private Integer id;

	@ManyToOne
	private StudentDO student;

	@ManyToOne
	private DoctorDO doctor;

	@Temporal(TemporalType.DATE)
	private Date appTime;

	@Column(length = 100)
	private String symptom;

	/**
	 * 处方
	 */
	@OneToMany
	private List<DrugDO> drugList;
//顺序
	@Column(unique = true)
	private Integer sequence;

	@Column
	private Float price;

	public RegisteredDO(Integer id, StudentDO student, DoctorDO doctor, Date appTime, String symptom, List<DrugDO> drugList, Integer sequence, Float price) {
		this.id = id;
		this.student = student;
		this.doctor = doctor;
		this.appTime = appTime;
		this.symptom = symptom;
		this.drugList = drugList;
		this.sequence = sequence;
		this.price = price;
	}

	public RegisteredDO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentDO getStudent() {
		return student;
	}

	public void setStudent(StudentDO student) {
		this.student = student;
	}

	public DoctorDO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDO doctor) {
		this.doctor = doctor;
	}

	public Date getAppTime() {
		return appTime;
	}

	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public List<DrugDO> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<DrugDO> drugList) {
		this.drugList = drugList;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "RegisteredDO{" +
				"id=" + id +
				", student=" + student +
				", doctor=" + doctor +
				", appTime=" + appTime +
				", symptom='" + symptom + '\'' +
				", drugList=" + drugList +
				", sequence=" + sequence +
				", price=" + price +
				'}';
	}
}
