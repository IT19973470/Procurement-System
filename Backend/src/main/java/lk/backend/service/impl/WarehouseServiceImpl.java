package lk.backend.service.impl;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.SupplierService;
import lk.backend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getFinalizedSupplierOrders(String warehouseId) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getAllByWarehouseManagerIdAndPoFinalized(warehouseId, true);
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            PurchaseOrder purchaseOrderObj = new PurchaseOrder(purchaseOrder, null, purchaseOrder.getSupplier());
            List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
                purchaseOrderDetails.add(new PurchaseOrderDetail(purchaseOrderDetail));
            }
            purchaseOrderObj.setPurchaseOrderDetailList(purchaseOrderDetails);
            purchaseOrderList.add(purchaseOrderObj);
        }
        return purchaseOrderList;
    }
}
