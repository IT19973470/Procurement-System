// @ts-nocheck
import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-purchase-orders',
  templateUrl: './list-purchase-orders.component.html',
  styleUrls: ['./list-purchase-orders.component.css']
})
export class ListPurchaseOrdersComponent implements OnInit {

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

  constructor(private router:Router) {
  }

  ngOnInit(): void {
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

  viewPO(){
    this.router.navigate(['/view_purchase_orders'])
  }
}
