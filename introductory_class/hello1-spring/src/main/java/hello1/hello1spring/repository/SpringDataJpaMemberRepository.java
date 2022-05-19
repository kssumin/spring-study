package hello1.hello1spring.repository;

import hello1.hello1spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{
    @Override
    Optional<Member> findByName(String name);
}
