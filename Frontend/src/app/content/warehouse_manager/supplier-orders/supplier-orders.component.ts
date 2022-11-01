// @ts-nocheck
import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-supplier-orders',
  templateUrl: './supplier-orders.component.html',
  styleUrls: ['./supplier-orders.component.css']
})
export class SupplierOrdersComponent implements OnInit {

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
    this.router.navigate(['/supplier_order_details'])
  }

}
