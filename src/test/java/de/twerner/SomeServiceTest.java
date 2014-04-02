package de.twerner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SomeServiceTest {
    @Autowired
    private SomeService someService;

    @Autowired
    private Helper helper;

    @Before
    public void setup() {
        System.clearProperty("someServiceCalled");
        System.clearProperty("callbackCalled");
    }

    @Test
    public void testDirectCall() throws Exception {
        someService.doSomething(new SomeServiceCallback() {
            @Override
            public void execute() {
                System.setProperty("callbackCalled", "true");
            }
        });
        assertThat(System.getProperty("callbackCalled"), is("true"));
        assertThat(System.getProperty("someServiceCalled"), is("true"));
    }

    @Test
    public void testIndirectCall() throws Exception {
        helper.callback();
        assertThat(System.getProperty("callbackCalled"), is("true"));
        assertThat(System.getProperty("someServiceCalled"), is("true"));
    }
}
