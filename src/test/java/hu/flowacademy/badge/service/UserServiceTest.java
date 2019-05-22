package hu.flowacademy.badge.service;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup() {
    }

    @Test
    public void findByIdTest() {
        User userShouldBeFound = new User("asd","fullname","password","role");

        User found = userService.getByUserName("asd");
        assertThat(found).isEqualTo(userShouldBeFound);
    }

    @Test
    public void findById() {
        User userShouldBeFound = new User("asd","fullname","password","role");
        Mockito.when(userRepository.findById(userShouldBeFound.getUsername())).thenReturn(Optional.of(userShouldBeFound));
        User found = userService.getByUserName(null);
        assertThat(found).isEqualTo(null);
    }

    @Test
    public void saveValami() {
        User userShouldBeFound = new User("asd","fullname","password","role");
        Mockito.when(userRepository.findById(userShouldBeFound.getUsername())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(any(User.class))).thenReturn(userShouldBeFound);


        User found = userService.save(userShouldBeFound);
        assertThat(found).isEqualTo(userShouldBeFound);
    }

}
