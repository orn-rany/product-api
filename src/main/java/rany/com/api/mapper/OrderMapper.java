package rany.com.api.mapper;

import org.mapstruct.*;
import rany.com.api.domain.Order;
import rany.com.api.domain.User;
import rany.com.api.feature.order.dto.*;
import rany.com.api.feature.user.dto.UserCreateRequest;
import rany.com.api.feature.user.dto.UserResponse;
import rany.com.api.feature.user.dto.UserUpdateRequest;

@Mapper(componentModel = "spring",uses = {OrderDetailMapper.class})
public interface OrderMapper {

    Order fromOrderCreateRequest(OrderCreateRequest orderCreateRequest);

    OrderResponse toOrderResponse(Order order);

    @Mapping(source = "orderDetails",target = "orderDetails",ignore = true)
    Order fromOrderWithDetailCreateRequest(OrderWithDetailCreateRequest orderWithDetailCreateRequest);

    OrderWithDetailResponse  toOrderWithDetailResponse(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromRequest(@MappingTarget Order order, OrderUpdateRequest orderUpdateRequest);

}
