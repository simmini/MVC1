package hello.servlet.mvc1.web.frontcontroller.v4.controller;

import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String,String> paramMap,Map<String,Object>model)  {
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
        //return new ModelView("new-form");

        //v4-ModelView가 아예 필요없어짐
        return "new-form";
    }


}
