package com.kh.test.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderProduct.do")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
        String name = req.getParameter("name");
        int blackPen = Integer.parseInt( req.getParameter("blackPen") );
        int redPen = Integer.parseInt( req.getParameter("redPen") );
        int bluePen = Integer.parseInt( req.getParameter("bluePen") );
        int white = Integer.parseInt( req.getParameter("white") );
        
        int total = 0; // 총결제금액
        
        int blackPenTotal = blackPen * 500;
        int redPenTotal = redPen * 700;
        int bluePenTotal = bluePen * 700;
        int whiteTotal = white * 1000;
        
        total = blackPenTotal + redPenTotal + bluePenTotal + whiteTotal;
        
        if(total != 0) {
        	
        	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
        	
        	req.setAttribute("blackPenTotal", blackPenTotal);
        	req.setAttribute("redPenTotal", redPenTotal);
        	req.setAttribute("bluePenTotal", bluePenTotal);
        	req.setAttribute("whiteTotal", whiteTotal);
        	req.setAttribute("total", total);
        	dispatcher.forward(req, resp);
        	
        } else {
        	resp.sendRedirect("error.do");
        	
        }
        
	}
	
}
