package hello1.hello1spring.controller;

import hello1.hello1spring.domain.Member;
import hello1.hello1spring.repository.MemoryMemberRepository;
import hello1.hello1spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    /*
        private final MemberService memberService = new MemberService();
        1) new 키워드를 이용해 객체를 생성하지 않는다.
        2) 스프링 빈에 등록을 해놓고 이를 공유하는 방식으로 바꾸어야 한다.
     */

    @Autowired
    //스프링 컨테이너에 있는 memberService 빈이랑 연결을 시켜주는 역할
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member=new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members=memberService.findMembers();
        model.addAttribute("members",members);

        return "members/memberList";
    }
}
