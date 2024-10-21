package hello.servlet.mvc1.web.frontcontroller.v2;

import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap=new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members/members",new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI=request.getRequestURI();

        ControllerV2 controller=controllerMap.get(requestURI);//호출된 url에 해당하는 controller들을 호출함

        System.out.println("controller = " + controller);
        if(controller ==null){
            System.out.println(" dpfj= " );
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // return new MyView("/WEB-INF/views/new-form.jsp");
        MyView view=controller.process(request,response);
        view.render(request,response);
    }

}
