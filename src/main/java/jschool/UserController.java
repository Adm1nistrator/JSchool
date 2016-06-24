package jschool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dolgi on 23.06.2016.
 */
@Controller
public class UserController {

    @RequestMapping(path = "/getalluser")
    public ModelAndView getAllUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("getalluser");
    }

    @RequestMapping(path = "/getuser")
    public ModelAndView getUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("getuser");
    }
    @RequestMapping(path = "/adduser")
    public ModelAndView addUser(HttpServletRequest request) throws UnsupportedEncodingException {
        return new ModelAndView("adduser");
    }

}
