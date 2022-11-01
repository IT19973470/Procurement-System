import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ViewOrderDetailsComponent} from "./content/view-order-details/view-order-details.component";
import {ViewPurchaseOrdersComponent} from "./content/supplier/view-purchase-orders/view-purchase-orders.component";
import {ListPurchaseOrdersComponent} from "./content/supplier/list-purchase-orders/list-purchase-orders.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "list_purchase_orders",
    pathMatch: "full"
  },
  {
    path: "view_order_details",
    component: ViewOrderDetailsComponent
  },
  {
    path: "view_purchase_orders",
    component: ViewPurchaseOrdersComponent
  },
  {
    path: "list_purchase_orders",
    component: ListPurchaseOrdersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
