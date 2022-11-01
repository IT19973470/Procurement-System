// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {PurchaseOrderService} from "../../../_service/purchase-order.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-purchase-order-details',
  templateUrl: './purchase-order-details.component.html',
  styleUrls: ['./purchase-order-details.component.css']
})
export class PurchaseOrderDetailsComponent implements OnInit {

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

  order
  orderDetails = []

  constructor(private router: Router, private poService: PurchaseOrderService) {
  }

  ngOnInit(): void {
    this.getPurchaseOrderDetails()
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

  getPurchaseOrderDetails() {
    this.order = this.poService.order
    this.orderDetails = this.poService.order.purchaseOrderDetailList
    for (let orderDetail of this.orderDetails) {
      orderDetail.r_unitPrice = orderDetail.unitPrice
      orderDetail.r_quantity = orderDetail.quantity
    }
  }

  viewInvoice() {
    this.router.navigate(['/view_invoice'])
  }
}
