export interface Hyperglycemia {
    dateOfAnalysis: string
    id: string
    pregnancies: number
    glucose: number
    bloodPressure: number
    skinThickness: number
    insulin: number
    bmi: number
    diabetesPedigreeFunction: number
    age: number
    outcome: number // 1 if affected , 0 if notDate dateOfAnalysi:;
    // we 't hav: patient db here so we register only it's id
    patientBlockChainId: string

}