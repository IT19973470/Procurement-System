// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PurchaseOrderService} from "../../../_service/purchase-order.service";
import {SupplierService} from "../../../_service/supplier.service";

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  order
  orderDetails = []

  constructor(private router: Router, private supplierService: SupplierService) {
  }

  ngOnInit(): void {
    this.getPurchaseOrderDetails()
  }

  getPurchaseOrderDetails() {
    this.order = this.supplierService.order
    this.orderDetails = this.supplierService.order.purchaseOrderDetailList
    // for (let orderDetail of this.orderDetails) {
    //   orderDetail.r_unitPrice = orderDetail.unitPrice
    //   orderDetail.r_quantity = orderDetail.quantity
    // }
  }
}
