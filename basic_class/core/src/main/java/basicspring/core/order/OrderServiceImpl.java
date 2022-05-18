package basicspring.core.order;

import basicspring.core.discount.DiscountPolicy;
import basicspring.core.discount.FixDiscountPolicy;
import basicspring.core.member.Member;
import basicspring.core.member.MemberRepository;
import basicspring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
