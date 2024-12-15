package es.system.jpexposito;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import es.system.jpexposito.springboot.SpringBootRestClientApplication;
import es.system.jpexposito.springboot.User;
import es.system.jpexposito.springboot.client.UserClient;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = SpringBootRestClientApplication.class)
class UserClientIntegrationTest {
   
    @Autowired
    private UserClient userClient;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testGetAllUsers() {
        
        List<User> users = userClient.getAllUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    void testCreateAndRetrieveUser() {
        User user = new User( "Jane Doe");
        User createdUser = userClient.createUser(user);    

        assertNotNull(createdUser);
        assertEquals("Jane Doe", createdUser.getName());

        User retrievedUser = userClient.getUserById(createdUser.getId());
        assertEquals("Jane Doe", retrievedUser.getName());
    }

    @Test
    void testUpdateUser() {
        User user = new User( "Old Name");
        User createdUser = userClient.createUser(user);

        createdUser.setName("New Name");
        userClient.updateUser(createdUser.getId(), createdUser);

        User updatedUser = userClient.getUserById(createdUser.getId());
        assertEquals("New Name", updatedUser.getName());
    }

    @Test
    void testDeleteUser() {
        User user = new User( "Delete Me");
        User createdUser = userClient.createUser(user);

        assertDoesNotThrow(() -> userClient.deleteUser(createdUser.getId()));

        ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:8080/api/v1/users/", User[].class);
        User[] users = response.getBody();
        List<User> list = Arrays.asList(users);
        System.out.println(list);
    }


}
