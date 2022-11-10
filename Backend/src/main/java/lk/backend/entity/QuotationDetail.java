package lk.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuotationDetail {

    @Id
    private String id;
    @Transient
    private String idFormatted;
    @ManyToOne
    private Quotation quotation;
    @ManyToOne
    private PurchaseOrderDetail purchaseOrderDetail;
    private double soUnitPrice;
    private int soQuantity;

    public QuotationDetail(QuotationDetail purchaseOrderDetail) {
        this.id = purchaseOrderDetail.id;
//        this.itemName = purchaseOrderDetail.itemName;
//        this.itemType = purchaseOrderDetail.itemType;
//        this.poUnitPrice = purchaseOrderDetail.poUnitPrice;
//        this.poQuantity = purchaseOrderDetail.poQuantity;
        this.soUnitPrice = purchaseOrderDetail.soUnitPrice;
        this.soQuantity = purchaseOrderDetail.soQuantity;
//        this.status = purchaseOrderDetail.status;
    }

//    public QuotationDetail(QuotationDetail purchaseOrderDetail, PurchaseOrder purchaseOrder, AppUser warehouseManager, AppUser supplier) {
//        this(purchaseOrderDetail);
//        if (purchaseOrder != null && warehouseManager != null && supplier != null) {
//            this.purchaseOrder = new PurchaseOrder(purchaseOrder, warehouseManager, supplier);
//        }
//    }
}
