package org.jep.sample.data;

public class ProductDeal {
	/** 标识 */
	private String productId;
	/** 名称 */
	private String productName;
	/** 售价 */
	private Double unitPrice;
	/** 单位减价 */
	private Double unitPriceOff;
	/** 销量 */
	private Integer volume;
	/** 商家经营成本 */
	private Double unitOperationCost;
	/** 供应商价格 */
	private Double unitSupplierPrice;
	/** 供应商成本 */
	private Double unitSupplierCost;
	/** 自定义字段 A */
	private Double customMetricA;
	/** 自定义字段 B */
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