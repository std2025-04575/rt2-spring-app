let isAsc = true;

function sortEmpId() {
	//	テーブル情報を取得
	let employee = document.querySelector('.list_table');
	//行情報を取得
	let emprow = employee.querySelectorAll('tr');

	let employeeList = [];
	//	配列に行情報を追加
	for (let i = 1; i < emprow.length; i++) {
		employeeList.push(emprow[i]);
	}

	//昇順並び変える
	employeeList.sort((a, b) => {
		let numA = Number(a.cells[0].textContent);
		let numB = Number(b.cells[0].textContent);
		return numA - numB;
	});
	if (!isAsc) {
		employeeList.reverse();

	}
	
	isAsc=!isAsc;
	//	降順に並び変える
	//	employeeList.sort((a, b) => {
	//		return b - a;
	//	});
	for (let i = 0; i < employeeList.length; i++) {
		employee.appendChild(employeeList[i]);

	}



}