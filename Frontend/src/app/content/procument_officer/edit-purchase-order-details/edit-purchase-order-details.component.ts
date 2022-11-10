// @ts-nocheck
import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {SupplierService} from "../../../_service/supplier.service";
import {WarehouseService} from "../../../_service/warehouse.service";
import {ProcumentOfficerService} from "../../../_service/procument-officer.service";
import {SiteManagerService} from "../../../_service/site-manager.service";

@Component({
  selector: 'app-edit-purchase-order-details',
  templateUrl: './edit-purchase-order-details.component.html',
  styleUrls: ['./edit-purchase-order-details.component.css']
})
export class EditPurchaseOrderDetailsComponent implements OnInit {

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

  isModalTableDetails = {
    text: '',
    openTable: false,
    foundLetter: ''
  };

  isModalTableDetailsRej = {
    text: '',
    openTable: false,
    foundLetter: ''
  };

  order
  orderDetails = []
  total = 0

  constructor(private wareHouseService: WarehouseService, private procumentOfficerService: ProcumentOfficerService, private siteManagerService: SiteManagerService, private router: Router) {
    this.item = this.procumentOfficerService.newItem()
  }

  ngOnInit(): void {
    this.getSupplierOrderDetails()
    this.calcTotal()
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

  calcTotal() {
    this.total = 0
    for (let orderDetail of this.orderDetails) {
      this.total += (orderDetail.poUnitPrice * orderDetail.poQuantity)
    }
    // this.wareHouseService.order.poTotal = this.total
  }

  isTrueOrFalseDetails(reply) {
    this.isModalTableDetails.openTable = reply;
  }

  isTrueOrFalseDetailsRej(reply) {
    this.isModalTableDetailsRej.openTable = reply;
  }

  item

  addItem() {
    let poDetail = {
      id: 'PD' + this.order.id + this.item.id,
      material: {
        id: this.item.id
      },
      poUnitPrice: this.item.poUnitPrice,
      poQuantity: this.item.poQuantity,
      purchaseOrder: {
        id: this.order.id
      }
    }
    this.procumentOfficerService.updatePR(poDetail).subscribe((item) => {
      this.orderDetails.push({
        id: item.id,
        material: {
          id: this.item.id,
          itemName: this.item.itemName,
          itemType: this.item.itemType
        },
        poUnitPrice: this.item.poUnitPrice,
        poQuantity: this.item.poQuantity
      })
      this.calcTotal()
    })
    this.isTrueOrFalseDetails(false)
  }

  getItemById() {
    this.siteManagerService.getItemById(this.item.id).subscribe(item => {
      this.item = item
    })
  }

  approvePR() {
    this.order.purchaseOrderDetails = this.orderDetails
    this.procumentOfficerService.approveOrder(this.order.id).subscribe(() => {
      this.router.navigate(['/edit_purchase_orders'])
    })
  }

  viewSuppliers() {
    this.router.navigate(['/send_quotations'])
  }
}
