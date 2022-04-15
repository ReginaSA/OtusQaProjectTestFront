package qa.stub.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import entities.User;
import entities.UserDetail;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping("/get/{id}")
    public UserDetail getUsers(@PathVariable Long id) {
        return new UserDetail(id, "name", "grade", "Some school", "City");
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();
        for (Integer i = 0; i < 300; i++) {
            list.add(new User(i.longValue(), "name " + i, "Grade " + i));
        }
        return list;
    }
}