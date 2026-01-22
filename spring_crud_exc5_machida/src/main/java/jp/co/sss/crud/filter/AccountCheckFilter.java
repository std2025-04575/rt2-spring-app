package jp.co.sss.crud.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

public class AccountCheckFilter extends HttpFilter {

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

		if (requestURL.endsWith("/input") ||
				requestURL.endsWith("/delete/check")) {
			//			セッション情報を取得
			HttpSession session2 = request.getSession();
			//			セッションからユーザのログイン情報を取得
			EmployeeBean loginUser2 = (EmployeeBean) session2.getAttribute("loginUser");
			//			権限情報を取得
			Integer authority = loginUser2.getAuthority();

			if (authority == 1) {
				//				一般ユーザの場合
				response.sendRedirect("/spring_crud/");
				return;
			}

			chain.doFilter(request, response);
			return;
		}
		chain.doFilter(request, response);
		return;
	}
}
