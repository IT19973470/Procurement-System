// @ts-nocheck
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProcumentOfficerService {

  item

  constructor() {
  }

  newItem() {
    return {
      id: '',
      itemName: '',
      itemType: '',
      poUnitPrice: 0,
      poQuantity: 0
    }
  }
}
