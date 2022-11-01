package lk.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {

    @Id
    private String id;
    private String orderReference;
    private String deliverNote;
    @ManyToOne
    private AppUser appUser;
    @Transient
    private int quantity;
    private String status;
    private boolean finalized;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private Set<PurchaseOrderDetail> purchaseOrderDetails;
    @Transient
    private List<PurchaseOrderDetail> purchaseOrderDetailList;

    public PurchaseOrder(PurchaseOrder purchaseOrder) {
        this.id = purchaseOrder.id;
        this.status = purchaseOrder.status;
        this.quantity = purchaseOrder.quantity;
        this.orderReference = purchaseOrder.orderReference;
        this.deliverNote = purchaseOrder.deliverNote;
    }

    public PurchaseOrder(PurchaseOrder purchaseOrder, AppUser appUser) {
        this(purchaseOrder);
        if (appUser != null) {
            this.appUser = new AppUser(appUser);
        }
    }
}
