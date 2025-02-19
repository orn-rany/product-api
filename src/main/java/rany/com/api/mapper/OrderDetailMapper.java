package rany.com.api.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import rany.com.api.domain.Order;
import rany.com.api.domain.OrderDetail;
import rany.com.api.feature.order.dto.OrderCreateRequest;
import rany.com.api.feature.order.dto.OrderResponse;
import rany.com.api.feature.order.dto.OrderUpdateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailResponse;
import rany.com.api.feature.order_detail.dto.OrderDetailUpdateRequest;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetail fromOrderCreateRequest(OrderDetailCreateRequest orderDetailCreateRequest);

    OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderDetailFromRequest(@MappingTarget OrderDetail orderDetail, OrderDetailUpdateRequest orderDetailUpdateRequest);

}
