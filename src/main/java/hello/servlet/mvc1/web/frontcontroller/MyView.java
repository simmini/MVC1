package hello.servlet.mvc1.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;
    public MyView(String viewPath){
        this.viewPath=viewPath;
    }
    //v2
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    //v3
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Model에 있는 값을 request에 다담음
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value)-> request.setAttribute(key,value));
    }
}
