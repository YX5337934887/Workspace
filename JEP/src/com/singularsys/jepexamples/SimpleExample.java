package com.singularsys.jepexamples;

import com.singularsys.jep.Jep;

/**
 * A simple example that demonstrates the use of Jep for evaluation of a single
 * expression.
 * @author Singular Systems
 */
public class SimpleExample {
    public static void main(String[] args) {

        // Create a new Jep instance
        Jep jep = new Jep();
        // Add the variable x to the parser and initialize it's value to 10
        // Try parsing and evaluating an example expression
        try {
            // Add the variable x to the parser and initialize it's value to 10
            // Try parsing and evaluating an example expression
            jep.addVariable("x", 10);
            jep.parse("x+1");
            Object result = jep.evaluate();

            // If the evaluation succeeds, the result will be printed here
            System.out.println("x + 1 = " + result);

            jep.addVariable("总价", 10);
            jep.addVariable("税率", 1);
            String formula = null;
            long time = System.currentTimeMillis();
            for(int i=0;i<100000;i++) {
            	formula = "[总价]/(1+[税率])".replace('[', '\u0020').replace(']', '\u0020');
            }
            System.out.println(formula);
            jep.addVariable("总价", 10);
            jep.addVariable("税率", 1);
            jep.parse(formula);
            System.out.println(System.currentTimeMillis()-time);
            time = System.currentTimeMillis();
            for(int i=0;i<100000;i++) {
            	formula = "[总价]/(1+[税率])".replaceAll("\\[", "").replaceAll("\\]", "");
            }
            System.out.println(System.currentTimeMillis()-time);
            System.out.println(formula);
            jep.addVariable("总价", 10);
            jep.addVariable("税率", 1);
            jep.parse(formula);

            // If the evaluation succeeds, the result will be printed here
            System.out.println("[总价]/(1+[税率]) = " + jep.evaluate());
            int a = 1350;
            double b = 0.7;
            double c = 0.97;
            double d = 0.5;
            double f = 0.06;
            jep.addVariable("a", a);
    		jep.addVariable("b", b);
    		jep.addVariable("c", c);
    		jep.addVariable("d", d);
    		jep.addVariable("f", f);
            jep.parse("a*b*(c+d*f)");
            System.out.println("a*b*(c+d*f)="+jep.evaluate());
            System.out.println(a*b);

        } catch (Exception e) {
            // If an exception is thrown while parsing or evaluating
            // information about the error is printed here
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
