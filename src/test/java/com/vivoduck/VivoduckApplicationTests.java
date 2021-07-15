package com.vivoduck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.vivoduck.dto.OrderDTO;
import com.vivoduck.dto.RemarkDTO;
import com.vivoduck.entity.Order;
import com.vivoduck.entity.Remark;
import com.vivoduck.repository.OrderRepository;

@SpringBootTest
class VivoduckApplicationTests {

	@Autowired
	private OrderRepository or;

	@Test
	void contextLoads() {
	}

	// JPA finder methods test
	@Test
	public void fetchOrdersTest() {
		// fail();
		List<Order> resultSet = or.findById(1);
		resultSet.forEach((res) -> {
			System.out.println(res);
		});
	}

	@Test
	public void resultTypeTest() {
		// fail();
		List<Order> resultSet = or.findById(1);
		String remarkType = resultSet.get(0).getRemarkType().getType();
		System.out.println(remarkType);

		assertEquals("staging", remarkType, "remark is set to Staging");
	}

	@Test
	public void findMatchingMachineInformationTest() {
		// fail();
		List<Order> resultSet = or.findByMachineInformationStartsWithIgnoreCase("C_83");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findByVivonetPOTest() {
		// fail();
		List<Order> resultSet = or.findByVivonetPOStartsWithIgnoreCase("POVAL");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findByScansourceOrderNumberTest() {
		// fail();
		List<Order> resultSet = or.findByScansourceOrderNumberStartsWith("130");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(2, resultSet.size(), "successfully found 2 record");
	}

	@Test
	public void findByScanSourcePOTest() {
		// fail();
		List<Order> resultSet = or.findByScansourcePoStartsWith(460063);
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findByTrackingNumberTest() {
		// fail();
		List<Order> resultSet = or.findByTrackingNumberStartsWithIgnoreCase("1Z");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findByTrackingNumberIsNullTest() {
		// fail();
		List<Order> resultSet = or.findByTrackingNumberIsNull();
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");

	}

	@Test
	public void checkTrackingNumberIfNull() {
		// fail();
		List<Order> resultSet = or.findByTrackingNumberIsNull();
		String trackingNumber = resultSet.get(0).getTrackingNumber();
		System.out.println(trackingNumber);

		Assertions.assertNull(trackingNumber, "Tracking should be null");
	}

	@Test
	public void findByRemarkTypetStagingOrNonStagingPOTest() {
		// fail();
		// This designed to be case-sensitive. Use Staging or Non-Staging values only
		String remarkStatus = "Staging".toLowerCase();
		List<Order> resultSet = or.findByRemarkType(remarkStatus);
		resultSet.forEach((res) -> {
			System.out.println(res);
			System.out.println(res.getRemarkType().getType());
		});

		// change the value according to your needs
		assertEquals("Staging", resultSet.get(0).getRemarkType().getType(), "Remark should be " + remarkStatus);
	}

	@Test
	public void findBySerialNumberTest() {
		// fail();
		List<Order> resultSet = or.findBySerialNumberStartsWithIgnoreCase("jn");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findByCashDrawerSerialNumberTest() {
		// fail();
		List<Order> resultSet = or.findByCashDrawerSerialNumberStartsWithIgnoreCase("gf");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(2, resultSet.size(), "successfully found 2 record");
	}

	@Test
	public void findByMacAddressTest() {
		// fail();
		List<Order> resultSet = or.findByMacAddressStartsWithIgnoreCase("c4:");
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	@Test
	public void findBySalesOrderTest() {
		// fail();
		List<Order> resultSet = or.findBySalesOrderStartsWith(521);
		resultSet.forEach((res) -> {
			System.out.println(res);
		});

		// change the size according to your needs
		assertEquals(1, resultSet.size(), "successfully found 1 record");
	}

	// create test
	@Test
	public void createOrderTest() {
		// fail();

		Remark remark = new Remark();
		remark.setType("non-Staging".toLowerCase());

		Order order = new Order();
		order.setLocation("Foundation Cafe - Kearny St");
		order.setMachineInformation("c_82994_s_173963_foundationcafe_Tennis_Club_term01");
		order.setVivonetPO("POINC002163");
		order.setScansourceOrderNumber("13057043");
		order.setScansourcePo("4600643016");
		order.setTrackingNumber(null);
		order.setRemarkType(remark);
		order.setSerialNumber("KB1700034");
		order.setCashDrawerSerialNumber("GF1703843");
		order.setMacAddress("C4:49:BB:06:3F:1B");
		order.setSalesOrder("45670");
		or.save(order);
	}

	// update test
	@Transactional
	@Rollback(value = false)
	@Test
	public void updateByIdTest() {
		// fail();

		// find the order
		List<Order> orders = or.findById(3);
		Order order = orders.get(0);

		/*
		 * transfer the order state to DTOs (this will populate the form fields in the
		 * UI)
		 */
		RemarkDTO remarkDTO = new RemarkDTO();
		remarkDTO.setType(order.getRemarkType().getType());

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setLocation(order.getLocation());
		orderDTO.setMachineInformation(order.getMachineInformation());
		orderDTO.setVivonetPO(order.getVivonetPO());
		orderDTO.setScansourceOrderNumber(order.getScansourceOrderNumber());
		orderDTO.setScansourcePo(order.getScansourcePo());
		orderDTO.setTrackingNumber(null);
		orderDTO.setRemarkType(remarkDTO);
		orderDTO.setSerialNumber(order.getSerialNumber());
		orderDTO.setCashDrawerSerialNumber(order.getCashDrawerSerialNumber());
		orderDTO.setMacAddress(order.getMacAddress());
		orderDTO.setSalesOrder(order.getSalesOrder());

		System.out.println(">>>>> CURRENT DATA: " + orderDTO);

		// update something
		orderDTO.setLocation("APUS College");
		remarkDTO.setType("Staging".toLowerCase());

		// put back the new info
		Remark remark = new Remark();
		remark.setType(remarkDTO.getType());

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

		// persist changes
		or.save(order);

	}

	// delete tests
	@Transactional
	@Rollback(value = false)
	@Test
	public void deleteByIdTest() {
		// fail();
		or.deleteById(1);
	}

	@Transactional
	@Rollback(value = false)
	@Test
	public void deleteAllTest() {
		// fail();

		/*
		 * this feature needs authorization validation in the service layer before
		 * granting access
		 */
		String response = mockValidation("admin", "password");

		if (response.equalsIgnoreCase("success")) {

			or.deleteAll();

			// resets the id PK auto increment
			or.resetIdAutoIncrement();
		} else {
			System.out.println(response);
		}

		assertEquals("success", response);
	}

	private String mockValidation(String username, String password) {
		Map<String, String> mockedCredential = new HashMap<>();
		mockedCredential.put("admin", "password");

		if (mockedCredential.containsKey(username)) {
			if (mockedCredential.containsValue(password)) {
				return "success";
			}
		}
		return "access denied";
	}

	@Test
	public void countTotalOrdersTest() {
		// fail()
		int totalOrders = or.countTotalOrders();

		assertEquals(3, totalOrders);
	}

}
