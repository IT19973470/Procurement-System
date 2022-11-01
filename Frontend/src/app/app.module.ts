import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ScrollingModule} from "@angular/cdk/scrolling";
import {NotifierModule, NotifierOptions} from "angular-notifier";
import {DatePipe} from "@angular/common";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ContentComponent } from './content/content.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddMaterialComponent } from './content/add-material/add-material.component';
import { PurchaseOrderDetailsComponent } from './content/supplier/purchase-order-details/purchase-order-details.component';
import { SupplierOrderDetailsComponent } from './content/warehouse_manager/supplier-order-details/supplier-order-details.component';
import { SupplierOrdersComponent } from './content/warehouse_manager/supplier-orders/supplier-orders.component';
import { PurchaseOrdersComponent } from './content/supplier/purchase-orders/purchase-orders.component';
const customNotifierOptions: NotifierOptions = {
  position: {
    horizontal: {
      position: "middle",
      distance: 5
    },
    vertical: {
      position: "top",
      distance: 10,
      gap: 10
    }
  },
  theme: "material",
  behaviour: {
    autoHide: 5000,
    onClick: false,
    onMouseover: "pauseAutoHide",
    showDismissButton: false,
    stacking: 4
  },
  animations: {
    enabled: true,
    show: {
      preset: "slide",
      speed: 300,
      easing: "ease"
    },
    hide: {
      preset: "fade",
      speed: 300,
      easing: "ease",
      offset: 50
    },
    shift: {
      speed: 300,
      easing: "ease"
    },
    overlap: 150
  }
};

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContentComponent,
    NavbarComponent,
    AddMaterialComponent,
    PurchaseOrderDetailsComponent,
    SupplierOrderDetailsComponent,
    SupplierOrdersComponent,
    PurchaseOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ScrollingModule,
   NotifierModule.withConfig(customNotifierOptions)
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
