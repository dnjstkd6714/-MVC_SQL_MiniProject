// 2018. 8. 7(화) 이원상 P125	Controller.java
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CakeDao;

@WebServlet("/P125Controller")						// uri mapping pattern
public class P125Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public P125Controller() {
        super();									// 조상클래스 생성자 호출
    }
	// doGet메소드 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CakeDao CakeDao = new CakeDao();
		int cakePrice = CakeDao.selectSpecificConditionsMinimumCake();						// 메소드 호출값(리턴값)을 변수에 대입
		request.setAttribute("cakePrice", cakePrice);										// request영역에 저장(setting)
		request.getRequestDispatcher("/WEB-INF/views/p125.jsp").forward(request, response);	// jsp로 포워딩
	}
}
