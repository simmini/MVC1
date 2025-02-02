package hello.servlet.mvc1.web.springmvc.v3;

import hello.servlet.mvc1.domain.Member;
import hello.servlet.mvc1.domain.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository=MemberRepository.getInstance();
    @GetMapping("/new-form")
    //@RequestMapping(value="/new-form", method = RequestMethod.GET)
    public String newForm(){
        return "new-form";
        //return new ModelAndView("new-form");
    }

    @PostMapping("/save")
    //@RequestMapping(value="/save",method=RequestMethod.POST)
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ){
//        String username=request.getParameter("username");
//        int age=Integer.parseInt(request.getParameter("age"));

        Member member=new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member",member);
//        ModelAndView mv=new ModelAndView("save-result");
//        mv.addObject("member",member);
        return "save-result";

    }

    @GetMapping
    // @RequestMapping("/")
   // @RequestMapping(method=RequestMethod.GET)
    public String process(Model model){
        List<Member> members=memberRepository.findAll();
        model.addAttribute("members",members);
        /*
        ModelAndView mv=new ModelAndView("members");
        mv.addObject("members",members);*/

        return "members";
    }
}

