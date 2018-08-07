// 2018. 8. 7(화) 이원상 P124	Controller.java
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Stock;
import service.StockDao;

@WebServlet("/P124Controller")
public class P124Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public P124Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StockDao stockDao = new StockDao();
		 List<Stock> list = stockDao.SelectStockListUnderAvg();									// 메소드 호출값을 변수 list에 대입
		 request.setAttribute("list", list);													// request영역에 저장
		 request.getRequestDispatcher("/WEB-INF/views/p124.jsp").forward(request, response);	// jsp로 포워딩
	}
}
