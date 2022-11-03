// @ts-nocheck
import { Component, OnInit } from '@angular/core';
import {SiteManagerService} from "../../../../../../Frontend/src/app/_service/site-manager.service";

@Component({
  selector: 'app-view-pr',
  templateUrl: './view-pr.component.html',
  styleUrls: ['./view-pr.component.scss'],
})
export class ViewPrComponent implements OnInit {

  orders = []

  isModalTableDetails = {
    text: '',
    openTable: false,
    foundLetter: ''
  };

  constructor(private siteManagerService: SiteManagerService) {
  }

  ngOnInit(): void {
    this.getPRs()
  }

  isTrueOrFalseDetails(reply) {
    this.isModalTableDetails.openTable = reply;
  }

  getPRs() {
    this.siteManagerService.getPRs().subscribe(prs => {
      this.orders = prs
    })
  }

}
