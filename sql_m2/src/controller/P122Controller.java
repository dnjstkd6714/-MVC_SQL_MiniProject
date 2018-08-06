// 2018. 8. 6(월) 이원상 P122Controller.java
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Cake;
import service.CakeDao;

@WebServlet("/P122Controller")
public class P122Controller extends HttpServlet {
	// Controller -> Model(List<Cake>) -> p122.jsp
	private CakeDao cakeDao;
	// doGet메소드 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cakeDao = new CakeDao();
		List<Cake> list = cakeDao.selectCakeListOverAvg();										// 메소드 호출값을 변수 list에 대입
		request.setAttribute("list", list);														// request영역에 저장
		request.getRequestDispatcher("/WEB-INF/views/p122.jsp").forward(request, response);		// jsp로 포워딩
	}
}
