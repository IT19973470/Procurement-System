package lk.backend.service;

import lk.backend.entity.PurchaseOrder;
import lk.backend.repository.PurchaseOrderRepository;

import java.util.List;

public interface OrderService {

    List<PurchaseOrder> getOrders(PurchaseOrderRepository purchaseOrderRepository, String id);
}
