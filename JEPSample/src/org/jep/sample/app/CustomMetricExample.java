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
	 * �����������
	 */
	public void loadData() {
		List<IValuable> valueList = new ArrayList<IValuable>();
		ProductDeal productDeal1 = new ProductDeal();
		productDeal1.setProductId("001");
		productDeal1.setProductName("����");
		productDeal1.setUnitPrice(3.2);
		productDeal1.setUnitPriceOff(0.2);
		productDeal1.setUnitOperationCost(0.2);
		productDeal1.setUnitSupplierPrice(2.5);
		productDeal1.setUnitSupplierCost(2.0);
		productDeal1.setVolume(5);

		valueList.add(new ObjectValueBean(productDeal1));

		ProductDeal productDeal2 = new ProductDeal();
		productDeal2.setProductId("002");
		productDeal2.setProductName("����");
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
	 * �����û����Զ����ֶ�
	 */
	public void calculateCustomMetricForUser(String user) throws Exception {
		jepUtil.init(user);
		for (IValuable valuable : valueList) {
			jepUtil.processRow(valuable);
		}
		this.postAction(user);
	}

	/**
	 * ������� ����ֱ����ʾ�� UI �ϣ�Ҳ���Դ洢�����ݿ��У�����Ϊ�м�����������;
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
		// 1.����ԭʼ����
		customMetricExample.loadData();
		// 2.���빫��������Ϣ���ֶκ͹�ʽ����ӳ�䣩
		ConfigurationUtil.loadCommonConfiguration();
		// 3.�����û�������Ϣ����ʽ�ͱ�ǩ��
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_CUSTOMER);
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_SELLER);
		ConfigurationUtil.loadUserConfiguration(UserAccount.USER_SUPPLIER);
		// 4.Ӧ��
		System.out.println("���������ߣ��ҹ���֧���ͽ�ʡ���");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_CUSTOMER);
		System.out.println("���������ߣ��ҹ������������");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_SELLER);
		System.out.println("���ǹ�Ӧ�̣��ҹ������������");
		customMetricExample
				.calculateCustomMetricForUser(UserAccount.USER_SUPPLIER);
	}
}
