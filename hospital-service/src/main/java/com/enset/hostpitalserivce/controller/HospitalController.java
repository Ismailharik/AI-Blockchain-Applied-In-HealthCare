package com.enset.hostpitalserivce.controller;

import com.enset.hostpitalserivce.model.UserRequest;
import com.enset.hostpitalserivce.services.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")
@AllArgsConstructor
public class HospitalController {
    private HospitalService hospitalService;
    @PostMapping("/userRequest")
    public void addUserRequest(@RequestBody UserRequest userRequest){
        hospitalService.handleUserRequest(userRequest);
        /*
        * Doctor will add analysis information's of it's patient
        * this informations will be treated by the model
        * then result will be shared to the front end
        * then the object (Hospital name , Doctor name ,disease that confirmed by the doctor) will be stored on block chain (
        * from the front end as it's simple from there )
        * */
        /*Traiment User et docteur */


    }
}
