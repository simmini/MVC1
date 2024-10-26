package hello.servlet.mvc1.web.frontcontroller.v3.controller;

import hello.servlet.mvc1.domain.Member;
import hello.servlet.mvc1.domain.MemberRepository;
import hello.servlet.mvc1.web.frontcontroller.ModelView;
import hello.servlet.mvc1.web.frontcontroller.MyView;
import hello.servlet.mvc1.web.frontcontroller.v2.ControllerV2;
import hello.servlet.mvc1.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String,String> paramMap) {


       /* String username=requests.getParameter("username");
        int age=Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        //Model에 데이터를 보관
        request.setAttribute("member",member);
            //v1
//        String viewPath="/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request,response);

         //v2
        return  new MyView("/WEB-INF/views/save-result.jsp");*/

        //v3
        String username=paramMap.get("username");
        int age=Integer.parseInt(paramMap.get("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        ModelView mv=new ModelView("save-result");

        mv.getModel().put("member",member);
        return mv;

    }
}
