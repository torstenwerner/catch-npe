package de.twerner;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WrappingInterceptor implements MethodInterceptor {
    private static Logger logger = LoggerFactory.getLogger(Catcher.class);

    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    private SomeService someService;

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {
        someService.doSomething(new SomeServiceCallback() {
            @Override
            public void execute() {
                try {
                    invocation.proceed();
                } catch (Throwable throwable) {
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException) throwable;
                    }
                    else {
                        throw new RuntimeException(throwable);
                    }
                }
            }
        });
        return null;
    }
}
