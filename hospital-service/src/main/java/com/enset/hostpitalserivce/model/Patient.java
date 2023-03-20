package com.enset.hostpitalserivce.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    private Long id;
    private String phone;
    private String fullName;
    private String email;
    private Date birthdate;
    private String blockChainId;
    private boolean status;

}
