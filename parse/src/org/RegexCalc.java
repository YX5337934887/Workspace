package org;

public class RegexCalc {
	public static void main(String[] args) {
		//String str = "a+a*b=c";
//		str="a*b/c";
//		String []result = str.split("[\\*\\/]");
		//String []result = str.split("[\\+\\-]");
		
		/*for(String s : result)
			System.out.println(s);
		System.out.println(Double.parseDouble("-1"));*/
//		System.out.println(calcPrice("1.5*4-7.5/2.5+2.5*2"));
		System.out.println(brackets("(1.5/(9.5-7.5)+3)/(6/2-2)"));
//		System.out.println("(1.5*(9.5-7.5)+3)*(0.0*2)".replaceFirst("\\(0.0\\*2\\)","0.0"));
//		System.out.println("(1.5*(9.5-7.5)+3)*(0.0*2)".replaceFirst("\\*", "\\\\\\\\*"));
	}

	public static Double brackets(String formula){
		while(formula.contains("(")) {
			int preIndex = formula.lastIndexOf('(') + 1;
			int sufIndex = formula.indexOf(')', preIndex);
			String preFormula = formula.substring(0, preIndex - 1);
			String sufFormula = formula.substring(sufIndex + 1);
			String subFormula = formula.substring(preIndex, sufIndex);
			String price = calcPrice(subFormula).toString();
			formula = preFormula + price + sufFormula;
			System.out.println(formula);
		}
		return calcPrice(formula);
	}
	
	public static Double calcPrice(String formula) {
		String []addOper=formula.split("\\+");//根据+号分解字符串
		for(int a=0;a<addOper.length;a++) {
			String []subOper = addOper[a].split("\\-");//根据-号分解字符串
			for(int s=0;s<subOper.length;s++) {
				String []mulOper = subOper[s].split("\\*");//根据*号分解字符串
				for(int m=0;m<mulOper.length;m++) {
					String []divOper=mulOper[m].split("\\/");//根据/号分解字符串
					//计算除法运算
					double divNum=Double.parseDouble(divOper[0].trim());
					for(int index=1;index<divOper.length;index++) {
						divNum=divNum/Double.parseDouble(divOper[index].trim());
					}
					mulOper[m]=String.valueOf(divNum);
				}
				//计算乘法
				double mulNum=Double.parseDouble(mulOper[0].trim());
				for(int index=1;index<mulOper.length;index++) {
					mulNum*=Double.parseDouble(mulOper[index].trim());
				}
				subOper[s]=String.valueOf(mulNum);
			}
			//计算减法
			double subNum=Double.parseDouble(subOper[0].trim());
			for(int index=1;index<subOper.length;index++) {
				subNum-=Double.parseDouble(subOper[index].trim());
			}
			addOper[a]=String.valueOf(subNum);
		}
		//计算加法
		double addNum=Double.parseDouble(addOper[0]);
		for(int index=1;index<addOper.length;index++) {
			addNum+=Double.parseDouble(addOper[index].trim());
		}
		return addNum;
	}
}
