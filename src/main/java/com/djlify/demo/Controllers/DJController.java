package com.djlify.demo.Controllers;

import com.djlify.demo.Models.DJModel;
import com.djlify.demo.Models.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})

public class DJController {

    public static ArrayList<DJModel> allDJs = new ArrayList<>();
    public static ArrayList<UserModel> allDJLogins = new ArrayList<>();

    public void createDJ()
    {
        DJModel djModel;
        djModel = new DJModel("Max", "Hendi", "d00001j00001", "http://google.com", "Best dj on southside of Erie");
        allDJs.add(djModel);
        djModel = new DJModel("Arielle", "Fonso", "d00001j00002", "http://google.com", "Best dj on northside of Erie");
        allDJs.add(djModel);
        djModel = new DJModel("Tyler", "Gillty", "d00001j00003", "http://google.com", "Best dj on Lake Erie");
        allDJs.add(djModel);

    }


    @GetMapping(path = "DJ/getDJ")
    public DJModel getDJ(@RequestParam("ID") String ID) {

        return this.getDJModel(ID);

    }

    @GetMapping(path = "DJ/auth")
    public DJModel authDJ(@RequestParam("username") String username, @RequestParam("password") String password) {

        String userID = null;

        for(DJModel dj: allDJs) {
            if (dj.getUsername().equals(username) && dj.getPassword().equals(password)) {
                userID = dj.getID();
                break;
            }
        }

        return this.getDJModel(userID);


    }

    /**
     * get DJ model by ID
     * @param ID string
     * @return DJ Class instance or null
     */
    private DJModel getDJModel(String ID) {

        if (ID != null) {

            for (DJModel dj : allDJs) {

                if (dj.getID().equals(ID)) {
                    return dj;
                }
            }

        }

        return null;

    }



}
