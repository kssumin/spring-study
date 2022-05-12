package hello1.hello1spring.repository;

import hello1.hello1spring.domain.Member;

import java.util.*;

public class MemoryMemberRerpository implements MemberRerpository {
    private static Map<Long, Member>store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Member save(Member member) { //set 하기전에 이름은 넘어옴
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 반환될 가능성이 있음 -> Optional 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
