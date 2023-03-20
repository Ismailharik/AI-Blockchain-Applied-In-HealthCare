export interface Hyperglycemia {
    id: number,
    pregnancies: number,
    glucose: number,
    bloodPressure: number,
    skinThickness: number,
    insulin: number,
    bmi: number,
    diabetesPedigreeFunction: number,
    age: number,
    outcome: number, // 1 if affected , 0 if not

    dateOfAnalysis: Date,
    // we don't have patient db here so we register only it's id
    patientId: number,
    patientBlockChainId:string
}