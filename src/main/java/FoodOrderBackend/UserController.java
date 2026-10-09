package FoodOrderBackend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:5173" ,"https://24eg107h23.netlify.app"})
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PostMapping("/login")
public User loginUser(@RequestBody User loginUser) {

    User user = userRepository.findFirstByEmail(loginUser.getEmail());

    if (user != null && user.getPassword().equals(loginUser.getPassword())) {
        return user;
    }

    return null;
}
}
