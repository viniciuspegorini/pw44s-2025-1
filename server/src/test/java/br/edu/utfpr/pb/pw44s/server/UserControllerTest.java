package br.edu.utfpr.pb.pw44s.server;

import br.edu.utfpr.pb.pw44s.server.model.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {

    //methodName_condition_expectedBehaviour
    public void postUser_whenUserIsValid_receiveOk() {
        User user = new User();
        user.setDisplayName("test-Display");
        user.setUsername("test-user");
        user.setPassword("P4ssword");
    }
}
