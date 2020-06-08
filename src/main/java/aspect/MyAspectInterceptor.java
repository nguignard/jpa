package aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectInterceptor {

    @Around("execution(* *.*(..))")
public void interceptAll() {
	System.out.println("To String will be called!!");
    }

    @Before("@annotation(annotation.JpaHearing)")
    public void beforeAnnotation() {
	System.out.println("from my Annotation !");
    }

//    @AfterReturning(pointcut = "execution(* bean.imusician.*.toString(..))", returning = "result")
//    public String interceptorToStringReturning(String result) {
//	System.out.println("RETURN INTERCEPT");
//	return " result : " + result;
//
//    }

}