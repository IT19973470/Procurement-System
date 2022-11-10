package lk.backend.service;

import lk.backend.entity.AppUser;
import lk.backend.entity.Material;
import lk.backend.entity.PurchaseOrder;
import lk.backend.entity.PurchaseOrderDetail;

import java.util.List;

public interface ProcumentOfficerService {
    boolean removePR(String itemId);

    PurchaseOrderDetail updatePR(PurchaseOrderDetail purchaseOrderDetail);

    boolean approveOrder(String orderId);

    List<AppUser> getSuppliers();

    boolean sendSupplier(String purchaseOrder, String supplier);

    List<PurchaseOrder> viewQuotations(String companyId);

    List<AppUser> quotationSuppliers(String poId);

    List<PurchaseOrderDetail> quotationDetails(String poId, String supplierId);
}
