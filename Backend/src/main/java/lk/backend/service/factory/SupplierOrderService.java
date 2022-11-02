package lk.backend.service.factory;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.OrderService;
import lk.backend.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SupplierOrderService implements OrderService {

//    @Autowired
//    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getOrders(PurchaseOrderRepository purchaseOrderRepository, String id) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getAllBySupplierId(id);
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            PurchaseOrder purchaseOrderObj = new PurchaseOrder(purchaseOrder, purchaseOrder.getWarehouseManager(), null);
            List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
                purchaseOrderObj.setPoTotal(purchaseOrderObj.getPoTotal() + (purchaseOrderDetail.getPoUnitPrice() * purchaseOrderDetail.getPoQuantity()));
                purchaseOrderDetails.add(new PurchaseOrderDetail(purchaseOrderDetail));
            }
            purchaseOrderObj.setPurchaseOrderDetailList(purchaseOrderDetails);
            purchaseOrderList.add(purchaseOrderObj);
        }
        return purchaseOrderList;
    }

}
