package jschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.UserDao;

import java.sql.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    private UserDao userDao;

    @RequestMapping(method = RequestMethod.POST, path = "/rest/api/1/user/create")
    public HttpEntity<User> userCreate(@RequestParam(value = "firstName", required = true) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName,
                                       @RequestParam(value = "birthDay", required = false) Date birthDay,
                                       @RequestParam(value = "login", required = true) String login,
                                       @RequestParam(value = "password", required = false) String password,
                                       @RequestParam(value = "aBout", required = false) String aBout,
                                       @RequestParam(value = "adress", required = false) String adress) {
        User user = new User(firstName, lastName, birthDay, login, password, aBout, adress);
        user.add(linkTo(methodOn(UserController.class).userCreate(firstName, lastName, birthDay, login, password, aBout, adress)).withSelfRel());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/rest/api/1/user/")
    public HttpEntity<User> userRead() {
        List<User> userList = userDao.readAllUser();
        for (Integer i=0;i<userList.size();i++ )
        {
            userList.get(i).add(linkTo(methodOn(UserController.class).userRead()).withSelfRel());
            return new ResponseEntity<User>(userList.get(i), HttpStatus.OK);
        }
        return null;
    }
}