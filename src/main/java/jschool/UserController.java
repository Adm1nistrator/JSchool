package jschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/rest/users/")
    public ResponseEntity<User> create(@RequestBody User user) {
        System.out.println("Создан пользователь" + user.getLastName());
        if (!user.getLogin().equals("")) {
            this.userService.addUser(user);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/rest/users/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable("login") String login) {
        User user = new User("Алексей", "Долгих", new Date(123), login, "password!1", "student", "academ.ru");
        this.userService.getUser(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/rest/users/")
    public HttpEntity<List<User>> findAll() {
      /*  List<User> users = new ArrayList<>();
        User user0 = new User("Алексей", "Долгих", new Date(123), "anykey", "password!1", "student", "academ.ru");
        User user1 = new User("иван", "петров", new Date(12343), "hobbit", "password!2", "dent", "academ.info");
        users.add(user0);
        users.add(user1);*/
        return new ResponseEntity<>(this.userService.listUsers(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/rest/users/{login}")
    public ResponseEntity<User> update(@PathVariable("login") String login,
                                       @RequestBody User user) {
        this.userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/rest/users/{login}")
    public ResponseEntity<User> delete(@PathVariable String login) {
        this.userService.removeUser(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}