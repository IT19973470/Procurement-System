// @ts-nocheck
import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {PurchaseOrderService} from "../../../_service/purchase-order.service";

@Component({
  selector: 'app-purchase-orders',
  templateUrl: './purchase-orders.component.html',
  styleUrls: ['./purchase-orders.component.css']
})
export class PurchaseOrdersComponent implements OnInit {

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

  constructor(private router: Router, private poService: PurchaseOrderService) {
  }

  ngOnInit(): void {
    this.getPurchaseOrders()
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

  viewPO(order) {
    this.poService.order = order
    this.router.navigate(['/purchase_order_details'])
  }

  getPurchaseOrders() {
    this.poService.getPurchaseOrders().subscribe(orders => {
      console.log(orders)
      this.orders = orders
    })
  }

}
