package lk.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderDetail {

    @Id
    private String id;
    @ManyToOne
    private PurchaseOrder purchaseOrder;
    private String itemName;
    private String itemType;
    private double unitPrice;
    private int quantity;
    private String status;

    public PurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.id = purchaseOrderDetail.id;
        this.itemName = purchaseOrderDetail.itemName;
        this.itemType = purchaseOrderDetail.itemType;
        this.unitPrice = purchaseOrderDetail.unitPrice;
        this.quantity = purchaseOrderDetail.quantity;
        this.status = purchaseOrderDetail.status;
    }

    public PurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail, PurchaseOrder purchaseOrder, AppUser appUser) {
        this(purchaseOrderDetail);
        if (purchaseOrder != null && appUser != null) {
            this.purchaseOrder = new PurchaseOrder(purchaseOrder, appUser);
        }
    }
}
