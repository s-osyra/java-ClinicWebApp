package pl.deso.ClinicWebApp.utilis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserJSONToMap {

    @Autowired
    PasswordEncoder passwordEncoder;


    public Map<String ,String> convert (String updatedUser) {

        String[] allowedChange =  {"userName", "userSurname", "userPassword", "userEmail"};

        updatedUser = updatedUser.replace("{", "");
        updatedUser = updatedUser.replace("}", "");
        updatedUser = updatedUser.replace("\"", "");

        Map<String, String> changeMap = new HashMap<>();
        String[] array = updatedUser.split(",");

        for (String s : array) {
            s=s.trim();
            String[] secondSplit = s.split(":");

            if (Arrays.asList(allowedChange).contains(secondSplit[0])){
                if (secondSplit[0].contains("userPassword")) {
                    secondSplit[1] = passwordEncoder.encode(secondSplit[0]);
                }
                changeMap.put(secondSplit[0].trim(), secondSplit[1].trim());
            }
        }
        return changeMap;
    }

}
