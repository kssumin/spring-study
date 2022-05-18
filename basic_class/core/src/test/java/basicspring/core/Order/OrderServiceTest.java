package basicspring.core.Order;

import basicspring.core.member.Grade;
import basicspring.core.member.Member;
import basicspring.core.member.MemberService;
import basicspring.core.member.MemberServiceImpl;
import basicspring.core.order.Order;
import basicspring.core.order.OrderService;
import basicspring.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService=new MemberServiceImpl();
    OrderService orderService=new OrderServiceImpl();

    @Test
    void createOrder(){
        //given
        Long memberId=1L;
        //private 타입은 null을 못 넣는다
        Member member=new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        //when -> 새로운 주문을 생성해서 주문 객체를 반환
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(9000).isEqualTo(itemA.calculatePrice());



    }
}
