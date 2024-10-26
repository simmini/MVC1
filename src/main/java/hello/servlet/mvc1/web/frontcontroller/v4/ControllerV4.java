package hello.servlet.mvc1.web.frontcontroller.v4;

import hello.servlet.mvc1.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV4 {
    //v2
    //MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    //서블릿(HTttpServlet)에 종속되지않고 프레임워크에 종속되도록 만듬
    //v3
    //ModelView process(Map<String,String> paramMap);


    //v4

    /**
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String,String>paramMap,Map<String,Object>model);
}
