package org.jep.sample.valuebean;

public interface IValuable {
	/**
	 * ͨ���ֶ����ƻ�ȡ�ֶ�ֵ
	 */
	public Double getValue(String fieldName) throws Exception;

	/**
	 * �����ֶ����ƺͼ����� 
	 */
	public void setValue(String fieldName, Double result) throws Exception;
}