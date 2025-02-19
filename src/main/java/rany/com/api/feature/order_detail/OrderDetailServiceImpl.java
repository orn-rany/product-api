package rany.com.api.feature.order_detail;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rany.com.api.domain.Order;
import rany.com.api.domain.OrderDetail;
import rany.com.api.feature.order_detail.dto.OrderDetailCreateRequest;
import rany.com.api.feature.order_detail.dto.OrderDetailResponse;
import rany.com.api.feature.order_detail.dto.OrderDetailUpdateRequest;
import rany.com.api.mapper.OrderDetailMapper;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService{

    private final OrderDetailRepository orderDetailRepository;

    private final OrderDetailMapper orderDetailMapper;


    @Override
    public void createOrderDetail(OrderDetailCreateRequest orderDetailCreateRequest) {

        OrderDetail orderDetail = orderDetailMapper.fromOrderCreateRequest(orderDetailCreateRequest);

        orderDetailRepository.save(orderDetail);

    }

    @Override
    public OrderDetailResponse getOrderDetailById(Long id) {


        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("orderDetail = %s has not been found",id)));

        return orderDetailMapper.toOrderDetailResponse(orderDetail);
    }

    @Override
    public Page<OrderDetailResponse> getAllOrderDetails(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC,"createdDate");

        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,sort);

        Page<OrderDetail> orderDetailPage =orderDetailRepository.findAll(pageRequest);

        return orderDetailPage.map(orderDetailMapper::toOrderDetailResponse);
    }

    @Override
    public Page<OrderDetailResponse> getAllOrderDetailsByOrderId(Long orderId, int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC,"createdDate");

        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,sort);

        Page<OrderDetail> orderDetailPage =orderDetailRepository.findAllByOrderId(orderId,pageRequest);

        return orderDetailPage.map(orderDetailMapper::toOrderDetailResponse);

    }

    @Override
    public OrderDetailResponse updateOrderDetailById(Long id, OrderDetailUpdateRequest orderDetailUpdateRequest) {

        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("orderDetail = %s has not been found",id)));

        orderDetailMapper.updateOrderDetailFromRequest(orderDetail,orderDetailUpdateRequest);

        orderDetailRepository.save(orderDetail);

        return orderDetailMapper.toOrderDetailResponse(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(Long id) {

        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("orderDetail = %s has not been found",id)));

        orderDetailRepository.delete(orderDetail);
    }
}
