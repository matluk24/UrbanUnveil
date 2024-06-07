package it.unicam.cs.ids.urbanunveil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;

import it.unicam.cs.ids.urbanunveil.Service.UserService;
import it.unicam.cs.ids.urbanunveil.Service.UserServiceImpl;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;
import it.unicam.cs.ids.urbanunveil.Service.RoleService;
import it.unicam.cs.ids.urbanunveil.Service.RoleServiceImpl;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;
import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private UserController controller;

    @Test
    void addAndRemoveUserTest() {
        Role r = new Role(RoleName.TOURIST, "Un normale turista autenticato");
        User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", r);
        roleRepo.save(r);
        
        assertEquals(u, controller.addUser(u).getBody());
        assertEquals(HttpStatus.OK, controller.removeUser(Long.valueOf(1)));
        
    }
    
    @Test
    void listOfUsersTest() {
        Role r = new Role(RoleName.TOURIST, "Un normale turista autenticato");
        User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", r);
        User f = new User("Francesco", "Barontini", "francesco@studenti.unicam.it", "FRNC7187Y1834", r);
        roleRepo.save(r);
        List<User> l = new ArrayList<User>();
       
        l.add(u);
        l.add(f);
        
        controller.addUser(u);
        controller.addUser(f);

        assertEquals(l, controller.getAllUsers().getBody());
    }
    
    void getUserTest() {
        Role r = new Role(RoleName.TOURIST, "Un normale turista autenticato");
        User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", r);
        roleRepo.save(r);
        
        controller.addUser(u);

        assertEquals(u, controller.getUser(Long.valueOf(u.getId())));
    }
}
