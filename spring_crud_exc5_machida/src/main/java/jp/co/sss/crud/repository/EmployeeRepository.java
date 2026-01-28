package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/**
	 * 社員IDとパスワードでDB検索
	 * @param empId
	 * @param empPass
	 * @return
	 */
	Employee findByEmpIdAndEmpPass(Integer empId, String empPass);
	
	/**
	 * 全ての従業員情報を従業員ID昇順で全件検索
	 */
	List<Employee> findAllByOrderByEmpId();
	
	/**
	 * 指定された検索文字列を含む従業員名を持つ従業員を検索
	 * 
	 * @param 検索文字列
	 */
	List<Employee> findByEmpNameContainingOrderByEmpId(String empName);
	
	/**
	 * 指定された部署に所属する従業員情報を取得
	 * 
	 * @param departmentテーブル
	 */
	List<Employee> findByDepartmentOrderByEmpId(Department department);
	
	/**
	 * 社員IDでDB検索
	 * 
	 * @param 社員ID
	 */
	Employee findByEmpId(Integer empId);
	
	/**
	 * 削除フラグでDB検索
	 * 
	 * @param 削除フラグ
	 */
	List<Employee> findByDeleteFlagOrderByEmpId(Integer deleteFlag);
	
	
	
	
}
