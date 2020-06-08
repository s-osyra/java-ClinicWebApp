package pl.deso.ClinicWebApp.security;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

@GetMapping (name = "/")
String index (Model model){
        return "index";

}


}
