package hello.servlet.mvc1.web.frontcontroller.v3;

import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v2.ControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.mvc1.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.mvc1.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap=new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI=request.getRequestURI();

        ControllerV3 controller=controllerMap.get(requestURI);//호출된 url에 해당하는 controller들을 호출함

        if(controller ==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        //v2
        // return new MyView("/WEB-INF/views/new-form.jsp");
       // MyView view=controller.process(request,response);

        //paramMap를 넘겨줌
        Map<String, String> paramMap = createParamMap(request);
        //논리path이름 반환해줌 =:new-form
        ModelView mv=controller.process(paramMap);


        String viewName = mv.getViewName();//논리이름 new-form
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
    }

    //논리->물리 이름으로 변경해줌
    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String>paramMap=new HashMap<>();
        //모든 파라미터 ㄱ져와서 돌면서 key변수명은 paramName,value는 request.getParameter(paramName)
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
