package hello.servlet.mvc1.web.frontcontroller.v2.controller;

import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);*/

        /*yView myview=new MyView("/WEB-INF/views/new-form.jsp");
        return myview;
*/
        return new MyView("/WEB-INF/views/new-form.jsp");

    }
}
