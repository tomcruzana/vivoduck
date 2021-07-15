package com.vivoduck.service;

import java.util.List;

import com.vivoduck.dto.OrderDTO;
import com.vivoduck.exception.VivoduckException;

public interface OrderService {

	// create
	public void createOrder(OrderDTO orderDTO) throws VivoduckException;

	// read
	public OrderDTO readOrderById(int id) throws VivoduckException;

	public List<OrderDTO> readOrderByLocation(String location) throws VivoduckException;

	public List<OrderDTO> readOrderByMachineInformation(String machineInformation) throws VivoduckException;

	public List<OrderDTO> readOrderByVivonetPo(String vivonetPo) throws VivoduckException;

	public List<OrderDTO> readOrderByScansourceOrderNumber(String scansourceOrderNumber) throws VivoduckException;

	public List<OrderDTO> readOrderByScansourcePo(String scansourcePo) throws VivoduckException;

	public List<OrderDTO> readOrderByTrackingNumber(String trackingNumber) throws VivoduckException;

	public List<OrderDTO> readOrderByRemarkType(String remarkType) throws VivoduckException;

	public List<OrderDTO> readOrderBySerialNumber(String serialNumber) throws VivoduckException;

	public List<OrderDTO> readOrderByCashDrawerSerialNumber(String cashDrawerSerialNumber) throws VivoduckException;

	public List<OrderDTO> readOrderByMacAddress(String macAddress) throws VivoduckException;

	public List<OrderDTO> readOrderBySalesOrder(String salesOrder) throws VivoduckException;

	// update
	public void updateOrder(int id, String location, String machineInformation, String vivoPo,
			String scansourceOrderNumber, String scansourcePo, String trackingNumber, String remarkType,
			String serialNumber, String cashDrawerSerialNumber, String macAddress, String so) throws VivoduckException;

	// delete
	public void deleteOrder(int id) throws VivoduckException;

	public void deleteAllOrders() throws VivoduckException;
}
