// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-purchase-orders',
  templateUrl: './view-purchase-orders.component.html',
  styleUrls: ['./view-purchase-orders.component.css']
})
export class ViewPurchaseOrdersComponent implements OnInit {

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
