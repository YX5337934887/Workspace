package org.jep.sample.data;

public class ProductDeal {
	/** ��ʶ */
	private String productId;
	/** ���� */
	private String productName;
	/** �ۼ� */
	private Double unitPrice;
	/** ��λ���� */
	private Double unitPriceOff;
	/** ���� */
	private Integer volume;
	/** �̼Ҿ�Ӫ�ɱ� */
	private Double unitOperationCost;
	/** ��Ӧ�̼۸� */
	private Double unitSupplierPrice;
	/** ��Ӧ�̳ɱ� */
	private Double unitSupplierCost;
	/** �Զ����ֶ� A */
	private Double customMetricA;
	/** �Զ����ֶ� B */
	private Double customMetricB;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getUnitPriceOff() {
		return unitPriceOff;
	}
	public void setUnitPriceOff(Double unitPriceOff) {
		this.unitPriceOff = unitPriceOff;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Double getUnitOperationCost() {
		return unitOperationCost;
	}
	public void setUnitOperationCost(Double unitOperationCost) {
		this.unitOperationCost = unitOperationCost;
	}
	public Double getUnitSupplierPrice() {
		return unitSupplierPrice;
	}
	public void setUnitSupplierPrice(Double unitSupplierPrice) {
		this.unitSupplierPrice = unitSupplierPrice;
	}
	public Double getUnitSupplierCost() {
		return unitSupplierCost;
	}
	public void setUnitSupplierCost(Double unitSupplierCost) {
		this.unitSupplierCost = unitSupplierCost;
	}
	public Double getCustomMetricA() {
		return customMetricA;
	}
	public void setCustomMetricA(Double customMetricA) {
		this.customMetricA = customMetricA;
	}
	public Double getCustomMetricB() {
		return customMetricB;
	}
	public void setCustomMetricB(Double customMetricB) {
		this.customMetricB = customMetricB;
	}
}