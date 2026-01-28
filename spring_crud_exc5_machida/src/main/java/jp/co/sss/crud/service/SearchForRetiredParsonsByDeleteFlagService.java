package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;

/**
 * 退職者検索サービスクラス。
 * データベースから全ての退職者情報を取得し、EmployeeBeanリストとして返却します。
 * 退職者情報は従業員IDの昇順でソートされます。
 * 
 * @author SystemShared Co., Ltd.
 * @version 1.0
 * @since 1.0
 */
@Service
public class SearchForRetiredParsonsByDeleteFlagService {

	/**
	 * 従業員データアクセス用リポジトリ。
	 * Spring DIによって自動注入されます。
	 */
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<EmployeeBean> execute() {
		//		データベースから退職者を従業員ID昇順で取得
		List<Employee> retiredPersonList = employeeRepository.findByDeleteFlagOrderByEmpId(1);

		//		 BeanManagerを使用してEmployeeBeanリストに変換して返却
		//		EmployeeBean employeeBean = new EmployeeBean();

		List<EmployeeBean> retiredPersonBeanList = BeanManager.copyEntityListToBeanList(retiredPersonList);

		return retiredPersonBeanList;
	}

}
