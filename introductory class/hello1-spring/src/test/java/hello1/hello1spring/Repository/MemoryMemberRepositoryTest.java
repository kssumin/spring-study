package Repository;

import hello1.hello1spring.domain.Member;
import hello1.hello1spring.repository.MemberRerpository;
import hello1.hello1spring.repository.MemoryMemberRerpository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRerpository repository = new MemoryMemberRerpository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //Optional 에서 값을 꺼낼 때는 .get()메서드 사용
        Member result = repository.findById(member.getId()).get();//아이디를 넣어서 찾은 멤버값이랑
        //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
