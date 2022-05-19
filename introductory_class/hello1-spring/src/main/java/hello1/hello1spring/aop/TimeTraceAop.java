package hello1.hello1spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect //이 에노테이션이 있어야지 AOP를 사용할 수 있다.
public class TimeTraceAop {

    @Around("execution(*hello.gellospring..*(..))") //AOP 적용하는 클래스 명시
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try{
            Object result = joinPoint.proceed();//다음 메서드로 진행이 된다?
            return result;
        }finally{
            long finish=System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }

    }
}
