import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { DiseaseHistory } from './models/DiseaseHistory.model';
import { doctorReport } from './models/doctorReport.model';
import { Hyperglycemia } from './models/hyperglycemia.model';
import { Patient } from './models/patient.model';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  saveDoctorReportOnBlockChain(doctorReport:doctorReport):Observable<any> {
    return this.httpClient.post<any>("http://localhost:3000/store",doctorReport)
  }
  getUserHistoryChain(blockChainId:string):Observable<DiseaseHistory> {
    return this.httpClient.get<DiseaseHistory>("http://localhost:3000/get/"+blockChainId)
  }

  constructor(private httpClient:HttpClient) { }
  getHyperglycemiaAnalysis( patientBlockChainId:string):Observable<Hyperglycemia> {
    return this.httpClient.get<Hyperglycemia>(environment.host+"/hospital/patientAnalysis/"+patientBlockChainId)
  }
  getPatientById(patientId:number):Observable<Patient> {
    return this.httpClient.get<Patient>(environment.host+"/patients/"+patientId)
  }

  getWaitingPatients():Observable<Patient[]>{
    return this.httpClient.get<Patient[]>(environment.host+"/patients/waitingPatients")
  }
}
