package lk.backend.controller;

import lk.backend.entity.PurchaseOrder;
import lk.backend.service.SupplierService;
import lk.backend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "procumentary/" + "warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

//    @PostMapping(value = "/addCustomer")
//    public ResponseEntity addCustomer(@RequestBody Customer customer) {
//        return ResponseEntity.ok(supplierService.addCustomer(customer));
//    }
//
//    @PutMapping(value = "/updateCustomer/{id}")
//    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
//        return ResponseEntity.ok(supplierService.updateCustomer(customer, id));
//    }

    @GetMapping(value = "/getFinalizedSupplierOrders/{warehouseId}")
    public List<PurchaseOrder> getFinalizedSupplierOrders(@PathVariable String warehouseId) {
        return warehouseService.getFinalizedSupplierOrders(warehouseId);
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
