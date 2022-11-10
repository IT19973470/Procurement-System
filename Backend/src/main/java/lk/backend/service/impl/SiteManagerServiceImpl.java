package lk.backend.service.impl;

import lk.backend.entity.*;
import lk.backend.repository.*;
import lk.backend.service.SiteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SiteManagerServiceImpl implements SiteManagerService {

    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public Material addItem(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public List<Material> getItems() {
        return materialRepository.findAll();
    }

    @Override
    public Material getItemById(String id) {
        Optional<Material> materialOptional = materialRepository.findById(id);
        if (materialOptional.isPresent()) {
            return materialOptional.get();
        }
        return null;
    }

    @Override
    public PurchaseOrder addPR(PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss")));
        for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
            purchaseOrderDetail.setId("PD" + purchaseOrder.getId() + purchaseOrderDetail.getId());
            purchaseOrderDetail.setStatus("Incomplete");
            purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
        }
        purchaseOrderRepository.save(purchaseOrder);
        return new PurchaseOrder(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPRs() {
        List<PurchaseOrder> purchaseOrderList = purchaseOrderRepository.findAll();
        List<PurchaseOrder> purchaseOrderListDTOs = new ArrayList<>();
        for (PurchaseOrder purchaseOrder : purchaseOrderList) {
            PurchaseOrder purchaseOrderObj = new PurchaseOrder(purchaseOrder);
            List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
                purchaseOrderDetails.add(new PurchaseOrderDetail(purchaseOrderDetail));
            }
            purchaseOrderObj.setPurchaseOrderDetailList(purchaseOrderDetails);
            purchaseOrderListDTOs.add(purchaseOrderObj);
        }
        return purchaseOrderListDTOs;
    }
}
