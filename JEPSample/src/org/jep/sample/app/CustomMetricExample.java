package org.jep.sample.app;

import java.util.ArrayList;
import java.util.List;

import org.jep.sample.data.ProductDeal;
import org.jep.sample.user.UserAccount;
import org.jep.sample.util.ConfigurationUtil;
import org.jep.sample.util.JepUtil;
import org.jep.sample.valuebean.IValuable;
import org.jep.sample.valuebean.impl.ObjectValueBean;

public class CustomMetricExample {
	JepUtil jepUtil = new JepUtil();
	List<IValuable> valueList;

	/**
	 * 载入测试数据
	 */
	public void loadData() {
		List<IValuable> valueList = new ArrayList<IValuable>();
		ProductDeal productDeal1 = new ProductDeal();
		productDeal1.setProductId("001");
		productDeal1.setProductName("可乐");
		productDeal1.setUnitPrice(3.2);
		productDeal1.setUnitPriceOff(0.2);
		productDeal1.setUnitOperationCost(0.2);
		productDeal1.setUnitSupplierPrice(2.5);
		productDeal1.setUnitSupplierCost(2.0);
		productDeal1.setVolume(5);

		valueList.add(new ObjectValueBean(productDeal1));

		ProductDeal productDeal2 = new ProductDeal();
		productDeal2.setProductId("002");
		productDeal2.setProductName("汉堡");
		productDeal2.setUnitPrice(10.0);
		productDeal2.setUnitPriceOff(2.0);
		productDeal2.setUnitOperationCost(1.0);
		productDeal2.setUnitSupplierPrice(6.0);
		productDeal2.setUnitSupplierCost(5.0);
		productDeal2.setVolume(10);

		valueList.add(new ObjectValueBean(productDeal2));
		this.valueList = valueList;
	}

	/**
	 * 计算用户的自定义字段
	 */
	public void calculateCustomMetricForUser(String user) throws Exception {
		jepUtil.init(user);
		for (IValuable valuable : valueList) {
			jepUtil.processRow(valuable);
		}
		this.postAction(user);
	}

	/**
	 * 后处理操作 可以直接显示在 UI 上，也可以存储到数据库中，或作为中间结果供其他用途
	 */
	private void postAction(String user) {
		// Display on UI
		for (IValuable valuable : valueList) {
			ProductDeal productDeal = (ProductDeal) ((ObjectValueBean) valuable)
					.getObject();
			System.out.println(user + " " + productDeal.getProductName());
			System.out.println("customMetricA" + " ==> "
					+ ConfigurationUtil.getLabel(user, "customMetricA") + "="
					+ productDeal.getCustomMetricA());
			System.out.println("customMetricB" + " ==> "
					+ ConfigurationUtil.getLabel(user, "customMetricB") + "="
					+ productDeal.getCustomMetricB());
		}
		System.out
				.println("--------------------------------------------------");
	}

	public static void main(String[] args) throws Exception {
		CustomMetricExample customMetricExample = new CustomMetricExample();
		// 1.载入原始数据
		customMetricExample.loadData();
		// 2.载入公共配置信息（字段和公式名的映射）
		ConfigurationUtil.loadCommonConfiguration();
		// 3.载入用户配置信息（公式和标签）
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_CUSTOMER);
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_SELLER);
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_SUPPLIER);
		// 4.应用
		System.out.println("我是消费者，我关心支出和节省金额");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_CUSTOMER);
		System.out.println("我是消费者，我关心收入和利润");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_SELLER);
		System.out.println("我是供应商，我关心收入和利润");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_SUPPLIER);
	}
}
