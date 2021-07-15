package com.vivoduck.repository;

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

	Optional<Order> findByLocationStartsWithIgnoreCase(String location);

	Optional<Order> findByMachineInformationStartsWithIgnoreCase(String machineInformation);

	Optional<Order> findByVivonetPOStartsWithIgnoreCase(String vivonetPO);

	Optional<Order> findByScansourceOrderNumberStartsWith(String ScansourceOrderNumber);

	Optional<Order> findByScansourcePoStartsWith(Integer scanSourcePO);

	Optional<Order> findByTrackingNumberStartsWithIgnoreCase(String trackingNumber);

	// TODO: we might not use this
	Optional<Order> findByTrackingNumberIsNull();

	@Query(value = "SELECT * FROM product_order WHERE remark_type = :remarkType", nativeQuery = true)
	Optional<Order> findByRemarkType(@Param("remarkType") String remarkType);

	Optional<Order> findBySerialNumberStartsWithIgnoreCase(String serialNumber);

	Optional<Order> findByCashDrawerSerialNumberStartsWithIgnoreCase(String cashDrawerSerialNumber);

	Optional<Order> findByMacAddressStartsWithIgnoreCase(String macAddress);

	Optional<Order> findBySalesOrderStartsWith(Integer salesOrder);

	// update
	/* use the read methods and save() method to persist data */

	// delete
	@Modifying
	void deleteAll();

	@Modifying
	void deleteById(int id);
}
