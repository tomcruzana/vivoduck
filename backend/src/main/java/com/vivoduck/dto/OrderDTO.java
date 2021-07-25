package com.vivoduck.dto;

public class OrderDTO {

	private int id;

	private String location;

	private String machineInformation;

	private String vivonetPO;

	private String scansourceOrderNumber;

	private String scansourcePo;

	private String trackingNumber;

	private RemarkDTO remarkType;

	private String serialNumber;

	private String cashDrawerSerialNumber;

	private String macAddress;

	private String salesOrder;

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

	public void setScansourceOrderNumber(String scansourceOrderNumber) {
		this.scansourceOrderNumber = scansourceOrderNumber;
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

	public RemarkDTO getRemarkType() {
		return remarkType;
	}

	public void setRemarkType(RemarkDTO remarkType) {
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
	public String toString() {
		return "OrderDTO [id=" + id + ", location=" + location + ", machineInformation=" + machineInformation
				+ ", vivonetPO=" + vivonetPO + ", scansourceOrderNumber=" + scansourceOrderNumber + ", scansourcePo="
				+ scansourcePo + ", trackingNumber=" + trackingNumber + ", remarkType=" + remarkType + ", serialNumber="
				+ serialNumber + ", cashDrawerSerialNumber=" + cashDrawerSerialNumber + ", macAddress=" + macAddress
				+ ", salesOrder=" + salesOrder + "]";
	}

}
