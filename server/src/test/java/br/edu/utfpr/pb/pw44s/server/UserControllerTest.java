package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
// @TestMethodOrder(MethodOrderer.MethodName.class)
public class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;
    
    @BeforeEach
    public void cleanUp() {
        userRepository.deleteAll();
        restTemplate.getRestTemplate().getInterceptors().clear();
    }

    //methodName_condition_expectedBehaviour
    @Test
    public void postUser_whenUserIsValid_receiveOk() {
        User user = new User();
        user.setDisplayName("test-Display");
        user.setUsername("test-user");
        user.setPassword("P4ssword");

        ResponseEntity<Object> response =
                restTemplate.postForEntity("/users", user, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postUser_whenUserIsValid_userSavedToDatabase() {
        User user = new User();
        user.setDisplayName("test-Display");
        user.setUsername("test-user");
        user.setPassword("P4ssword");

        ResponseEntity<Object> response =
                restTemplate.postForEntity("/users", user, Object.class);

        assertThat( userRepository.count() ).isEqualTo( 1 );
    }
}
