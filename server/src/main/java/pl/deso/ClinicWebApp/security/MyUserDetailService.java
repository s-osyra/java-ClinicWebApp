package pl.deso.ClinicWebApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.deso.ClinicWebApp.models.User;
import pl.deso.ClinicWebApp.models.UserRepo;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo uRepo;

    @Override
    public UserDetails loadUserByUsername(String uEmail) throws UsernameNotFoundException {
        Optional<User> user = uRepo.findByUserEmail(uEmail);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + uEmail));

        return user.map(MyUserDetails::new).get();
    }



}
