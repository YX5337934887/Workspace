package classloader;

import java.util.LinkedList;
import java.util.List;

public class Hot {
	private static List<Hot> list = new LinkedList<Hot>();

	public Hot() {
		list.add(this);
	}

	public String toString() {
		String str ="version 1 : " + this.getClass().getClassLoader();
		System.out.println(str);
		return str;		
	}
	
	public boolean equals(Hot hot){
		return this.getClass().getClassLoader().equals(hot.getClass().getClassLoader());
	}
	
}
