package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/ex05")
public class PostMethodEx05 extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {        

        // 응답 데이터의 인코딩 설정 (UTF-8) 및 HTML 문서로 설정
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
    
        // 브라우저에 데이터를 출력하기 위해 PrintWriter 객체 생성
        PrintWriter out = response.getWriter();
        
        // 검색 키워드를 파라미터로 받아옴
        String userId = request.getParameter("userId");
     	String name = request.getParameter("name");
     	String birth = request.getParameter("birth");
     	String email = request.getParameter("email");
     		 		
     	out.print("<html><head><title>회원정보</title></head><body>");
     	out.print("<table border=1>");
     	out.print("<tr><th>아이디</th><td>" + userId + "</td></tr>");
     	out.print("<tr><th>이름</th><td>" + name + "</td></tr>");
     	out.print("<tr><th>생년월일</th><td>" + birth + "</td></tr>");
     	out.print("<tr><th>이메일</th><td>" + email + "</td></tr>");
     	out.print("</table></body><html>");
    }
}