package basicspring.core.discount;

import basicspring.core.member.Grade;
import basicspring.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(memberVIP, 1000);
        //then
        Assertions.assertThat(discount).isEqualTo(100);
    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(memberVIP, 1000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}