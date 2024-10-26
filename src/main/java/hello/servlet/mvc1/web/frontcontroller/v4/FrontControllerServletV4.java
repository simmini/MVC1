package hello.servlet.mvc1.web.frontcontroller.v4;

import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.mvc1.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.mvc1.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet(name="frontControllerServletV4",urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap=new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members",new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV4.service");

        String requestURI=request.getRequestURI();

        ControllerV4 controller=controllerMap.get(requestURI);//호출된 url에 해당하는 controller들을 호출함

        if(controller ==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        //v2
        // return new MyView("/WEB-INF/views/new-form.jsp");
       // MyView view=controller.process(request,response);

        //paramMap를 넘겨줌
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model=new HashMap<>();//추가됨


        //논리path이름 반환해줌 =:new-form
        String viewName = controller.process(paramMap, model);

        //v3
        //String viewName = mv.getViewName();//논리이름 new-form
        MyView view = viewResolver(viewName);

        view.render(model,request,response);
    }

    //논리->물리 이름으로 변경해줌
    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String>paramMap=new HashMap<>();
        //모든 파라미터 가져와서 돌면서 key변수명은 paramName,value는 request.getParameter(paramName)
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

}
