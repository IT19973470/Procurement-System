// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {PurchaseOrderService} from "../../../_service/purchase-order.service";
import {AlertBoxService} from "../../../alert-box/alert-box.service";

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

  // isModalTableDetails = {
  //   text: '',
  //   openTable: false,
  //   foundLetter: ''
  // };

  constructor(private router: Router, private poService: PurchaseOrderService, private alertService: AlertBoxService) {
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
      // console.log(orders)
      this.orders = orders
    })
  }

  changeStatus() {
    this.alertBox.alert = true;
    this.alertBox.msg = 'Do you want to accept the order?';
    this.alertService.reply.observers = [];
    this.alertService.reply.subscribe(reply => {
      if (reply) {
        // this.customerS.deleteFuelConsumption(id).subscribe(() => {
        //   this.getFuelConsumptions()
        // })
      }
      this.alertBox.alert = false;
    })
  }

  // isTrueOrFalseDetails(reply) {
  //   this.isModalTableDetails.openTable = reply;
  // }
}
