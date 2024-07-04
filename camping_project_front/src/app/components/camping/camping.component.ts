import { Component, OnInit } from '@angular/core';
import { CampingService } from 'src/app/services/camping.service';
import { Camping } from 'src/app/shared/camping';

@Component({
  selector: 'app-camping',
  templateUrl: './camping.component.html',
  styleUrls: ['./camping.component.css']
})
export class CampingComponent implements OnInit {
  campings: Camping[] = [];
  constructor(private campingService: CampingService) { }

  ngOnInit(): void {
    this.campingService.getCampings().subscribe(
      {
        next: (campings: Camping[]) => {
          this.campings = campings
        },
        error: (err) => {
          console.error('Error fetching campings', err);
        }
      });
  }
}
