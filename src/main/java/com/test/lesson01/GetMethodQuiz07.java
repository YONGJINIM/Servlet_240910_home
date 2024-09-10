package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz07")
public class GetMethodQuiz07 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        // 응답 데이터의 인코딩 설정 (UTF-8) 및 HTML 문서로 설정
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        // 브라우저로 데이터를 출력하기 위해 PrintWriter 객체 생성
        PrintWriter out = response.getWriter();

        // 디버깅용: 클라이언트로부터 전달받은 파라미터 값을 확인
        // 'address', 'card', 'price'라는 이름의 파라미터를 받아옴
        String address = request.getParameter("address");
        String card = request.getParameter("card");
        int price = Integer.parseInt(request.getParameter("price"));  // 'price'는 문자열로 받아오므로 정수형으로 변환

        // 조건문을 통해 입력된 데이터를 처리하여 결과를 출력
        out.print("<html><head><title>주문결과</title></head><body>");
        
        // 1. 주소에 '서울시'가 포함되지 않은 경우 배달 불가 메시지 출력
        if (!address.contains("서울시")) {
            out.print("배달 불가 지역입니다.");
        } 
        // 2. 결제 카드로 '신한' 카드가 선택된 경우 결제 불가 메시지 출력
        else if (card.contains("신한")) {
            out.print("결제 불가 카드입니다.");
        } 
        // 3. 배달 가능한 지역이면서 결제 가능한 카드인 경우 배달 준비 중 메시지와 결제 금액 출력
        else {
            out.print(address + "<b> 배달 준비중</b>");
            out.print("<br>결제 금액: " + price);
        }
        
        // HTML 문서 닫기
        out.print("</body></html>");
    }
}

