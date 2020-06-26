package br.com.wfincatti.jwtrestapi;

import br.com.wfincatti.jwtrestapi.entity.Role;
import br.com.wfincatti.jwtrestapi.entity.User;
import br.com.wfincatti.jwtrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setPassword(passwordEncoder.encode("user"));
        user.setUsername("user");
        user.grantAuthority(Role.ROLE_USER);

        User userAdmin = new User();
        userAdmin.setPassword(passwordEncoder.encode("admin"));
        userAdmin.setUsername("admin");
        userAdmin.grantAuthority(Role.ROLE_ADMIN);

        userRepository.saveAll(Arrays.asList(user, userAdmin));
    }
}
