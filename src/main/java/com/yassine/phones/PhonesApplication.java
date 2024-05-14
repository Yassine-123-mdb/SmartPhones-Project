package com.yassine.phones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yassine.phones.entities.User;
import com.yassine.phones.service.UserService;

@SpringBootApplication
public class PhonesApplication implements CommandLineRunner {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    public static void main(String[] args) {
        SpringApplication.run(PhonesApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        // Ajouter votre logique ici
        System.out.println("Password Encoded BCRYPT :******************** ");
        System.out.println(passwordEncoder.encode("123"));
        
        User r=userService.findUserByUsername("user10");
        r.setPassword("123456");
        userService.saveUser(r);
        
        // Vous pouvez également initialiser des utilisateurs ou des données ici
        // Exemple : 
        /*
        userService.addRole(new Role(null, "ADMIN"));
        userService.addRole(new Role(null, "AGENT"));
        userService.addRole(new Role(null, "USER"));
        
        userService.saveUser(new User(null, "admin", passwordEncoder.encode("123"), true, null));
        userService.saveUser(new User(null, "yassine", passwordEncoder.encode("123"), true, null));
        userService.saveUser(new User(null, "user1", passwordEncoder.encode("123"), true, null));
        
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("yassine", "USER");
        userService.addRoleToUser("yassine", "AGENT");
        userService.addRoleToUser("user1", "USER");
        */
    }
}
