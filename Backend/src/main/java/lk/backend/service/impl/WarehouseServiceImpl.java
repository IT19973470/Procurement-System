package lk.backend.service.impl;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.SupplierService;
import lk.backend.service.WarehouseService;
import lk.backend.service.factory.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    private OrderFactory orderFactory = OrderFactory.getOrderFactory();

    @Override
    public List<PurchaseOrder> getFinalizedSupplierOrders(String warehouseId) {
        return orderFactory.getOrderObj("PurchaseOrder").getOrders(purchaseOrderRepository, warehouseId);
    }

    @Override
    public PurchaseOrder finalizeSupplierOrder(PurchaseOrder purchaseOrder, String id) {
        return null;
    }
}
