import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Diabets } from '../models/diabets';
import { Patient } from '../models/Patient';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  checkAnaysis(diabets: Diabets):Observable<number> {
    const featuresData = [
      Number(diabets.Pregnancies),
      Number(diabets.Glucose),
      Number(diabets.BloodPressure),
      Number(diabets.SkinThickness),
      Number(diabets.Insulin),
      Number(diabets.BMI),
      Number(diabets.DiabetesPedigreeFunction),
      Number(diabets.Age)
    ];
  
    const data = {
      features: featuresData.map(Number)
    };
  
    const jsonData = JSON.stringify(data);
    console.log(jsonData);
    
    return this.httpClient.post<number>("http://localhost:5000/predict", jsonData);
  }


  constructor(private httpClient:HttpClient) { 

  }
  addPatient(patient:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>("http://localhost:8083/", patient);
  }


}
