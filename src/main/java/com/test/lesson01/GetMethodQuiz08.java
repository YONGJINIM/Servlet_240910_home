package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz08")
public class GetMethodQuiz08 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {        

        // 응답 데이터의 인코딩 설정 (UTF-8) 및 HTML 문서로 설정
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
    
        // 브라우저에 데이터를 출력하기 위해 PrintWriter 객체 생성
        PrintWriter out = response.getWriter();
        
        // 검색 키워드를 파라미터로 받아옴
        String keyword = request.getParameter("keyword");
        
        // 리스트에 미리 설정된 텍스트들을 저장
        List<String> list = new ArrayList<>(Arrays.asList(
                "강남역 최고 맛집 소개 합니다.", 
                "오늘 기분 좋은 일이 있었네요.", 
                "역시 맛집 데이트가 제일 좋네요.", 
                "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
                "자축 저 오늘 생일 이에요."));
        
        // HTML 문서 작성 시작
        out.print("<html><head><title>검색 결과</title></head><body>");
        
        // 리스트를 순회하면서 텍스트에 키워드가 포함된 경우, 해당 키워드를 굵게 표시
        for(int i = 0; i < list.size(); i++) { 
            String text = list.get(i);
            int index = text.indexOf(keyword);
            if (index != -1) {
                // 키워드가 있는 경우: 문자열을 키워드 앞, 키워드, 키워드 뒤로 나눠서 <b> 태그 추가
                String highlightedText = text.substring(0, index) + "<b>" 
                                        + keyword + "</b>" 
                                        + text.substring(index + keyword.length());
                out.print(highlightedText + "<br>");  
            } else {
                // 키워드가 없는 경우는 그대로 출력
                out.print(text + "<br>");
            }
        }
        
        // HTML 문서 작성 종료
        out.print("</body></html>");
    }
}
