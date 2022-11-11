package lk.backend.service.impl;

import lk.backend.entity.*;
import lk.backend.repository.*;
import lk.backend.service.ProcumentOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ProcumentOfficerServiceImpl implements ProcumentOfficerService {

    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private QuotationDetailRepository quotationDetailRepository;

    @Override
    public boolean removePR(String itemId) {
        purchaseOrderDetailRepository.deleteById(itemId);
        return true;
    }

    @Override
    public PurchaseOrderDetail updatePR(PurchaseOrderDetail purchaseOrderDetail) {
        purchaseOrderDetail.setStatus("Incomplete");
        purchaseOrderDetail = purchaseOrderDetailRepository.save(purchaseOrderDetail);
        return new PurchaseOrderDetail(purchaseOrderDetail);
//        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(orderId);
//        if(orderOptional.isPresent()){
//            PurchaseOrder purchaseOrder = orderOptional.get();
//            purchaseOrderDetail.setId("PD" + purchaseOrder.getId());
//            purchaseOrder.getPurchaseOrderDetails().add(purchaseOrderDetail);
//            purchaseOrderR
//            return new PurchaseOrderDetail(purchaseOrderDetail);
//        }
//        return null;
    }

    @Override
    public boolean approveOrder(String orderId) {
        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            PurchaseOrder purchaseOrder = orderOptional.get();
            purchaseOrder.setPoApproved(true);
            purchaseOrderRepository.save(purchaseOrder);
            return true;
        }
        return false;
    }

    @Override
    public List<AppUser> getSuppliers() {
        return userRepository.getAllByUserType("supplier");
    }

    @Override
    public boolean sendSupplier(String purchaseOrderId, String supplierId) {
        Quotation quotation = new Quotation();
        quotation.setId(purchaseOrderId + supplierId);
        quotation.setPurchaseOrder(purchaseOrderRepository.findById(purchaseOrderId).get());
        quotation.setSupplier(userRepository.findById(supplierId).get());
        quotation.setQuotationDetails(new HashSet<>());
        for (PurchaseOrderDetail purchaseOrderDetail : quotation.getPurchaseOrder().getPurchaseOrderDetails()) {
            QuotationDetail quotationDetail = new QuotationDetail();
            quotationDetail.setId(purchaseOrderDetail.getId() + supplierId);
            quotationDetail.setPurchaseOrderDetail(purchaseOrderDetail);
            quotationDetail.setQuotation(quotation);
            quotationDetail.setSoUnitPrice(purchaseOrderDetail.getSoUnitPrice());
            quotationDetail.setSoQuantity(purchaseOrderDetail.getSoQuantity());
            quotation.getQuotationDetails().add(quotationDetail);
        }
        quotationRepository.save(quotation);
        return true;
    }

    @Override
    public List<PurchaseOrder> viewQuotations(String companyId) {
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>();
        List<Quotation> quotationList = quotationRepository.getAllByPurchaseOrderSiteManagerCompanyCompanyId(companyId);
        for (Quotation quotation : quotationList) {
            purchaseOrderList.add(new PurchaseOrder(quotation.getPurchaseOrder()));
        }
        return purchaseOrderList;
    }

    @Override
    public List<AppUser> quotationSuppliers(String poId) {
        List<AppUser> appUsers = new ArrayList<>();
        List<Quotation> quotationList = quotationRepository.getAllByPurchaseOrderId(poId);
        for (Quotation quotation : quotationList) {
            AppUser supplier = quotation.getSupplier();
            supplier.setPurchaseOrderDetailList(quotationDetails(poId, supplier.getId()));
            appUsers.add(supplier);
        }
        return appUsers;
    }

    @Override
    public List<PurchaseOrderDetail> quotationDetails(String poId, String supplierId) {
        Quotation quotation = quotationRepository.getAllByPurchaseOrderIdAndSupplierId(poId, supplierId);
        List<PurchaseOrderDetail> purchaseOrderDetails = new ArrayList<>();
        for (QuotationDetail quotationDetail : quotation.getQuotationDetails()) {
            PurchaseOrderDetail purchaseOrderDetail = quotationDetail.getPurchaseOrderDetail();
            purchaseOrderDetail.setSoUnitPrice(quotationDetail.getSoUnitPrice());
            purchaseOrderDetail.setSoQuantity(quotationDetail.getSoQuantity());
            purchaseOrderDetails.add(new PurchaseOrderDetail(purchaseOrderDetail));
        }
        return purchaseOrderDetails;
    }

    @Override
    public boolean finalizeSupplier(String poId, String supplierId) {
        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(poId);
        Quotation quotation = quotationRepository.getAllByPurchaseOrderIdAndSupplierId(poId, supplierId);
        if (orderOptional.isPresent()) {
            PurchaseOrder purchaseOrder = orderOptional.get();
            purchaseOrder.setSupplier(userRepository.findById(supplierId).get());
            for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrder.getPurchaseOrderDetails()) {
                for (QuotationDetail quotationDetail : quotation.getQuotationDetails()) {
                    if (quotationDetail.getPurchaseOrderDetail().getId().equals(purchaseOrderDetail.getId())) {
                        purchaseOrderDetail.setSoUnitPrice(quotationDetail.getSoUnitPrice());
                        purchaseOrderDetail.setSoQuantity(quotationDetail.getSoQuantity());
                    }
                }
            }
            purchaseOrderRepository.save(purchaseOrder);
        }
        return true;
    }
}
