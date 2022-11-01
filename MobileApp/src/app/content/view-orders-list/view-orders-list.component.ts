import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-orders-list',
  templateUrl: './view-orders-list.component.html',
  styleUrls: ['./view-orders-list.component.scss'],
})
export class ViewOrdersListComponent implements OnInit {

  orders = [];
  consumption = 0;
  consumed = 0;
  trip;
  fuelConsumptions = []
  selectedOrderBy1 = ''
  selectedOrderBy2 = ''

  alertBox = {
    alert: false,
    msg: '',
    value: ''
  };

  constructor() { }

  ngOnInit(): void {
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

}
