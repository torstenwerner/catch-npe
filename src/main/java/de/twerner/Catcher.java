package de.twerner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Catcher {
    @AfterThrowing(pointcut = "@annotation(de.twerner.CatchNullPointerException)",
            throwing = "java.lang.NullPointerException")
    public Object catchNullPointerException(ProceedingJoinPoint pjp) {
        System.out.println("YES");
        return null;
    }
}
