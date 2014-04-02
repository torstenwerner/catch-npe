package de.twerner;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public void doSomething(SomeServiceCallback callback) {
        System.setProperty("someServiceCalled", "true");
        callback.execute();
    }
}
