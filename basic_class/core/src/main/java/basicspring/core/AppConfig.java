package basicspring.core;

import basicspring.core.discount.DiscountPolicy;
import basicspring.core.discount.FixDiscountPolicy;
import basicspring.core.discount.RateDiscountPolicy;
import basicspring.core.member.MemberService;
import basicspring.core.member.MemberServiceImpl;
import basicspring.core.member.MemoryMemberRepository;
import basicspring.core.order.OrderService;
import basicspring.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
