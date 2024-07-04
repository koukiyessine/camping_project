import { Camping } from './../shared/camping';
import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CampingService {


  constructor(private http: HttpClient, @Inject('BaseURL') private baseUrl: string) { }

  getCampings(): Observable<Camping[]> {
    return this.http.get<Camping[]>(this.baseUrl + "campings");
  }
}
