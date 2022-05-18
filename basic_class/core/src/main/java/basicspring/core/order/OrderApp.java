package basicspring.core.order;

import basicspring.core.member.Grade;
import basicspring.core.member.Member;
import basicspring.core.member.MemberService;
import basicspring.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService=new MemberServiceImpl();
        OrderService orderService=new OrderServiceImpl();

        Long memberId=1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);

    }
}
