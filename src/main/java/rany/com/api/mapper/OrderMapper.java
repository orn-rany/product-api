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

    OrderResponse toOrderResponse(Order order,Long customerId,String customerName,Long employeeId,String employeeName);

//    @Mapping(source = "orderDetails",target = "orderDetails",ignore = true)
//    @Mapping(target = "customer", source = "customerId", ignore = true)
//    @Mapping(source = "employeeId",target = "employee",ignore = true)
    Order fromOrderWithDetailCreateRequest(OrderWithDetailCreateRequest orderWithDetailCreateRequest);

    OrderWithDetailResponse  toOrderWithDetailResponse(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromRequest(@MappingTarget Order order, OrderUpdateRequest orderUpdateRequest);

}
