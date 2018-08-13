// 2018. 8. 13(월) 이원상 P154Controller.java
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;
import java.util.*;



@WebServlet("/P154Controller")							// uri mapping pattern
public class P154Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClubADao clubADao = null;   

    public P154Controller() {							// default 생성자				
        super();										// 조상클래스 생성자 호출
    }	
    // doget 메소드 오버라이딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.clubADao = new ClubADao();
		List<ClubA> nameList = this.clubADao.selectNameDoNotOverlap();							// 메소드 호출값(리턴값)을 변수에 대입
		request.setAttribute("nameList", nameList);												// request영역에 저장(setting)
		// response.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/views/p154.jsp").forward(request, response);		// jsp로 포워딩
	}
}
