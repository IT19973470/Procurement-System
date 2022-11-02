import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PurchaseOrdersComponent} from "./content/supplier/purchase-orders/purchase-orders.component";
import {PurchaseOrderDetailsComponent} from "./content/supplier/purchase-order-details/purchase-order-details.component";
import {SupplierOrdersComponent} from "./content/warehouse_manager/supplier-orders/supplier-orders.component";
import {SupplierOrderDetailsComponent} from "./content/warehouse_manager/supplier-order-details/supplier-order-details.component";
import {InvoiceComponent} from "./content/supplier/invoice/invoice.component";
import {EditPurchaseOrderComponent} from "./content/procument_officer/edit-purchase-order/edit-purchase-order.component";
import {EditPurchaseOrderDetailsComponent} from "./content/procument_officer/edit-purchase-order-details/edit-purchase-order-details.component";
import {ManageMaterialComponent} from "./content/site_manager/manage-material/manage-material.component";
import {CreatePrComponent} from "./content/site_manager/create-pr/create-pr.component";
import {ViewPrComponent} from "./content/site_manager/view-pr/view-pr.component";

const routes: Routes = [
  {
    path: "",
    // redirectTo: "supplier_orders",
    // redirectTo: "purchase_orders",
    redirectTo: "edit_purchase_orders",
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
  },

  {
    path: "edit_purchase_orders",
    component: EditPurchaseOrderComponent
  },
  {
    path: "edit_purchase_order_details",
    component: EditPurchaseOrderDetailsComponent
  },

  {
    path: "manage_material",
    component: ManageMaterialComponent
  },
  {
    path: "create_pr",
    component: CreatePrComponent
  },
  {
    path: "view_pr",
    component: ViewPrComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
