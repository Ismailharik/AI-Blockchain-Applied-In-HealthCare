package com.enset.hostpitalserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
                /*
                * This data should be stored on block chain
                * I have stored it there just for test purpose
                * */
public class DoctorReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String diseaseReport;
    private String doctorName;
    private String hospitalName;


}
