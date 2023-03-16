package com.enset.hostpitalserivce.services;

import com.enset.hostpitalserivce.model.UserRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    @Override
    public void handleUserRequest(UserRequest userRequest) {
        System.out.println(userRequest);
    }
}
