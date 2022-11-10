package lk.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quotation {

    @Id
    private String id;
    @Transient
    private String idFormatted;
    @ManyToOne
    private PurchaseOrder purchaseOrder;
    @ManyToOne
    private AppUser supplier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotation")
    private Set<QuotationDetail> quotationDetails;
//    private String itemName;
//    private String itemType;
//    private double poUnitPrice;
//    private int poQuantity;
//    private double soUnitPrice;
//    private int soQuantity;
//    private String status;

//    public Quotation(Quotation purchaseOrderDetail) {
//        this.id = purchaseOrderDetail.id;
//        this.itemName = purchaseOrderDetail.itemName;
//        this.itemType = purchaseOrderDetail.itemType;
//        this.poUnitPrice = purchaseOrderDetail.poUnitPrice;
//        this.poQuantity = purchaseOrderDetail.poQuantity;
//        this.soUnitPrice = purchaseOrderDetail.soUnitPrice;
//        this.soQuantity = purchaseOrderDetail.soQuantity;
//        this.status = purchaseOrderDetail.status;
//    }
//
//    public Quotation(Quotation purchaseOrderDetail, PurchaseOrder purchaseOrder, AppUser warehouseManager, AppUser supplier) {
//        this(purchaseOrderDetail);
//        if (purchaseOrder != null && warehouseManager != null && supplier != null) {
//            this.purchaseOrder = new PurchaseOrder(purchaseOrder, warehouseManager, supplier);
//        }
//    }
}
