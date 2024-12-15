package es.system.jpexposito.springboot.client;

import java.util.Arrays;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import es.system.jpexposito.springboot.User;
import java.util.List;

@Component
public class UserClient {

    private static final String BASE_URL = "http://localhost:8080/api/v1";
    private final RestTemplate restTemplate;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Get all users.
     * @return List of users
     */
    public List<User> getAllUsers() {
        String url = BASE_URL + "/users/";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        return Arrays.asList(response.getBody());
    }

    /**
     * Get a user by ID.
     * @param userId ID of the user
     * @return User object
     */
    public User getUserById(int userId) {
        String url = BASE_URL + "/user/" + userId;
        return restTemplate.getForObject(url, User.class);
    }

    /**
     * Create a new user.
     * @param user User to create
     * @return Created user
     */
    public User createUser(User user) {
        String url = BASE_URL + "/add/user/";
        return restTemplate.postForObject(url, user, User.class);
    }

    /**
     * Update a user by ID.
     * @param userId ID of the user
     * @param userDetails Updated user details
     * @return Updated user
     */
    public User updateUser(int userId, User userDetails) {
        String url = BASE_URL + "/update/user/" + userId;
        restTemplate.put(url, userDetails);
        return getUserById(userId);
    }

    /**
     * Delete a user by ID.
     * @param userId ID of the user
     * @return true if deleted successfully
     */
    public boolean deleteUser(int userId) {
        String url = BASE_URL + "/delete/user/" + userId;
        restTemplate.delete(url);
        return true;
    }
}

