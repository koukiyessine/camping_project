import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CampingComponent } from './components/camping/camping.component';
import { GuidesComponent } from './components/guides/guides.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { AvisComponent } from './components/avis/avis.component';
import { TopDestinationsComponent } from './components/top-destinations/top-destinations.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: SigninComponent },
  { path: "signin", component: SignupComponent },
  { path: "camping", component: CampingComponent },
  { path: "guides", component: GuidesComponent },
  { path: "avis", component: AvisComponent },
  { path: "destinations", component: TopDestinationsComponent },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
