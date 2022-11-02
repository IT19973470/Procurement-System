// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {WarehouseService} from "../../../_service/warehouse.service";

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

  order
  orderDetails = []

  constructor(private wareHouseService: WarehouseService) {
  }

  ngOnInit(): void {
    this.getSupplierOrderDetails()
  }

  reOrderPumps() {

  }

  reOrderConsumes() {

  }

  getSupplierOrderDetails() {
    this.order = this.wareHouseService.order
    this.orderDetails = this.wareHouseService.order.purchaseOrderDetailList
    // for (let orderDetail of this.orderDetails) {
    //   orderDetail.r_unitPrice = orderDetail.unitPrice
    //   orderDetail.r_quantity = orderDetail.quantity
    // }
  }
}
