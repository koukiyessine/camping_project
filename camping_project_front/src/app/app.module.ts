import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { CoverComponent } from './components/cover/cover.component';
import { CampingComponent } from './components/camping/camping.component';
import { GuidesComponent } from './components/guides/guides.component';
import { AvisComponent } from './components/avis/avis.component';
import { FooterComponent } from './components/footer/footer.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { TopDestinationsComponent } from './components/top-destinations/top-destinations.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BaseURL } from './shared/baseurl';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CoverComponent,
    CampingComponent,
    GuidesComponent,
    AvisComponent,
    FooterComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent,
    TopDestinationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{
    provide: 'BaseURL', useValue: BaseURL
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
