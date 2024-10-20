package hello.servlet.mvc1.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        //response.setHeader("Content-Type","text/plain;character=utf-8");
        response.setHeader("Cache-Control","no-cache,nostoremust-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

        content(response);
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void content(HttpServletResponse response){
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        Cookie cookie=new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);


    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setRedirect("Location","/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
