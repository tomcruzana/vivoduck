package com.vivoduck.service;

import org.springframework.transaction.annotation.Transactional;

import com.vivoduck.dto.OrderDTO;
import com.vivoduck.dto.RemarkDTO;
import com.vivoduck.entity.Order;
import com.vivoduck.entity.Remark;
import com.vivoduck.exception.VivoduckException;
import com.vivoduck.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private Environment environment;

	// create
	@Override
	public void createOrder(OrderDTO orderDTO) throws VivoduckException {
		populateOrderEntityAndSave(orderDTO);
	}

	// read
	@Override
	public OrderDTO readOrderById(int id) throws VivoduckException {
		Optional<Order> orderOptional = orderRepository.findById(id);
		Order order = orderOptional
				.orElseThrow(() -> new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND")));

		return populateOrderDTO(order);
	}

	@Override
	public List<OrderDTO> readOrderByLocation(String location) throws VivoduckException {
		List<Order> orders = orderRepository.findByLocationStartsWithIgnoreCase(location);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByMachineInformation(String machineInformation) throws VivoduckException {
		List<Order> orders = orderRepository.findByMachineInformationStartsWithIgnoreCase(machineInformation);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByVivonetPo(String vivonetPo) throws VivoduckException {
		List<Order> orders = orderRepository.findByVivonetPOStartsWithIgnoreCase(vivonetPo);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByScansourceOrderNumber(String scansourceOrderNumber) throws VivoduckException {
		List<Order> orders = orderRepository.findByScansourceOrderNumberStartsWith(scansourceOrderNumber);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByScansourcePo(String scansourcePo) throws VivoduckException, NumberFormatException {

		Integer scansourcePo_int;
		try {
			scansourcePo_int = Integer.parseInt(scansourcePo);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Order.INPUT_A_NUMBER");
		}

		List<Order> orders = orderRepository.findByScansourcePoStartsWith(scansourcePo_int);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);

	}

	@Override
	public List<OrderDTO> readOrderByTrackingNumber(String trackingNumber) throws VivoduckException {
		List<Order> orders = orderRepository.findByTrackingNumberStartsWithIgnoreCase(trackingNumber);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByRemarkType(String remarkType) throws VivoduckException {
		List<Order> orders = orderRepository.findByRemarkType(remarkType);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderBySerialNumber(String serialNumber) throws VivoduckException {
		List<Order> orders = orderRepository.findBySerialNumberStartsWithIgnoreCase(serialNumber);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByCashDrawerSerialNumber(String cashDrawerSerialNumber) throws VivoduckException {
		List<Order> orders = orderRepository.findByCashDrawerSerialNumberStartsWithIgnoreCase(cashDrawerSerialNumber);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderByMacAddress(String macAddress) throws VivoduckException {
		List<Order> orders = orderRepository.findByMacAddressStartsWithIgnoreCase(macAddress);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	@Override
	public List<OrderDTO> readOrderBySalesOrder(String salesOrder) throws VivoduckException {
		Integer salesOrder_int;
		try {
			salesOrder_int = Integer.parseInt(salesOrder);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Order.INPUT_A_NUMBER");
		}
		List<Order> orders = orderRepository.findBySalesOrderStartsWith(salesOrder_int);
		if (orders.isEmpty()) {
			throw new VivoduckException(environment.getProperty("Order.ORDER_NOT_FOUND"));
		}
		return populateOrderDTO(orders);
	}

	// update
	// note: user can't update without fetching an order first
	// once an existing order is fetched in the ui, it will populate the text fields
	// with existing info
	@Override
	public void updateOrder(int id, String location, String machineInformation, String vivoPo,
			String scansourceOrderNumber, String scansourcePo, String trackingNumber, String remarkType,
			String serialNumber, String cashDrawerSerialNumber, String macAddress, String so) throws VivoduckException {

		Optional<Order> orderOptional = orderRepository.findById(id);
		orderOptional.orElseThrow(() -> new VivoduckException("Order.ORDER_NOT_FOUND"));

		Order order = orderOptional.get();

		// update fields
		Remark remark = new Remark();
		remark.setType(remarkType);

		order.setLocation(location);
		order.setMachineInformation(machineInformation);
		order.setVivonetPO(vivoPo);
		order.setScansourceOrderNumber(scansourceOrderNumber);
		order.setScansourcePo(scansourcePo);
		order.setTrackingNumber(trackingNumber);
		order.setRemarkType(remark);
		order.setSerialNumber(serialNumber);
		order.setCashDrawerSerialNumber(cashDrawerSerialNumber);
		order.setMacAddress(macAddress);
		order.setSalesOrder(so);

		orderRepository.save(order);

	}

	// delete
	@Override
	public void deleteOrder(int id) throws VivoduckException {
		Optional<Order> orderOptional = orderRepository.findById(id);
		orderOptional.orElseThrow(() -> new VivoduckException("Order.ORDER_NOT_FOUND"));
		orderRepository.deleteById(id);
	}

	@Override
	public void deleteAllOrders() throws VivoduckException {
		// TODO Auto-generated method stub

	}

	// convenience methods
	// transfer entity to dto
	private OrderDTO populateOrderDTO(Order order) {
		RemarkDTO remarkDTO = new RemarkDTO();
		remarkDTO.setType(order.getRemarkType().getType());

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setLocation(order.getLocation());
		orderDTO.setMachineInformation(order.getMachineInformation());
		orderDTO.setVivonetPO(order.getVivonetPO());
		orderDTO.setScansourceOrderNumber(order.getScansourceOrderNumber());
		orderDTO.setScansourcePo(order.getScansourcePo());
		orderDTO.setTrackingNumber(order.getTrackingNumber());
		orderDTO.setRemarkType(remarkDTO);
		orderDTO.setSerialNumber(order.getSerialNumber());
		orderDTO.setCashDrawerSerialNumber(order.getCashDrawerSerialNumber());
		orderDTO.setMacAddress(order.getMacAddress());
		orderDTO.setSalesOrder(order.getSalesOrder());

		return orderDTO;
	}

	private List<OrderDTO> populateOrderDTO(List<Order> orders) {
		List<OrderDTO> orderDTOList = new ArrayList<>();

		orders.forEach((order) -> {
			RemarkDTO remarkDTO = new RemarkDTO();
			remarkDTO.setType(order.getRemarkType().getType());

			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setLocation(order.getLocation());
			orderDTO.setMachineInformation(order.getMachineInformation());
			orderDTO.setVivonetPO(order.getVivonetPO());
			orderDTO.setScansourceOrderNumber(order.getScansourceOrderNumber());
			orderDTO.setScansourcePo(order.getScansourcePo());
			orderDTO.setTrackingNumber(order.getTrackingNumber());
			orderDTO.setRemarkType(remarkDTO);
			orderDTO.setSerialNumber(order.getSerialNumber());
			orderDTO.setCashDrawerSerialNumber(order.getCashDrawerSerialNumber());
			orderDTO.setMacAddress(order.getMacAddress());
			orderDTO.setSalesOrder(order.getSalesOrder());

			orderDTOList.add(orderDTO);
		});

		return orderDTOList;
	}

	// transfer dto to entity
	private void populateOrderEntityAndSave(OrderDTO orderDTO) {
		Remark remark = new Remark();
		remark.setType(orderDTO.getRemarkType().getType());

		Order order = new Order();
		order.setLocation(orderDTO.getLocation());
		order.setMachineInformation(orderDTO.getMachineInformation());
		order.setVivonetPO(orderDTO.getVivonetPO());
		order.setScansourceOrderNumber(orderDTO.getScansourceOrderNumber());
		order.setScansourcePo(orderDTO.getScansourcePo());
		order.setTrackingNumber(orderDTO.getTrackingNumber());
		order.setRemarkType(remark);
		order.setSerialNumber(orderDTO.getSerialNumber());
		order.setCashDrawerSerialNumber(orderDTO.getCashDrawerSerialNumber());
		order.setMacAddress(orderDTO.getMacAddress());
		order.setSalesOrder(orderDTO.getSalesOrder());

		// persist updated info
		orderRepository.save(order);
	}

}
