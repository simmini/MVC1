package hello.servlet.mvc1.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.mvc1.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        HelloData helloData=objectMapper.readValue(messageBody,HelloData.class);

        System.out.println("helloData = " + helloData.getUsername());
        System.out.println("helloData.getAge() = " + helloData.getAge());*/

    }
}
