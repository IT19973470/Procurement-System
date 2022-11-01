// @ts-nocheck
import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PurchaseOrderService {

  order

  constructor(private http: HttpClient) {
  }

  // addCustomer(customer): Observable<any> {
  //   return this.http.post<any>(environment.backend_url + '/customer/addCustomer', customer);
  // }
  //
  // updateCustomer(customer): Observable<any> {
  //   return this.http.put<any>(environment.backend_url + '/customer/updateCustomer/' + customer.nic, customer);
  // }
  //
  // deleteCustomer(id): Observable<any> {
  //   return this.http.delete<any>(environment.backend_url + '/customer/deleteCustomer/' + id);
  // }
  //
  // getCustomer(email, contactNumber): Observable<any> {
  //   return this.http.get<any>(environment.backend_url + '/customer/getCustomer/' + email + '/' + contactNumber);
  // }

  getPurchaseOrders(): Observable<any> {
    return this.http.get<any>(environment.backend_url + '/supplier/getPurchaseOrders/' + JSON.parse(localStorage.getItem('user')).id);
  }
}
