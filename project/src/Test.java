
public class Test {
	public static void main(String[] args) {
//		System.out.println((int)'a');
		StringBuffer sa =new StringBuffer("A");
		StringBuffer sb = new StringBuffer("B");
		t(sa,sb);
		System.out.println(sa+"  "+sb);//��� AB  B
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

	static void  t(Integer x){//���ݵ���a �����ã������ñ����ǰ�ֵ���ݵ�
		Integer b = 20;//b�Ѿ���һ���µ�������
		x = b;
	}

	static void t(StringBuffer x,StringBuffer y){//���ݵ���a �����ã������ñ����ǰ�ֵ���ݵ�
		x.append(y); //x������û�иı䣬����ָ���ֵ�ı� ��
		y = x;		//y�����øı� �ˣ����ñ���ֵ���ݣ�����Ӱ�������
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
