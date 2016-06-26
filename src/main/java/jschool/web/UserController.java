package jschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dolgi on 23.06.2016.
 */
@Controller
public class UserController {

    @RequestMapping(path = "/users")
    public ModelAndView getAllUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("getalluser");
    }

    @RequestMapping(path = "/user", params = {"login"})
    public ModelAndView getUser(HttpServletRequest request, @RequestParam(value = "login") String login) throws UnsupportedEncodingException {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("login", login );
        return new ModelAndView("getuser", model);
    }
    @RequestMapping(path = "/adduser")
    public ModelAndView addUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("adduser");
    }

}
