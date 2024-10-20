package hello.servlet.mvc1.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        ServletInputStream inputStream = request.getInputStream();//바이트내용을 바디내용으로 가져옴
        String messageBody= StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//바이트->string
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
