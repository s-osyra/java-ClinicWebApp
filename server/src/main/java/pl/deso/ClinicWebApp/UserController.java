package pl.deso.ClinicWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.deso.ClinicWebApp.models.User;
import pl.deso.ClinicWebApp.models.UserRepo;
import pl.deso.ClinicWebApp.utilis.UserJSONToMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    UserRepo uRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserJSONToMap userJSONToMap;


    @RequestMapping(value = "user/new", method = RequestMethod.POST)
    @ResponseBody
    public User user(@RequestBody User newUser, HttpServletResponse res) {


        if (uRepo.existsById(newUser.getUserEmail())) {
            res.setStatus(403);
        } else {

            newUser.setUserPassword(passwordEncoder.encode(newUser.getUserPassword()));

            uRepo.save(newUser);

            res.setStatus(201);
            return newUser;
        }
        return null;
    }


    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public Optional user(HttpSession session) {

        Optional<User> user = (Optional<User>) session.getAttribute("user");

        return user;


    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    @ResponseBody
    public User user(@RequestBody String updatedUser, HttpSession session) {

        Map<String, String> changes = userJSONToMap.convert(updatedUser);

        User user = (User) session.getAttribute("user");

        user.updateUser(changes);
        uRepo.save(user);

        return user;

    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public User test(HttpSession session) {

        User user = (User) session.getAttribute("user");
        //User user = (Optional<User>) session.getAttribute("user");
        System.out.printf(user.toString());

        return user;
    }

}
