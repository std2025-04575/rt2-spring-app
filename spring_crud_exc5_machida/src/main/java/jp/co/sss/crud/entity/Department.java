package jp.co.sss.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	private Integer deptId; //部署ID
	@Column
	private String deptName; //部署名
	
	/**
	 * 部署IDを取得します。
	 * 
	 * @return deptId 部署ID
	 */
	public Integer getDeptId() {
		return deptId;
	}
	
	/**
	 * 部署IDを設定します。
	 * 
	 * @param deptId 部署ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
	/**
	 * 部署名を取得します。
	 * 
	 * @return deptName 部署名
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * 部署名を設定します。
	 * 
	 * @param deptName 部署名
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
