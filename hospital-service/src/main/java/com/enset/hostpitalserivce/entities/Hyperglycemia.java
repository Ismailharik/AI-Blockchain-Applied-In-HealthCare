package com.enset.hostpitalserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hyperglycemia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  double pregnancies;
    private double Glucose;
    private double bloodPressure;
    private double skinThickness;
    private double insulin;
    private double bmi;
    private double diabetesPedigreeFunction;
    private int age;
    private int outcome; // 1 if affected , 0 if not

    private Date dateOfAnalysis;
    // we don't have patient db here so we register only it's id
    private String patientBlockChainId;


}
