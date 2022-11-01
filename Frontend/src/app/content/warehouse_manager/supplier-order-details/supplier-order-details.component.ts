// @ts-nocheck
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-supplier-order-details',
  templateUrl: './supplier-order-details.component.html',
  styleUrls: ['./supplier-order-details.component.css']
})
export class SupplierOrderDetailsComponent implements OnInit {

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

  constructor() {
  }

  ngOnInit(): void {
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

}
