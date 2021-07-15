package com.vivoduck.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vivoduck.dto.OrderDTO;
import com.vivoduck.service.OrderService;

@RestController
@RequestMapping(value = "/vivoduck")
public class OrderAPI {

	@Autowired
	private OrderService orderService;

	@Autowired
	private Environment environment;

	// post mapping
	@PostMapping(value = "/order")
	public ResponseEntity<String> addCustomer(@RequestBody OrderDTO customerDTO) throws Exception {
		orderService.createOrder(customerDTO);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	// get mappings
	@GetMapping(value = "/order/count")
	public ResponseEntity<String> getTotalOrders() throws Exception {
		Integer countTotalOrders = orderService.countTotalOrders();
		return new ResponseEntity<>(String.valueOf(countTotalOrders), HttpStatus.OK);
	}
	
	@GetMapping(value = "/order/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable int id) throws Exception {
		OrderDTO order = orderService.readOrderById(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping(value = "/order/location")
	public ResponseEntity<List<OrderDTO>> getOrderByLocation(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByLocation(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/machineinformation")
	public ResponseEntity<List<OrderDTO>> getOrderByMachineInformation(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByMachineInformation(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/vivonetpo")
	public ResponseEntity<List<OrderDTO>> getOrderByVivonetPo(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByVivonetPo(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/scansourceordernumber")
	public ResponseEntity<List<OrderDTO>> getOrderByScansourceOrderNumber(@RequestParam String search)
			throws Exception {
		List<OrderDTO> orders = orderService.readOrderByScansourceOrderNumber(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// TODO: fix bug. query fails if digit is more than 8, ex: 460063857
	@GetMapping(value = "/order/scansourcepo")
	public ResponseEntity<List<OrderDTO>> getOrderByScansourcePo(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByScansourcePo(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/trackingnumber")
	public ResponseEntity<List<OrderDTO>> getOrderByTrackingNumber(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByTrackingNumber(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/remark")
	public ResponseEntity<List<OrderDTO>> getOrderByRemarkType(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByRemarkType(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/serialnumber")
	public ResponseEntity<List<OrderDTO>> getOrderBySerialNumber(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderBySerialNumber(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/cashdrawerserialnumber")
	public ResponseEntity<List<OrderDTO>> getOrderByCashDrawerSerialNumber(@RequestParam String search)
			throws Exception {
		List<OrderDTO> orders = orderService.readOrderByCashDrawerSerialNumber(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/macaddress")
	public ResponseEntity<List<OrderDTO>> getOrderByMacAddress(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderByMacAddress(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/order/salesorder")
	public ResponseEntity<List<OrderDTO>> getOrderBySalesOrder(@RequestParam String search) throws Exception {
		List<OrderDTO> orders = orderService.readOrderBySalesOrder(search);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// patch mapping
	@PatchMapping(value = "/order/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable Integer id, @RequestParam String location,
			@RequestParam String machineInformation, @RequestParam String vivoPo,
			@RequestParam String scansourceOrderNumber, @RequestParam String scansourcePo,
			@RequestParam String trackingNumber, @RequestParam String remarkType, @RequestParam String serialNumber,
			@RequestParam String cashDrawerSerialNumber, @RequestParam String macAddress, @RequestParam String so)
			throws Exception {

		orderService.updateOrder(id, location, machineInformation, vivoPo, scansourceOrderNumber, scansourcePo,
				trackingNumber, remarkType, serialNumber, cashDrawerSerialNumber, macAddress, so);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	// delete mappings
	@DeleteMapping(value = "/order/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws Exception {
		orderService.deleteOrder(id);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}
