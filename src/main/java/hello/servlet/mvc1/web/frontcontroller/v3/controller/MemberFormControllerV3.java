package hello.servlet.mvc1.web.frontcontroller.v3.controller;

import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v2.ControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String,String> paramMap)  {
        //v1
       /* String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);*/

        /*yView myview=new MyView("/WEB-INF/views/new-form.jsp");
        return myview;
*/
        //v2
       // return new MyView("/WEB-INF/views/new-form.jsp");

        //v3-전체적인 path가 아닌 논리적인 path를 정해서 보냄
        return new ModelView("new-form");
    }


}
