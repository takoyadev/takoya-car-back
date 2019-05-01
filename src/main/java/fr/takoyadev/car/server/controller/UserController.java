package fr.takoyadev.car.server.controller;

import fr.takoyadev.car.server.dao.UserRepository;
import fr.takoyadev.car.server.entity.User;
import fr.takoyadev.car.server.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserRepository users;

    @RequestMapping("/users")
    public void findAll() {
        this.users.findAll();
    }

    @PostMapping("/user/add")
    public void save(@RequestBody User user) {
        this.users.save(user);
    }

    @PostMapping("/user/signin")
    public String signin(@RequestBody User data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " does not exist !"));
            //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), password));
            String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());
            return token;
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
