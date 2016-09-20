package org.jep.sample.util;

import org.jep.sample.valuebean.IValuable;

import com.singularsys.jep.EvaluationException;

public class JepFormulaEvaluator {
	private String formula;
	private Double result;
	
	/** ���캯�� */ 
	public JepFormulaEvaluator(String formula){ 
	   this.formula = formula; 
	} 

	/** 
	 * ������ʽ���ʽ
	 */ 
	public boolean parse()  throws ParseException { 
	     if (formula ==  null ) { 
	       return false ; 
	     } 
	    node = jep.parse(formula); 
	    return true ; 
	} 

	/** 
	 * ������ֵ
	 */ 
	public void addVariables(IValuable valuable)  throws Exception{ 
	      Set<String> children =  this .findChildren(); 
	      for (String child : children) {
	          jep.addVariable(child, valuable.getValue(child)); 
	      }
	}

	/** 
	 * ������
	 */ 
	public Double evaluate()  throws EvaluationException { 
	   result = (Double)jep.evaluate();
	   return result;
	}
}
