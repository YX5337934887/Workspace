package org.jep.sample.util;

import org.jep.sample.valuebean.IValuable;

import com.singularsys.jep.EvaluationException;

public class JepFormulaEvaluator {
	private String formula;
	private Double result;
	
	/** 构造函数 */ 
	public JepFormulaEvaluator(String formula){ 
	   this.formula = formula; 
	} 

	/** 
	 * 解析公式表达式
	 */ 
	public boolean parse()  throws ParseException { 
	     if (formula ==  null ) { 
	       return false ; 
	     } 
	    node = jep.parse(formula); 
	    return true ; 
	} 

	/** 
	 * 变量赋值
	 */ 
	public void addVariables(IValuable valuable)  throws Exception{ 
	      Set<String> children =  this .findChildren(); 
	      for (String child : children) {
	          jep.addVariable(child, valuable.getValue(child)); 
	      }
	}

	/** 
	 * 计算结果
	 */ 
	public Double evaluate()  throws EvaluationException { 
	   result = (Double)jep.evaluate();
	   return result;
	}
}
