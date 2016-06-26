package jschool.rest;

import jschool.dao.User;
import jschool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {


    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/rest/users/")
    public ResponseEntity<User> create(@RequestBody User user) {
        String login = user.getLogin();
        if (StringUtils.isEmpty(login)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (this.userService.getUser(login) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
            this.userService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/rest/users/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable("login") String login) {
        User user = this.userService.getUser(login);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.userService.getUser(login), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/rest/users/")
    public HttpEntity<List<User>> findAll() {
        List<User> users = this.userService.listUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(this.userService.listUsers(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/rest/users/{login}")
    public ResponseEntity<User> update(@PathVariable("login") String login,
                                       @RequestBody User user) {
        this.userService.updateUser(user);
        return new ResponseEntity<>(this.userService.getUser(login), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/rest/users/{login}")
    public ResponseEntity<User> delete(@PathVariable String login) {
        User user = this.userService.getUser(login);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        this.userService.removeUser(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}