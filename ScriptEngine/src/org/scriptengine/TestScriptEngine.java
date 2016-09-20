package org.scriptengine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestScriptEngine {
	public static void main(String[] args) {
        ScriptEngine je=new ScriptEngineManager().getEngineByName("javascript");
        try {
			System.out.println(je.eval("9+(3*(1+2)/5*10)"));
			System.out.println(je.eval("3*(1+2)/5*10"));
			System.out.println(je.eval("(1+2)/5*10"));
			System.out.println(je.eval("9+3*(1+2)"));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
