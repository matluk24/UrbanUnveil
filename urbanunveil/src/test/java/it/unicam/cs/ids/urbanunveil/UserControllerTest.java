package it.unicam.cs.ids.urbanunveil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import it.unicam.cs.ids.urbanunveil.Service.UserService;
import it.unicam.cs.ids.urbanunveil.Service.UserServiceImpl;
import it.unicam.cs.ids.urbanunveil.Service.RoleService;
import it.unicam.cs.ids.urbanunveil.Service.RoleServiceImpl;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;

@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    void contextLoads() {
        UserController controller = new UserController(userService, roleService);

        controller.addUser("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834");

        System.out.print(controller.getAllUsers().toString());
    }
}
