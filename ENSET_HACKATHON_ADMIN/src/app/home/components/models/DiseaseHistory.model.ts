export interface DiseaseHistory{
    userId:string,
    records:{diseaseReport:string,doctorName:string,hospitalName:string}[]
}