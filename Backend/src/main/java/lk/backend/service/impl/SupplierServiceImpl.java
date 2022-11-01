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


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getPurchaseOrders(String supplierId) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.getAllByAppUserId(supplierId);
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrders) {
            PurchaseOrder purchaseOrderObj = new PurchaseOrder(purchaseOrder, purchaseOrder.getAppUser());
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
