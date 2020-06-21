package pl.deso.ClinicWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.deso.ClinicWebApp.models.LoginRequest;
import pl.deso.ClinicWebApp.models.User;
import pl.deso.ClinicWebApp.models.UserRepo;
import pl.deso.ClinicWebApp.utilis.UserJSONToMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody LoginRequest loginRequest, HttpSession session, HttpServletResponse res) throws Exception {

        try {
            Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(loginRequest.getUserEmail(), loginRequest.getUserPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String userEmail = loginRequest.getUserEmail();
            session.setAttribute("user",userEmail);

        } catch (BadCredentialsException e) {
            res.setStatus(403);
            res.getWriter().print("Incorrect credentials!");
                    }

    }

    @RequestMapping(value = "user/new", method = RequestMethod.POST)
    @ResponseBody
    public Object user(@RequestBody User newUser, HttpServletResponse res) throws IOException {


        try {
            if (uRepo.existsById(newUser.getUserEmail())) {
                res.setStatus(403);
            } else {

                newUser.setUserPassword(passwordEncoder.encode(newUser.getUserPassword()));

                uRepo.save(newUser);

                res.setStatus(201);
                return newUser;
            }

        } catch (Exception e) {
            res.setStatus(500);
            res.getWriter().print("Internal server error. Please try again.");
        }

        return null;
    }


    @RequestMapping(value = "user", method = RequestMethod.GET)
    @ResponseBody
    public String user(HttpSession session) {

        Optional<User> user = uRepo.findByUserEmail((String)session.getAttribute("user"));

        return user.toString();
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
    public String test(HttpSession session) {

        String test = "This is test in session.";
//        User user = (User) session.getAttribute("user");
//        User user = (Optional<User>) session.getAttribute("user");
        session.setAttribute("test", test);
        return "Success!";


    }

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1 (HttpSession session) {

        //User user = (User) session.getAttribute("user");
        //User user = (Optional<User>) session.getAttribute("user");
        return  (String) session.getAttribute("test");


    }
}
