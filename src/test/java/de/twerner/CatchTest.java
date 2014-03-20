package de.twerner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CatchTest {
    @Autowired
    private Helper helper;

    @Test
    public void testNotNull() throws Exception {
        assertThat(helper.helper("abc"), is("abc"));
    }

    @Test
    public void testNull() throws Exception {
        assertThat(helper.helper(null), nullValue());
    }
}
