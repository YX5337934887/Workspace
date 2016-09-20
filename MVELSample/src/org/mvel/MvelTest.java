package org.mvel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class MvelTest {
	public static void main(String[] args) {
		String expression = "foobar > 99";

		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("foobar", new Integer(100));

		// We know this expression should return a boolean.
		Boolean result = (Boolean) MVEL.eval(expression, vars);

		if (result.booleanValue()) {
			System.out.println("It works!");
		}

		System.err.println(1350 * 0.7 * (0.97 + 0.5 * 0.06));

		String exp3 = "a*b*(c+d*e)";
		Map<String, Object> map = new HashMap<String, Object>();

		// map.put("a", 1350d);[Ô­¼Û]
		map.put("a", 1350);
		map.put("b", 0.7);
		map.put("c", 0.97);
		map.put("d", 0.5);
		map.put("e", 0.06);
		Serializable exp4 = MVEL.compileExpression(exp3);
		System.err.println(MVEL.executeExpression(exp4, map, Double.class));
		
	}
}
