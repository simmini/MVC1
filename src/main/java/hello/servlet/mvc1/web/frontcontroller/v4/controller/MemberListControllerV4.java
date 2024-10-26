package hello.servlet.mvc1.web.frontcontroller.v4.controller;

import hello.servlet.mvc1.domain.Member;
import hello.servlet.mvc1.domain.MemberRepository;
import hello.servlet.mvc1.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public String process(Map<String,String> paramMap, Map<String, Object>model) {
        List<Member> members=memberRepository.findAll();

        model.put("member",members);
        return "members";

        //v3
//        ModelView mv=new ModelView("members");
//        mv.getModel().put("members",members);
//
//        return mv;
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
