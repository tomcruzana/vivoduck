package com.vivoduck.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "product_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Nullable
	private String location;

	private String machineInformation;

	@Column(name = "vivo_po")
	private String vivonetPO;

	@Column(name = "scansource_order_number")
	private String scansourceOrderNumber;

	@Column(name = "scansource_po")
	private String scansourcePo;

	@Nullable
	private String trackingNumber;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "remark_type", referencedColumnName = "type")
	private Remark remarkType;

	private String serialNumber;

	private String cashDrawerSerialNumber;

	private String macAddress;

	@Column(name = "so")
	private String salesOrder;

	public Order() {
		// default constructor
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMachineInformation() {
		return machineInformation;
	}

	public void setMachineInformation(String machineInformation) {
		this.machineInformation = machineInformation;
	}

	public String getVivonetPO() {
		return vivonetPO;
	}

	public void setVivonetPO(String vivonetPO) {
		this.vivonetPO = vivonetPO;
	}

	public String getScansourceOrderNumber() {
		return scansourceOrderNumber;
	}

	public void setScansourceOrderNumber(String scanSourceOrderNumber) {
		this.scansourceOrderNumber = scanSourceOrderNumber;
	}

	public String getScansourcePo() {
		return scansourcePo;
	}

	public void setScansourcePo(String scansourcePo) {
		this.scansourcePo = scansourcePo;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public Remark getRemarkType() {
		return remarkType;
	}

	public void setRemarkType(Remark remarkType) {
		this.remarkType = remarkType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCashDrawerSerialNumber() {
		return cashDrawerSerialNumber;
	}

	public void setCashDrawerSerialNumber(String cashDrawerSerialNumber) {
		this.cashDrawerSerialNumber = cashDrawerSerialNumber;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", location=" + location + ", machineInformation=" + machineInformation
				+ ", vivonetPO=" + vivonetPO + ", scansourceOrderNumber=" + scansourceOrderNumber + ", scansourcePo="
				+ scansourcePo + ", trackingNumber=" + trackingNumber + ", remarkType=" + remarkType + ", serialNumber="
				+ serialNumber + ", cashDrawerSerialNumber=" + cashDrawerSerialNumber + ", macAddress=" + macAddress
				+ ", salesOrder=" + salesOrder + "]";
	}

}
