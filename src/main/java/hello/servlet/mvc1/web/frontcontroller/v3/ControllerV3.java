package hello.servlet.mvc1.web.frontcontroller.v3;

import hello.servlet.mvc1.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //v2
    //MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    //서블릿(HTttpServlet)에 종속되지않고 프레임워크에 종속되도록 만듬
    ModelView process(Map<String,String> paramMap);
}
