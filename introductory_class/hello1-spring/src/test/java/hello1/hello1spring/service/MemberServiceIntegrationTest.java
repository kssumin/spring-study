package hello1.hello1spring.service;

import hello1.hello1spring.domain.Member;
import hello1.hello1spring.repository.MemberRepository;
import hello1.hello1spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional //테스트 케이스에 달면 테스트를 실행할 때 트랜젝션을 실행하고 디비에 쿼리를 한 후 롤백을 한다. 그래서 디비에 넣은 데이터가 다 롤백이 된다.
class MemberServiceIntegrationTest {
    //테스트도 잘 되었고 DB에 내용도 잘 올라감 -> 테스트는 반복할 수 있어야 함!
    //데이터베이스는 기본적으로 트렌젝션이라는 개념이 있다
    //DB에 insert -> commit / auto commit
    //commit 하기 전까지 DB에 저장이 안됨
    //그래서 쿼리 후 롤백(지운다 -> 반영을 안 한다)을 해버리면? 디비에서 그 데이터가 반영이 안된다.
    //따라서 다음 테스트를 반복적으로 할 수 있다.

    @Autowired private MemberService memberService;
    @Autowired private MemberRepository memberRepository;
    //기존 코드는 생성자를 통해 DI를 받지만, 테스트 코드 같은 경우는 필드 주입을 많이 사용함
    //구현체는 구성정보인 SpringConfig에서 올라올 것임





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

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }
}