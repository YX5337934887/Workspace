package org.jep.sample.valuebean.impl;

import java.util.HashMap;
import java.util.Map;

import org.jep.sample.valuebean.IValuable;

public class ObjectValueBean implements IValuable {
	public Object object;
	public Map<String, Double> resultMap = new HashMap<String, Double>();

	public ObjectValueBean(Object object) {
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public Double getValue(String fieldName) throws Exception {
		if (resultMap.containsKey(fieldName))
			return resultMap.get(fieldName);
		else
			return new Double(BeanUtils.getProperty(object, fieldName));
	}

	@Override
	public void setValue(String fieldName, Double result) throws Exception {
		BeanUtils.setProperty(object, fieldName, result);
		resultMap.put(fieldName, result);
	}
}