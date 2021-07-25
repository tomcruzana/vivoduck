package com.vivoduck.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.vivoduck.entity.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
	/* UTILS */
	// reset pk id auto-increment
	@Modifying
	@Query(value = "ALTER TABLE product_order AUTO_INCREMENT = 1", nativeQuery = true)
	void resetIdAutoIncrement();

	// count all orders
	@Query(value = "SELECT COUNT(*) FROM product_order", nativeQuery = true)
	int countTotalOrders();

	// create
	/* use the built-in JPA save() method to persist data */

	// read
	Optional<Order> findById(int id);

	List<Order> findByLocationStartsWithIgnoreCase(String location);

	List<Order> findByMachineInformationStartsWithIgnoreCase(String machineInformation);

	List<Order> findByVivonetPOStartsWithIgnoreCase(String vivonetPO);

	List<Order> findByScansourceOrderNumberStartsWith(String ScansourceOrderNumber);

	List<Order> findByScansourcePoStartsWith(Integer scanSourcePO);

	List<Order> findByTrackingNumberStartsWithIgnoreCase(String trackingNumber);

	@Query(value = "SELECT * FROM product_order WHERE remark_type = :remarkType", nativeQuery = true)
	List<Order> findByRemarkType(@Param("remarkType") String remarkType);

	List<Order> findBySerialNumberStartsWithIgnoreCase(String serialNumber);

	List<Order> findByCashDrawerSerialNumberStartsWithIgnoreCase(String cashDrawerSerialNumber);

	List<Order> findByMacAddressStartsWithIgnoreCase(String macAddress);

	List<Order> findBySalesOrderStartsWith(Integer salesOrder);

	// update
	/* use the read methods and save() method to persist data */

	// delete
	@Modifying
	void deleteAll();

	@Modifying
	void deleteById(int id);
}
