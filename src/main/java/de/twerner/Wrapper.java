package de.twerner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Wrapper {
    private static Logger logger = LoggerFactory.getLogger(Catcher.class);

    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    private SomeService someService;

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
