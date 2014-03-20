package de.twerner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Catcher {
    private static Logger logger = LoggerFactory.getLogger(Catcher.class);

    @Around("execution(* helper(..))")
    public Object catchNullPointerException(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("before");
        try {
            return pjp.proceed();
        }
        catch (NullPointerException e) {
            logger.debug("got NullPointerException");
            return null;
        }
    }
}
