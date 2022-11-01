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
import { ViewOrderDetailsComponent } from './content/view-order-details/view-order-details.component';
import { ViewPurchaseOrdersComponent } from './content/supplier/view-purchase-orders/view-purchase-orders.component';
import { AddMaterialComponent } from './content/add-material/add-material.component';
import { ListPurchaseOrdersComponent } from './content/supplier/list-purchase-orders/list-purchase-orders.component';
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
    ViewOrderDetailsComponent,
    ViewPurchaseOrdersComponent,
    AddMaterialComponent,
    ListPurchaseOrdersComponent
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
