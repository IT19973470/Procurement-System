package lk.backend.service.command;

import lk.backend.entity.PurchaseOrder;
import lk.backend.service.SupplierService;
import lk.backend.service.WarehouseService;

public class FinalizeSupplierOrder implements CommandOrder {

    private WarehouseService warehouseService;

    public FinalizeSupplierOrder(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Override
    public PurchaseOrder finalizeOrder(PurchaseOrder purchaseOrder, String id) {
        return warehouseService.finalizeSupplierOrder(purchaseOrder, id);
    }

}
