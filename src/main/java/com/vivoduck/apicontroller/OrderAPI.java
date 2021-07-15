package com.vivoduck.apicontroller;

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
	@GetMapping(value = "/order/{id}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable int id) throws Exception {
		OrderDTO order = orderService.readOrderById(id);
		return new ResponseEntity<>(order, HttpStatus.OK);
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
