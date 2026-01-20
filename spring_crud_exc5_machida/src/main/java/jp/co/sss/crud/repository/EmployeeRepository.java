package jp.co.sss.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/**
	 * 社員IDとパスワードでDB検索
	 * @param empId
	 * @param empPass
	 * @return
	 */
	Employee findByEmpIdAndEmpPass(Integer empId, String empPass);
}
