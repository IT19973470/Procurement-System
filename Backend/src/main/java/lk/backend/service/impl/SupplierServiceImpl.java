package lk.backend.service.impl;

import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;
import lk.backend.repository.PurchaseOrderRepository;
import lk.backend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getPurchaseOrders(String supplierId) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getAllBySupplierId(supplierId);
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
            purchaseOrderRepository.save(purchaseOrderObj);
            return new PurchaseOrder(purchaseOrderObj);
        }
        return null;
    }
}
