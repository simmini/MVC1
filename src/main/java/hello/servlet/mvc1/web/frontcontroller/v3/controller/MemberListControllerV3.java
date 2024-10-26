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
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String,String> paramMap) {
        List<Member> members=memberRepository.findAll();

        ModelView mv=new ModelView("members");
        mv.getModel().put("members",members);

        return mv;
        //v1
/*
        request.setAttribute("members",members);

        //v2
//        String viewPath="/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher=request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request,response);

        return new MyView("/WEB-INF/views/members.jsp");*/
    }
}
