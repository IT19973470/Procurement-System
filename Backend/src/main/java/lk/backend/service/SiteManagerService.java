package lk.backend.service;

import lk.backend.entity.Material;
import lk.backend.entity.PurchaseOrder;

import java.util.List;

public interface SiteManagerService {
    Material addItem(Material material);

    List<Material> getItems();

    Material getItemById(String id);

    PurchaseOrder addPR(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> getPRs();
}
