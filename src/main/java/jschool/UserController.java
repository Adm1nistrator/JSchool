package jschool;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController

public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/user")

    public HttpEntity<User> user(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName,
                                 @RequestParam(value = "birthDay", required = false) Date birthDay,
                                 @RequestParam(value = "login", required = false) String login,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "aBout", required = false) String aBout,
                                 @RequestParam(value = "adress", required = false) String adress) {
        User user = new User(firstName, lastName, birthDay, login, password, aBout, adress);
        user.add(linkTo(methodOn(UserController.class).user(firstName, lastName, birthDay, login, password, aBout, adress)).withSelfRel()); //// TODO: 16.06.16 непонятная строка
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}