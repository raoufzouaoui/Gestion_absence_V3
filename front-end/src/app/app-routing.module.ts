import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { LoginComponent } from './components/pages/login/login.component';
import { RegisterComponent } from './components/pages/register/register.component';
import { GestionEtudiantComponent } from './components/pages/gestion-etudiant/gestion-etudiant.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path:'',component:HomeComponent,canActivate:[AuthGuard]  },
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'gestion-etudiant',component:GestionEtudiantComponent,canActivate:[AuthGuard] },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
