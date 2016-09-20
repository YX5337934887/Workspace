package org.jep.sample.util;

import java.util.ArrayList;
import java.util.List;

import org.jep.sample.valuebean.IValuable;

public class JepUtil {
	/** 
	 * 初始化
	 */ 
  public void init(String user)  throws Exception 
	 { 
 setUser(user); 
 formulaEvaluatorMap=  new HashMap<String,JepFormulaEvaluator>(); 
 calculationOrder =  new LinkedHashSet<String>(); 
		 initCalculatorOrder(); 
	 } 
/** 
  * 初始化计算顺序，当存在字段的循环引用时会抛出异常
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
	 * 对每一行记录进行处理，包括如下步骤
	 * a) 公式解析
	 * b) 变量赋值
	 * c) 计算
	 * d) 存储计算结果
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
