package org.jep.sample.util;

import java.util.ArrayList;
import java.util.List;

import org.jep.sample.valuebean.IValuable;

public class JepUtil {
	/** 
	 * ��ʼ��
	 */ 
  public void init(String user)  throws Exception 
	 { 
 setUser(user); 
 formulaEvaluatorMap=  new HashMap<String,JepFormulaEvaluator>(); 
 calculationOrder =  new LinkedHashSet<String>(); 
		 initCalculatorOrder(); 
	 } 
/** 
  * ��ʼ������˳�򣬵������ֶε�ѭ������ʱ���׳��쳣
  */ 
  private void initCalculatorOrder() throws Exception 
	 { 
  if (ConfigurationUtil.getMetricFormulaMap()== null 
 || ConfigurationUtil.getMetricFormulaMap().keySet().isEmpty() 
 || ConfigurationUtil.getFormulaMap(user)== null 
 || ConfigurationUtil.getFormulaMap(user).keySet().isEmpty()) 
  return ; 
		
  List<String> order =  new ArrayList<String>(); 
  for (Object fieldName:ConfigurationUtil.getMetricFormulaMap().keySet()) { 
       this.addFormulaFields((String)fieldName, order,(String)fieldName); 
  } 
     calculationOrder.addAll(order); 
} 
	 
   /** 
	 * ��ÿһ�м�¼���д����������²���
	 * a) ��ʽ����
	 * b) ������ֵ
	 * c) ����
	 * d) �洢������
	 */ 
public void processRow(IValuable valuable) throws Exception { 
 for (String fieldName : calculationOrder){ 			
  if(ConfigurationUtil.getMetricFormulaMap().keySet().contains(fieldName)){ 
 String formulaKey = (String)ConfigurationUtil.getMetricFormulaMap().get(fieldName); 
	JepFormulaEvaluator jep = formulaEvaluatorMap.get(formulaKey); 
	jep.addVariables(valuable); 
	Double result = jep.evaluate(); 
	valuable.setValue(fieldName, result); 
  } 
} 
} 

}
