package com.vivoduck.service;

import com.vivoduck.dto.OrderDTO;
import com.vivoduck.exception.VivoduckException;

public interface OrderService {

	// create
	public void createOrder(OrderDTO orderDTO) throws VivoduckException;

	// read
	public OrderDTO readOrderById(int id) throws VivoduckException;

	public OrderDTO readOrderByLocation(String location) throws VivoduckException;

	public OrderDTO readOrderByMachineInformation(String machineInformation) throws VivoduckException;

	public OrderDTO readOrderByVivonetPo(String vivonetPo) throws VivoduckException;

	public OrderDTO readOrderByScansourceOrderNumber(String scansourceOrderNumber) throws VivoduckException;

	public OrderDTO readOrderByScansourcePo(String scansourcePo) throws VivoduckException;

	// TODO : must include findByTrackingNumberIsNull in logic
	public OrderDTO readOrderByTrackingNumber(String trackingNumber) throws VivoduckException;

	public OrderDTO readOrderByRemarkType(String remarkType) throws VivoduckException;

	public OrderDTO readOrderBySerialNumber(String serialNumber) throws VivoduckException;

	public OrderDTO readOrderByCashDrawerSerialNumber(String cashDrawerSerialNumber) throws VivoduckException;

	public OrderDTO readOrderByMacAddress(String macAddress) throws VivoduckException;

	public OrderDTO readOrderBySalesOrder(String salesOrder) throws VivoduckException;

	// update
	public void updateOrder(int id, String location, String machineInformation, String vivoPo,
			String scansourceOrderNumber, String scansourcePo, String trackingNumber, String remarkType,
			String serialNumber, String cashDrawerSerialNumber, String macAddress, String so) throws VivoduckException;

	// delete
	public void deleteOrder(int id) throws VivoduckException;

	public void deleteAllOrders() throws VivoduckException;
}
