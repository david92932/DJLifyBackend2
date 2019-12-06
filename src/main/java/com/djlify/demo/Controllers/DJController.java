package com.djlify.demo.Controllers;

import com.djlify.demo.Models.DJModel;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})

public class DJController {

    @RequestMapping(path = "DJ/getDJ")
    public DJModel getDJPage(@RequestParam("ID") int ID) {

        return DJ
    }

}
