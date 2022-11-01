package lk.backend.repository;

import lk.backend.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> {
    //    List<OrderData> getAllByFuelStationId(String id);
    List<PurchaseOrder> getAllByAppUserId(String supplierId);
}
