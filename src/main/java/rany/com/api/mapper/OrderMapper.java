package rany.com.api.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import rany.com.api.domain.Order;
import rany.com.api.domain.User;
import rany.com.api.feature.order.dto.OrderCreateRequest;
import rany.com.api.feature.order.dto.OrderResponse;
import rany.com.api.feature.order.dto.OrderUpdateRequest;
import rany.com.api.feature.order.dto.OrderWithDetailResponse;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

@Mapper(componentModel = "spring",uses = {OrderDetailMapper.class})
public interface OrderMapper {

    Order fromOrderCreateRequest(OrderCreateRequest orderCreateRequest);

    OrderResponse toOrderResponse(Order order);

    OrderWithDetailResponse  toOrderWithDetailResponse(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromRequest(@MappingTarget Order order, OrderUpdateRequest orderUpdateRequest);

}
