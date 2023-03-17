package com.enset.hostpitalserivce.entities;

import com.enset.hostpitalserivce.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hyperglycemia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  int Pregnancies;
    private int Glucose;
    private int BloodPressure;
    private int SkinThickness;
    private int Insulin;
    private int BMI;
    private int DiabetesPedigreeFunction;
    private int Age;
    private int Outcome;
    // we don't have patient db here so we register only it's id
    private Long patientId;
}
