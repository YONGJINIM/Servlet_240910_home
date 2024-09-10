package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz06")
public class GetMethodQuiz06 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		
		String number1Param = request.getParameter("number1");
		String number2Param = request.getParameter("number2");
		Integer number1 = Integer.parseInt(number1Param);
		Integer number2 = Integer.parseInt(number2Param);
		
		PrintWriter out = response.getWriter();
		// {"addition":1570, "subtraction":1430, "multiplication":105000, "division":21}
		out.print(
			"{\"addition\":" + (number1 + number2) 
			+ ", \"subtraction\":" + (number1 - number2) 
			+ ", \"multiplication\":" + (number1 * number2) 
			+ ", \"division\":" + (number1 / number2) 
			+ "}");
	}
}