package pl.deso.ClinicWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.deso.ClinicWebApp.models.User;
import pl.deso.ClinicWebApp.models.Visit;
import pl.deso.ClinicWebApp.models.VisitRepo;

import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class VisitController {

    @Autowired
    VisitRepo vRepo;


    @RequestMapping (value = "visit/new", method = RequestMethod.POST)
    @ResponseBody
    public Visit newVisit (@RequestBody Visit newVisit, HttpSession session) {

        vRepo.save(newVisit);
        User user = (User) session.getAttribute("user");



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:SS");
        System.out.println(new Date().getTime());
        return newVisit;

    };

    @RequestMapping (value = "visit/new", method = RequestMethod.GET)
    @ResponseBody
    public Visit getVisit (@RequestBody Visit newVisit, HttpSession session) {



        vRepo.save(newVisit);

        return newVisit;

    };




    @RequestMapping (value = "visit/test", method = RequestMethod.GET)
    @ResponseBody
    public Visit visitTest (@RequestBody Visit newVisit) {

        vRepo.save(newVisit);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:SS");
        System.out.println(new Date().getTime());
        return newVisit;

    };




}
