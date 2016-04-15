package org.chance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wqg on 2016/3/15.
 */

@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:0")
@DirtiesContext
public class SampleMethodSecurityApplicationTests extends AbstractTestNGSpringContextTests {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testHome() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                "http://localhost:"+this.port, HttpMethod.GET,
                new HttpEntity<Void>(headers), String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("<title>Login");
    }

    @Test
    public void testLogin() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.set("username", "admin");
        form.set("password", "admin");
        getCsrf(form, headers);
        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                "http://localhost:" + this.port +"/login", HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(form, headers),
                String.class
        );
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
        assertThat(entity.getHeaders().getLocation().toString())
                .isEqualTo("http://localhost:"+this.port+"/");
    }

    @Test
    public void testDenied() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.set("username", "user");
        form.set("password", "user");
        getCsrf(form, headers);
        ResponseEntity<String> entity = new TestRestTemplate().exchange(
                "http://localhost:" + this.port + "/login", HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(form, headers),
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
        String cookie = entity.getHeaders().getFirst("Set-Cookie");
        headers.set("Cookie", cookie);
        ResponseEntity<String> page = new TestRestTemplate().exchange(
                entity.getHeaders().getLocation(), HttpMethod.GET,
                new HttpEntity<Void>(headers), String.class);
        assertThat(page.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
        assertThat(page.getBody()).contains("Access denied");
    }

    @Test
    public void testManagementProtected() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate()
                .getForEntity("http://localhost:" + this.port + "/beans", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void testManagementAuthorizedAccess() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate("admin", "admin")
                .getForEntity("http://localhost:" + this.port + "/beans", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testManagementUnauthorizedAccess() throws Exception {
        ResponseEntity<String> entity = new TestRestTemplate("user", "user")
                .getForEntity("http://localhost:" + this.port + "/beans", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }


    private void getCsrf(MultiValueMap<String, String> form, HttpHeaders headers) {
        ResponseEntity<String> page = new TestRestTemplate()
                .getForEntity("http://localhost:"+this.port+"/login",String.class);
        String cookie = page.getHeaders().getFirst("Set-Cookie");
        headers.set("Cookie", cookie);
        String body = page.getBody();
        Matcher matcher = Pattern.compile("(?s).*name=\"_csrf\".*?value=\"([^\"]+).*")
                .matcher(body);
        matcher.find();
        form.set("_csrf", matcher.group(1));
    }


}
