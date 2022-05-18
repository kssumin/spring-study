package basicspring.core.discount;

import basicspring.core.member.Grade;
import basicspring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountAmount=1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountAmount;
        }else{
            return 0;
        }
    }
}
