package de.twerner;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CatchTest {
    @Autowired
    private Helper helper;

    @Test
    public void testNotNull() throws Exception {
        assertThat(helper.helper("abc"), notNullValue());
    }

    @Test
    public void testNull() throws Exception {
        assertThat(helper.helper(null), nullValue());
    }
}
