import { Component, OnInit } from '@angular/core';
//import { MapInfoWindow, MapMarker, GoogleMap } from '@angular/google-maps';
import * as chirurgiaJSON from '../../assets/cennik/chirurgia.json';
import * as leczenie_zachowawczeJSON from '../../assets/cennik/leczenie-zachowawcze.json';
import * as profilaktykaJSON from '../../assets/cennik/profilaktyka.json';
import * as zeby_mleczneJSON from '../../assets/cennik/zeby-mleczne.json';

let chirurgiaRaw = chirurgiaJSON;
let DATA_chirurgia = JSON.parse(JSON.stringify(chirurgiaRaw)).default;

let leczenie_zachowawcze = leczenie_zachowawczeJSON;
let DATA_zachowawcze = JSON.parse(JSON.stringify(leczenie_zachowawcze)).default;

let profilaktykaRaw = profilaktykaJSON;
let DATA_profilaktyka = JSON.parse(JSON.stringify(profilaktykaRaw)).default;

let mleczneRaw = zeby_mleczneJSON;
let DATA_mleczne = JSON.parse(JSON.stringify(mleczneRaw)).default;

let imageChange = (id) => {
  let el = document.getElementById(id);
  el.style.filter = "grayscale(0%)";
  el.style.zIndex = "2";
}
let imageReturn = (id) => {
  let el = document.getElementById(id);
  el.style.filter = "grayscale(100%)";
  el.style.zIndex = "0";
}
 

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor() {}

  ngOnInit(): void {
  }

  onTabClick(event) {

    if (event.index == 0) {
      imageChange("image-2")
    } else {
      imageReturn ("image-2")
    }

    if (event.index == 1) {
      imageChange("image-3")
    } else {
      imageReturn ("image-3")
    }
    if (event.index == 2) {
      imageChange("image-4")
    } else {
      imageReturn ("image-4")
    }
    if (event.index == 3) {
      imageChange("image-5")
    } else {
      imageReturn ("image-5")
    }

  }

  chirurgia = DATA_chirurgia;
  chirurgiaTitle = "CHIRURGIA";
  zachowawcze = DATA_zachowawcze;
  zachowawczeTitle = "LECZENIE ZACHOWAWCZE";
  profilaktyka = DATA_profilaktyka;
  profilaktykaTitle = "PROFILAKTYKA";
  mleczne = DATA_mleczne;
  mleczneTitle = "ZĘBY MLECZNE";
  
}

