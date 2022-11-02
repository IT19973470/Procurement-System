package lk.backend.service.factory;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.OrderService;
import lk.backend.service.SupplierService;
import lk.backend.service.command.CommandOrder;
import lk.backend.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.CommandObject;
import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseOrderService implements OrderService {

//    @Autowired
//    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getOrders(PurchaseOrderRepository purchaseOrderRepository, String id) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getAllByWarehouseManagerIdAndPoFinalized(id, true);
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
