import { Component, Input } from '@angular/core';




@Component({
  selector: 'app-list-table-component',
  templateUrl: './list-table-component.component.html',
  styleUrls: ['./list-table-component.component.scss']
})




export class ListTableComponentComponent {

  displayedColumns: string[] = ['service', 'price'];

  @Input() dataSource : JSON;
  @Input() title : string;
  // dataSource = this.data;

}
