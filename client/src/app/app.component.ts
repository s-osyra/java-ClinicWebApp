import { Component, OnInit } from '@angular/core';
import * as chirurgiaJSON from '../assets/cennik/chirurgia.json';


let chirurgia = JSON.parse(JSON.stringify(chirurgiaJSON)).default; 


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'client';
  displayedColumns: string[] = ['service', 'price'];
  dataSource = chirurgia;

}

