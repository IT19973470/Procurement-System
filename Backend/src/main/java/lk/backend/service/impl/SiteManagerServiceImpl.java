package lk.backend.service.impl;

import java.util.List;
import java.util.Optional;

import lk.backend.entity.*;
import lk.backend.repository.*;
import lk.backend.service.SiteManagerService;
import lk.backend.service.factory.OrderFactory;
import lk.backend.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteManagerServiceImpl implements SiteManagerService {

    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;
    private OrderFactory orderFactory = OrderFactory.getOrderFactory();

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
        return orderFactory.getOrderObj(CommonConstants.PURCHASE_ORDER).addPR(purchaseOrderRepository, purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPRs() {
        return orderFactory.getOrderObj(CommonConstants.PURCHASE_ORDER).getPRs(purchaseOrderRepository);
    }

    @Override
    public boolean removeItem(String id) {
        return orderFactory.getOrderObj(CommonConstants.PURCHASE_ORDER).removeItem(purchaseOrderDetailRepository, id);
    }

    @Override
    public boolean removeMaterial(String id) {
        materialRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean editInfo(PurchaseOrder purchaseOrder) {
        return orderFactory.getOrderObj(CommonConstants.PURCHASE_ORDER).editInfo(purchaseOrderRepository, purchaseOrder);
    }
}
