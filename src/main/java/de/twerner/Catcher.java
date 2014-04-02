package de.twerner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Catcher {
    private static Logger logger = LoggerFactory.getLogger(Catcher.class);

    @Autowired
    private SomeService someService;

    @Around("execution(* *(..)) && @annotation(CatchNullPointerException)")
    public Object catchNullPointerException(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("before {}", pjp.getSignature().toShortString());
        try {
            return pjp.proceed();
        } catch (NullPointerException e) {
            logger.debug("swallowed NullPointerException");
            return null;
        }
    }

    @Around("execution(* *(..)) && @annotation(WrappedBySomeService)")
    public void wrapBySomeService(final ProceedingJoinPoint pjp) {
        someService.doSomething(new SomeServiceCallback() {
            @Override
            public void execute() {
                try {
                    pjp.proceed();
                } catch (Throwable throwable) {
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException) throwable;
                    } else {
                        throw new RuntimeException(throwable);
                    }
                }
            }
        });
    }
}
