package hello1.hello1spring.service;

import hello1.hello1spring.domain.Member;
import hello1.hello1spring.repository.MemberRepository;
import hello1.hello1spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(member);//중복 회원 검증
        memberRepository.save(member);
        return member.getId();

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m->{
//            throw new IllegalStateException("이미 존재하는 회원입니다");
//        });


    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    public List<Member>findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member>findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
