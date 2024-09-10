package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz09")  // "/lesson01/quiz09" 경로로 들어오는 요청을 처리하는 서블릿
public class PostMethodQuiz09 extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // 응답의 콘텐츠 타입을 HTML로 설정
        response.setContentType("text/html");
        
        // 응답 객체로부터 PrintWriter 객체를 가져와 HTML을 출력할 준비
        PrintWriter out = response.getWriter();
        
        // 폼으로부터 전달된 이름과 자기소개 데이터를 가져옴
        String name = request.getParameter("name");  // 입력된 이름
        String introduce = request.getParameter("introduce");  // 입력된 자기소개
        
        // HTML 응답을 생성하여 출력
        out.print("<html><head><title>지원 완료</title></head><body>");
        // 이름을 굵게(bold) 처리하여 출력
        out.print("<b>" + name + "</b> 님 지원이 완료 되었습니다.<br>");
        // "지원 내용"을 굵게 출력
        out.print("<b>지원 내용</b><br>");
        // 입력된 자기소개를 그대로 출력
        out.print(introduce);
        // HTML 닫기 태그 출력
        out.print("</body></html>");
    }
}

