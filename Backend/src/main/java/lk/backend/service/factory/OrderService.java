package lk.backend.service.factory;

import lk.backend.entity.PurchaseOrder;
import lk.backend.repository.PurchaseOrderRepository;

import java.util.List;

public interface OrderService {

    List<PurchaseOrder> getOrders(PurchaseOrderRepository purchaseOrderRepository, String id);
}
