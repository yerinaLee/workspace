package edu.kh.jsp.jstl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/loop")
public class LoopServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("퓨처셀프", "벤자민 하디", 17820));
		bookList.add(new Book("시대예보: 핵개인의 시대", "송길영", 18900));
		bookList.add(new Book("트렌드 코리아 2024", "김난도", 17100));
		bookList.add(new Book("도시와 그 불확실한 벽", "무라카미 하루키", 17550));
		bookList.add(new Book("승리의 함성을 다 같이 외쳐라", "윤세호", 16200));
		
		req.setAttribute("bookList", bookList);
		
		String path ="/WEB-INF/views/jstl/loop.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
