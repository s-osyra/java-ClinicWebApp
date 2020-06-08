package pl.deso.ClinicWebApp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.deso.ClinicWebApp.models.User;
import pl.deso.ClinicWebApp.models.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    HttpSession session;

    @Autowired
    UserRepo userRepo;



    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String userEmail = "";
        User user;

        if (authentication.getPrincipal() instanceof Principal){
            userEmail = ((Principal)authentication.getPrincipal()).getName();
        } else {
            userEmail = ((MyUserDetails)authentication.getPrincipal()).getUsername();
             }

        user = userRepo.returnUserByEmail(userEmail.trim());

        logger.info("userEmail: " + userEmail);
        session.setAttribute("user", user);
    }
}
