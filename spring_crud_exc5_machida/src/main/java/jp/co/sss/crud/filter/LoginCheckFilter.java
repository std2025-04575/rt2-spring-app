package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

public class LoginCheckFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//		リクエストURLを取得
		String requestURL = request.getRequestURI();
		
		if (requestURL.indexOf("/html/") != -1 ||
				requestURL.indexOf("/css/") != -1 ||
				requestURL.indexOf("/img/") != -1 ||
				requestURL.indexOf("/js/") != -1) {
			chain.doFilter(request, response);
			return;
		}

//		System.out.println(requestURL + "1");

		if (requestURL.endsWith("/") ||
				requestURL.endsWith("/login")) {
			//			リクエストURLがログイン画面宛ての場合
//			System.out.println(requestURL + "2");
			chain.doFilter(request, response);
			return;

		} else {
			//			セッション情報を取得
			HttpSession session = request.getSession();

			//			セッション情報からユーザのログイン情報を取得
			EmployeeBean loginUser = (EmployeeBean)  session.getAttribute("loginUser");
//			System.out.println(empId);

			if (loginUser == null) {
				//				ログイン情報が存在しない場合
				response.sendRedirect("/spring_crud/");
				return;
			} else {
				chain.doFilter(request, response);
				return;
			}
		}
	}
}