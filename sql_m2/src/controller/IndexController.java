// 2018. 8. 6(월) 이원상 IndexController.java
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();									// 조상클래스 생성자 호출
    }
	// doGet메소드 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Controller -> View Forward
		String view = "/WEB-INF/views/index.jsp";						// 경로를 대입한 변수
		RequestDispatcher rd = request.getRequestDispatcher(view);		// 포워딩할 경로를 대입
		rd.forward(request, response);									// 해당 경로로 포워딩(request와 response 넘김)
	}
}
