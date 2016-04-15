package org.chance;

/**
 * Created by wqg on 2016/3/12.
 */

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SampleFlywayApplicationTests {

    @Autowired
    private JdbcTemplate template;

//    @Test
//    @Ignore
//    public void testDefaultSettings() throws Exception {
//        assertThat(this.template.queryForObject("select count(*) from person",Integer.class)).isEqualTo(1);
//    }

}
