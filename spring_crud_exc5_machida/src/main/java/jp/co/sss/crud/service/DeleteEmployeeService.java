package jp.co.sss.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;

/**
 * 従業員削除サービスクラス。
 * 指定された従業員IDを基に、データベースから従業員情報を削除します。
 * 
 * @author SystemShared Co., Ltd.
 * @version 1.0
 * @since 1.0
 */
@Service
public class DeleteEmployeeService {

	/**
	 * 従業員データアクセス用リポジトリフィールド。
	 * Spring DIによって自動注入されます。
	 */
	//TODO ここに記述
	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * 指定された従業員IDの従業員情報を削除メソッド。
	 * データベースから該当する従業員レコードを物理削除します。
	 * 
	 * @param forDeleteEmpId 削除対象の従業員ID
	 */
	//TODO ここに記述
	public void execute(Integer forDeleteEmpId) {
		//		//	データベースから該当する従業員レコードを物理削除
		//		employeeRepository.deleteById(forDeleteEmpId);

		//	データベースから該当する従業員レコードを論理削除
		//	社員IDから該当の社員情報を取得
		Employee employee = employeeRepository.findByEmpId(forDeleteEmpId);

		//		論理削除の値である1を代入
		employee.setDeleteFlag(1);

		//		更新処理
		employeeRepository.save(employee);
	}
}
