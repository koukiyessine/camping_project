import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CampingService {
  baseUrl = "http://localhost:3000/camping"
  constructor() { }
}
