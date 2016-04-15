package org.chance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by wqg on 2016/3/12.
 */

@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:0")
@DirtiesContext
public class ApplicationTests extends AbstractTestNGSpringContextTests{

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private JdbcTemplate template;


    @Test
    public void testHome() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate()
                .getForEntity("http://localhost:"+this.port,String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello World");
    }

    @Test
    public void testDefaultSettings() throws Exception {
        assertThat(this.template.queryForObject("select count(*) from person",Integer.class)).isEqualTo(1);
    }

}
