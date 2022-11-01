// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PurchaseOrderService} from "../../../_service/purchase-order.service";

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  order
  orderDetails = []

  constructor(private router: Router, private poService: PurchaseOrderService) {
  }

  ngOnInit(): void {
    this.getPurchaseOrderDetails()
  }

  getPurchaseOrderDetails() {
    this.order = this.poService.order
    this.orderDetails = this.poService.order.purchaseOrderDetailList
    for (let orderDetail of this.orderDetails) {
      orderDetail.r_unitPrice = orderDetail.unitPrice
      orderDetail.r_quantity = orderDetail.quantity
    }
  }
}
