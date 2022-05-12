package hello1.hello1spring.service;

import hello1.hello1spring.domain.Member;
import hello1.hello1spring.repository.MemberRepository;
import hello1.hello1spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {
    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository=new MemoryMemberRepository();
        memberService=new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given : 주어졌을 때
        Member member=new Member();
        member.setName("spring");
        //when : 실행했을 때
        Long saveId = memberService.join(member);
        //then : 결과가 이런 게 나와야 해
        Member findMember =memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원예외(){
        //given
        Member member1=new Member();
        member1.setName("spring1");

        Member member2=new Member();
        member2.setName("spring1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

//        memberService.join(member1);
//        try{
//            memberService.join(member2);
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }

   @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}