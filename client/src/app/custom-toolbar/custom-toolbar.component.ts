import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-custom-toolbar',
  templateUrl: './custom-toolbar.component.html',
  styleUrls: ['./custom-toolbar.component.scss']
})
export class CustomToolbarComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  btnAbout = function () {
    this.router.navigateByUrl('/home')
  }

  btnPrices = function () {
    this.router.navigateByUrl('/cennik');
};

}
