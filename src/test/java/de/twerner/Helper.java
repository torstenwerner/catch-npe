package de.twerner;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class Helper {
    @CatchNullPointerException
    public String helper(Object arg) {
        return arg.toString();
    }
}
