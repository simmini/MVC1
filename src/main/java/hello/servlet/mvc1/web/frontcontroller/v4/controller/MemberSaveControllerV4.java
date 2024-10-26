package hello.servlet.mvc1.web.frontcontroller.v4.controller;

import hello.servlet.mvc1.domain.Member;
import hello.servlet.mvc1.domain.MemberRepository;
import hello.servlet.mvc1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository= MemberRepository.getInstance();
    @Override
    public String process(Map<String,String> paramMap,Map<String,Object>model) {


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
        //v3
//        ModelView mv=new ModelView("save-result");
//        mv.getModel().put("member",member);
//        return mv;



        model.put("member",member);
        return "save-result";


    }
}
