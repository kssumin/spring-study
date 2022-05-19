package hello1.hello1spring.domain;

import org.springframework.transaction.reactive.GenericReactiveTransaction;

import javax.persistence.*;

@Entity //JPA가 관리하는 Entity이다

public class Member {
    @Id//애는 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//디비가 아이디 값을 자동으로 값을 넣어줌 -> Identity 전략?
    private Long id;
    //@Column(name="username") -> DB의 컬럼명을 바꿔준다.
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //이러한 애노테이션을 가지고 DB와 매핑을 한다.
    //이 정보를 가지고 insert,delete 같은 걸 한다.

}
