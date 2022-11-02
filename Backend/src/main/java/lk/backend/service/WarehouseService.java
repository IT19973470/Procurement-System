package lk.backend.service;

import lk.backend.entity.PurchaseOrder;

import java.util.List;

public interface WarehouseService {
//    Customer addCustomer(Customer customer);
//
//    Customer getCustomer(String email, String contactNumber);
//
//    boolean deleteCustomer(String id);
//
//    Customer updateCustomer(Customer customer, String id);
//
//    Customer getCustomerByVehicle(String vehicle);
//
//    List<CustomerFuelStation> getPumpedAmounts(String id);
//
//    Customer sendOTP(String email, String contactNumber);
//
//    List<FuelAvailabilityDTO> fuelAvailability(String place, String orderBy);
//
//    FuelConsumption addFuelConsumption(FuelConsumption fuelConsumption);
//
//    List<FuelConsumption> getFuelConsumptions(String id);
//
//    boolean deleteFuelConsumption(String id);
//
//    List<FuelAvailabilityDTO> getFuelAvailabilityM(String id);
//
//    FuelAvailabilityDTO getFuelConsumptionsM(String vehicle);
//
//    Vehicle regenerateQR(String vehicle);

    List<PurchaseOrder> getFinalizedSupplierOrders(String warehouseId);

    PurchaseOrder finalizeSupplierOrder(PurchaseOrder purchaseOrder, String id);
}