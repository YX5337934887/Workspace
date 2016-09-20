
public class Test {
	public static void main(String[] args) {
//		System.out.println((int)'a');
		StringBuffer sa =new StringBuffer("A");
		StringBuffer sb = new StringBuffer("B");
		t(sa,sb);
		System.out.println(sa+"  "+sb);//输出 AB  B
		String a="A";
		String b="B";
		s(a,b);
		System.out.println(a+"\t"+b);
		int[] i={1,2,3};
		int[] j={4,5,6};
		System.out.println(i+","+j);
		i(i,j);
		for(int m:i){
			System.out.print(m+"\t");
		}
	}

	static void  t(Integer x){//传递的是a 的引用，但引用本身是按值传递的
		Integer b = 20;//b已经是一个新的引用了
		x = b;
	}

	static void t(StringBuffer x,StringBuffer y){//传递的是a 的引用，但引用本身是按值传递的
		x.append(y); //x的引用没有改变，但其指向的值改变 了
		y = x;		//y的引用改变 了，引用本身按值传递，不会影响调用者
	}

	static void s(String a,String b){
		a.concat(b);
	}
	public static void m(Integer i){
		System.out.println(i.intValue());
		i=new Integer(10);
		System.out.println(i.intValue());
	}
	static void i(int[] i,int[] j){
		i[0]=-1;
		i=new int[]{7,8,9};
		j(i,j);
		for(int m:i){
			System.out.print(m+"\t");
		}
		System.out.println(i+","+j);
	}
	static void j(int[] i,int[] j){
		i[0]=100;
		i=new int[]{10,11,12};
		System.out.println(i+","+j);
	}
}
