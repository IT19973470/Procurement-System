package lk.backend.service.impl;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.SupplierService;
import lk.backend.service.factory.OrderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    private OrderFactory orderFactory = OrderFactory.getOrderFactory();

    @Override
    public List<PurchaseOrder> getPurchaseOrders(String supplierId) {
        return orderFactory.getOrderObj("SupplierOrder").getOrders(purchaseOrderRepository, supplierId);
    }

    @Override
    public boolean acceptOrder(String orderId) {
        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            PurchaseOrder purchaseOrder = orderOptional.get();
            purchaseOrder.setPoAccepted(true);
            purchaseOrderRepository.save(purchaseOrder);
            return true;
        }
        return false;
    }

    @Override
    public PurchaseOrder finalizePurchaseOrder(PurchaseOrder purchaseOrder, String id) {
        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(id);
        if (orderOptional.isPresent()) {
            PurchaseOrder purchaseOrderObj = orderOptional.get();
            purchaseOrderObj.setPurchaseOrderDetails(purchaseOrder.getPurchaseOrderDetails());
            for (PurchaseOrderDetail purchaseOrderDetaiObj : purchaseOrderObj.getPurchaseOrderDetails()) {
                purchaseOrderDetaiObj.setPurchaseOrder(purchaseOrderObj);
            }
            purchaseOrderObj.setPoFinalized(true);
            purchaseOrderObj.setIdFormatted(purchaseOrderObj.getFormattedId());
            purchaseOrderRepository.save(purchaseOrderObj);
            return new PurchaseOrder(purchaseOrderObj);
        }
        return null;
    }
}
