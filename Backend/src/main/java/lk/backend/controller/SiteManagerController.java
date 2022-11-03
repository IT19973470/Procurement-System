package lk.backend.controller;

import lk.backend.entity.Material;
import lk.backend.entity.PurchaseOrder;
import lk.backend.service.SiteManagerService;
import lk.backend.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = CommonConstants.PROCUMENTARY + CommonConstants.SITE_MANAGER)
public class SiteManagerController {

    @Autowired
    private SiteManagerService siteManagerService;

    @PostMapping(value = "/addItem")
    public ResponseEntity addItem(@RequestBody Material material) {
        return ResponseEntity.ok(siteManagerService.addItem(material));
    }

    @PostMapping(value = "/addPR")
    public ResponseEntity addPR(@RequestBody PurchaseOrder purchaseOrder) {
        return ResponseEntity.ok(siteManagerService.addPR(purchaseOrder));
    }

    @GetMapping(value = "/getItems")
    public ResponseEntity getItems() {
        return ResponseEntity.ok(siteManagerService.getItems());
    }

    @GetMapping(value = "/getPRs")
    public ResponseEntity getPRs() {
        return ResponseEntity.ok(siteManagerService.getPRs());
    }

    @GetMapping(value = "/getItemById/{id}")
    public ResponseEntity getItemById(@PathVariable String id) {
        return ResponseEntity.ok(siteManagerService.getItemById(id));
    }
}
