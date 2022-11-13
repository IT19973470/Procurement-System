import {Component, OnInit} from '@angular/core';
import {SiteManagerService} from "../site-manager.service";
import {ProcumentOfficerService} from "../procument-officer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-view-pr-details',
  templateUrl: './view-pr-details.component.html',
  styleUrls: ['./view-pr-details.component.scss'],
})
export class ViewPrDetailsComponent implements OnInit {

  order;
  orderDetails = []
  total = 0
  item
  isModalTableDetails = {
    text: '',
    openTable: false,
    foundLetter: ''
  };

  constructor(private siteManagerService: SiteManagerService, private procumentOfficerService: ProcumentOfficerService, private router: Router) {
    this.item = this.procumentOfficerService.newItem()
  }

  ngOnInit(): void {
    this.getSupplierOrderDetails()
    this.calcTotal()
  }

  getSupplierOrderDetails() {
    this.order = this.siteManagerService.order
    this.orderDetails = this.siteManagerService.order.purchaseOrderDetailList
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

  getItemById() {
    this.siteManagerService.getItemById(this.item.id).subscribe(item => {
      this.item = item
    })
  }

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

  removePO() {
    this.procumentOfficerService.removePurchaseOrder(this.order.id).subscribe(() => {
      this.router.navigate(['/view_pr'])
    })
  }

  print() {
    // let printContents, popupWin;
    // printContents = document.getElementById('print-section').innerHTML;
    // popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    // popupWin.document.open();
    // popupWin.document.write(`
    //   <html>
    //     <head>
    //       <title>Print tab</title>
    //       <!--<style>-->
    //       <!--//........Customized style.......-->
    //       <!--</style>-->
    //     </head>
    // <body onload="window.print();window.close()">${printContents}</body>
    //   </html>`
    // );
    var mywindow = window.open('', 'PRINT', 'height=400,width=600');

    mywindow.document.write('<html><head><title>' + document.title  + '</title>');
    mywindow.document.write('</head><body>');
    mywindow.document.write(document.getElementById('print-section').innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/

    // mywindow.print();
    // mywindow.close();
  }

}
