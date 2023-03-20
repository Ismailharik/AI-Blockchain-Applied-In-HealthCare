import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PatientDetailsComponent } from './home/components/patient-details/patient-details.component';
import { PatientListComponent } from './home/components/patient-list/patient-list.component';

const routes: Routes = [
  {path:"home",component:PatientListComponent},
  {path:"patient-details/:id",component:PatientDetailsComponent},
  { path: '**', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
