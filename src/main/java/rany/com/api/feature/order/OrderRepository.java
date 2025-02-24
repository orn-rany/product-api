package rany.com.api.feature.order;

import org.springframework.data.jpa.repository.JpaRepository;
import rany.com.api.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
