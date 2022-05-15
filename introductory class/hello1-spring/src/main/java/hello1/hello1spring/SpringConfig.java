package hello1.hello1spring;

import hello1.hello1spring.repository.JdbcMemberRepository;
import hello1.hello1spring.repository.JdbcTemplateMemberRepository;
import hello1.hello1spring.repository.MemberRepository;
import hello1.hello1spring.repository.MemoryMemberRepository;
import hello1.hello1spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    public DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

    //스프링 통합 테스트(DB+스프링 부트까지 연결)를 만들어 놓았기에 웹 어플리케이션을 띄어서 검증할 필요가 없다.
}
