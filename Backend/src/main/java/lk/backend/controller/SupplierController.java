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

    @GetMapping(value = "/getPurchaseOrders/{supplierId}")
    public List<PurchaseOrder> getPurchaseOrders(@PathVariable String supplierId) {
        return supplierService.getPurchaseOrders(supplierId);
    }

    @GetMapping(value = "/acceptOrder/{orderId}")
    public boolean acceptOrder(@PathVariable String orderId) {
        return supplierService.acceptOrder(orderId);
    }

//    @GetMapping(value = "/getPumpedAmounts/{id}")
//    public List<CustomerFuelStation> getPumpedAmounts(@PathVariable String id) {
//        return supplierService.getPumpedAmounts(id);
//    }
//
//    @GetMapping(value = "/getCustomer/{email}/{contactNumber}")
//    public Customer getCustomer(@PathVariable String email, @PathVariable String contactNumber) {
//        return supplierService.getCustomer(email, contactNumber);
//    }
//
//    @DeleteMapping(value = "/deleteCustomer/{id}")
//    public boolean deleteCustomer(@PathVariable String id) {
//        return supplierService.deleteCustomer(id);
//    }
//
//    @GetMapping(value = "/sendOTP/{email}/{contactNumber}")
//    public Customer sendOTP(@PathVariable String email, @PathVariable String contactNumber) {
//        return supplierService.sendOTP(email, contactNumber);
//    }
//
//    @GetMapping(value = "/fuelAvailability/{place}/{orderBy}")
//    public List<FuelAvailabilityDTO> fuelAvailability(@PathVariable String place, @PathVariable String orderBy) {
//        return supplierService.fuelAvailability(place, orderBy);
//    }
//
//    @PostMapping(value = "/addFuelConsumption")
//    public ResponseEntity addFuelConsumption(@RequestBody FuelConsumption fuelConsumption) {
//        return ResponseEntity.ok(supplierService.addFuelConsumption(fuelConsumption));
//    }

//    @DeleteMapping(value = "/deleteFuelConsumption/{id}")
//    public boolean deleteFuelConsumption(@PathVariable String id) {
//        return supplierService.deleteFuelConsumption(id);
//    }
//
//    @GetMapping(value = "/getFuelConsumptions/{id}")
//    public List<FuelConsumption> getFuelConsumptions(@PathVariable String id) {
//        return supplierService.getFuelConsumptions(id);
//    }
//
//    @GetMapping(value = "/getFuelAvailabilityM/{place}")
//    public List<FuelAvailabilityDTO> getFuelAvailabilityM(@PathVariable String place) {
//        return supplierService.getFuelAvailabilityM(place);
//    }
//
//    @GetMapping(value = "/getFuelConsumptionsM/{vehicle}")
//    public FuelAvailabilityDTO getFuelConsumptionsM(@PathVariable String vehicle) {
//        return supplierService.getFuelConsumptionsM(vehicle);
//    }
//
//    @GetMapping(value = "/regenerateQR/{vehicle}")
//    public Vehicle regenerateQR(@PathVariable String vehicle) {
//        return supplierService.regenerateQR(vehicle);
//    }
}
