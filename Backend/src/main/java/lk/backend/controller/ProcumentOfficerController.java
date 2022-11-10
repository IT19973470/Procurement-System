package lk.backend.controller;

import lk.backend.entity.Material;
import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.service.ProcumentOfficerService;
import lk.backend.service.SiteManagerService;
import lk.backend.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = CommonConstants.PROCUMENTARY + CommonConstants.PROCUMENT_OFFICER)
public class ProcumentOfficerController {

    @Autowired
    private ProcumentOfficerService procumentOfficerService;

    @PostMapping(value = "/updatePR")
    public ResponseEntity updatePR(@RequestBody PurchaseOrderDetail purchaseOrderDetail) {
        return ResponseEntity.ok(procumentOfficerService.updatePR(purchaseOrderDetail));
    }

    @DeleteMapping(value = "/removePR/{itemId}")
    public ResponseEntity removePR(@PathVariable String itemId) {
        return ResponseEntity.ok(procumentOfficerService.removePR(itemId));
    }

    @GetMapping(value = "/approveOrder/{orderId}")
    public ResponseEntity approveOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(procumentOfficerService.approveOrder(orderId));
    }

    @GetMapping(value = "/getSuppliers")
    public ResponseEntity getSuppliers() {
        return ResponseEntity.ok(procumentOfficerService.getSuppliers());
    }

    @GetMapping(value = "/sendSupplier/{purchaseOrder}/{supplier}")
    public ResponseEntity sendSupplier(@PathVariable String purchaseOrder, @PathVariable String supplier) {
        return ResponseEntity.ok(procumentOfficerService.sendSupplier(purchaseOrder, supplier));
    }

    @GetMapping(value = "/viewQuotations/{companyId}")
    public ResponseEntity viewQuotations(@PathVariable String companyId) {
        return ResponseEntity.ok(procumentOfficerService.viewQuotations(companyId));
    }

    @GetMapping(value = "/quotationSuppliers/{poId}")
    public ResponseEntity quotationSuppliers(@PathVariable String poId) {
        return ResponseEntity.ok(procumentOfficerService.quotationSuppliers(poId));
    }

    @GetMapping(value = "/quotationDetails/{poId}/{supplierId}")
    public ResponseEntity quotationDetails(@PathVariable String poId, @PathVariable String supplierId) {
        return ResponseEntity.ok(procumentOfficerService.quotationDetails(poId, supplierId));
    }
}
