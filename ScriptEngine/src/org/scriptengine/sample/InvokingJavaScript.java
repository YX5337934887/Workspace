package org.scriptengine.sample;

import java.io.File;
import java.io.FileReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class InvokingJavaScript {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		String fileName = "src/demo.js";
		File file = new File(fileName);
		FileReader reader = new FileReader(file.getAbsolutePath().replaceAll("\\\\", "/"));
		engine.eval(reader);
		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine;
			Double sum = (Double) invoke.invokeFunction("addFun", 2, 3);
			System.out.println(sum);
		}
		reader.close();
	}
}