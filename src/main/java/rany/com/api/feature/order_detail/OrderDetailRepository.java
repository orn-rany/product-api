package rany.com.api.feature.order_detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {

    Page<OrderDetail> findAllByOrderId(Long id, Pageable pageable);
}
