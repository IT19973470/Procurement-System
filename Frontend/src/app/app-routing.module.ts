import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PurchaseOrdersComponent} from "./content/supplier/purchase-orders/purchase-orders.component";
import {PurchaseOrderDetailsComponent} from "./content/supplier/purchase-order-details/purchase-order-details.component";
import {SupplierOrdersComponent} from "./content/warehouse_manager/supplier-orders/supplier-orders.component";
import {SupplierOrderDetailsComponent} from "./content/warehouse_manager/supplier-order-details/supplier-order-details.component";
import {InvoiceComponent} from "./content/supplier/invoice/invoice.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "supplier_orders",
    pathMatch: "full"
  },

  {
    path: "purchase_orders",
    component: PurchaseOrdersComponent
  },
  {
    path: "purchase_order_details",
    component: PurchaseOrderDetailsComponent
  },
  {
    path: "view_invoice",
    component: InvoiceComponent
  },

  {
    path: "supplier_orders",
    component: SupplierOrdersComponent
  },
  {
    path: "supplier_order_details",
    component: SupplierOrderDetailsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
