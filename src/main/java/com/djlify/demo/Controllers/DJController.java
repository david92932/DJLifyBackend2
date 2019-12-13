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
