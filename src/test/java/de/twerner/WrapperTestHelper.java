package de.twerner;

public class WrapperTestHelper {
    @WrappedBySomeService
    public void callback() { System.setProperty("callbackCalled", "true"); }
}
