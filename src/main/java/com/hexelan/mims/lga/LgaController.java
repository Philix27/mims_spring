package com.hexelan.mims.lga;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LgaController {
    @GetMapping("/")
//    public List<LgaEntity> getAllLgas() {
    public String getAllLgas() {
        return "List of lgas";
    }

@GetMapping(value = "/")
    public String getOneLga() {
        return "List of lgas";
    }
}
