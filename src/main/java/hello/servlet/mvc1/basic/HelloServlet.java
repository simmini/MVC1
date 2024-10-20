package hello.servlet.mvc1.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.service(req, resp);

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username=request.getParameter("username");
        System.out.println("username = " + username);

        //헤더정보
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //바디정보
        response.getWriter().write("hello"+username);
    }
}
