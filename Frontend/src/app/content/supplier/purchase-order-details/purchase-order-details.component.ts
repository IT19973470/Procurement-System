// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {PurchaseOrderService} from "../../../_service/purchase-order.service";

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

  orderDetails = []

  constructor(private poService: PurchaseOrderService) {
  }

  ngOnInit(): void {
    this.getPurchaseOrderDetails()
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

  getPurchaseOrderDetails() {
    this.orderDetails = this.poService.order.purchaseOrderDetailList
  }
}
