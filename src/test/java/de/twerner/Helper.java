package de.twerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    @CatchNullPointerException
    public String helper(Object arg) {
        return arg.toString();
    }

    @WrappedBySomeService
    public void callback() { System.setProperty("callbackCalled", "true"); }

    public static void main(String args[]) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final Helper helper = context.getBean(Helper.class);
        final Logger logger = LoggerFactory.getLogger(Helper.class);
        logger.info(helper.helper("Hello"));
        logger.info(helper.helper(null));
    }
}
