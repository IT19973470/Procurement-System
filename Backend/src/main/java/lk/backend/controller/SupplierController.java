package lk.backend.controller;

import lk.backend.entity.PurchaseOrder;
import lk.backend.service.SupplierService;
import lk.backend.service.command.FinalizeOrderCommand;
import lk.backend.service.command.FinalizePurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "procumentary/" + "supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    private FinalizeOrderCommand finalizeOrderCommand = new FinalizeOrderCommand();

    @PutMapping(value = "/finalizePurchaseOrder/{id}")
    public ResponseEntity finalizePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder, @PathVariable String id) {
        finalizeOrderCommand.commandPurchaseOrder = new FinalizePurchaseOrder(supplierService);
        return ResponseEntity.ok(finalizeOrderCommand.commandPurchaseOrder.finalizeOrder(purchaseOrder, id));
    }

    @PutMapping(value = "/finalizeQuotation/{id}")
    public ResponseEntity finalizeQuotation(@RequestBody PurchaseOrder purchaseOrder, @PathVariable String id) {
//        finalizeOrderCommand.commandPurchaseOrder = new FinalizePurchaseOrder(supplierService);
        return ResponseEntity.ok(supplierService.finalizeQuotation(purchaseOrder, id));
    }

    @GetMapping(value = "/getPurchaseOrders/{supplierId}")
    public List<PurchaseOrder> getPurchaseOrders(@PathVariable String supplierId) {
        return supplierService.getPurchaseOrders(supplierId);
    }

    @GetMapping(value = "/getQuotations/{supplierId}")
    public List<PurchaseOrder> getQuotations(@PathVariable String supplierId) {
        return supplierService.getQuotations(supplierId);
    }

    @GetMapping(value = "/acceptOrder/{orderId}")
    public boolean acceptOrder(@PathVariable String orderId) {
        return supplierService.acceptOrder(orderId);
    }

}
