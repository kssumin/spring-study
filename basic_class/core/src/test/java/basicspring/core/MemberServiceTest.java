package basicspring.core;

import basicspring.core.member.Grade;
import basicspring.core.member.Member;
import basicspring.core.member.MemberService;
import basicspring.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService=new MemberServiceImpl();

    @Test
    void join(){
        //given : 주어졌을 때
        Member member=new Member(1L,"memberA", Grade.VIP);

        //when : 이걸 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
