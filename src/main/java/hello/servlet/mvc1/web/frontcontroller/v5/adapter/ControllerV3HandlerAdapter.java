package hello.servlet.mvc1.web.frontcontroller.v5.adapter;

import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.v3.ControllerV3;
import hello.servlet.mvc1.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter
    {
        @Override
        public boolean supports(Object handler) {
            return (handler instanceof ControllerV3);//v3 인터페이스를 구현한 먼가가 오면 참 반환
        }

        @Override
        public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
            ControllerV3 controller =(ControllerV3) handler;
            Map<String,String>paramMap=createParamMap(request);
            ModelView mv = controller.process(paramMap);

            return mv;
        }
        private static Map<String, String> createParamMap(HttpServletRequest request) {
            Map<String,String>paramMap=new HashMap<>();
            //모든 파라미터 ㄱ져와서 돌면서 key변수명은 paramName,value는 request.getParameter(paramName)
            request.getParameterNames().asIterator()
                    .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
            return paramMap;
        }
    }
