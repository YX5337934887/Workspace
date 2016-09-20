import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] randomArray=new int[5];
		Random random=new Random();
		for(int i=0;i<randomArray.length;i++){
			randomArray[i]=random.nextInt(100);
		}
		System.out.println("randomArray:");
		for(int i:randomArray)
			System.out.print(i+" ");
		System.out.println();
		SelectSort s=new SelectSort();
		int[] sortedArray;
		System.out.println("selectSort1:");
		sortedArray = s.selectSort1(randomArray);
		for(int i:sortedArray)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("selectSort2:");
		sortedArray=s.selectSort2(randomArray);
		for(int i:sortedArray)
			System.out.print(i+" ");
	}
}

class SelectSort{
	public int[] selectSort1(int[] toSortArray){
		int[] sortedArray=toSortArray.clone();
		for(int i=0;i<toSortArray.length-1;i++){
			for(int j=i+1;j<toSortArray.length;j++){
//				���ҳ���С�������͵�ǰ������
				if(sortedArray[i]>sortedArray[j]){
					int temp=sortedArray[i];
					sortedArray[i]=sortedArray[j];
					sortedArray[j]=temp;
				}
			}
		}
		return sortedArray;
	}
	
	public int[] selectSort2(int[] toSortArray){
		int[] sortedArray=toSortArray.clone();
		for(int i=0;i<toSortArray.length-1;i++){
			//��ȡ��ǰ��֪����С��
			int minInt=sortedArray[i];
			int minIndex=i;
//			��ȡ��С��������
			for(int j=i+1;j<toSortArray.length;j++) {
				if(minInt>sortedArray[j]) {
					minInt=sortedArray[j];
					minIndex=j;
				}
			}
			//����С�����뵱ǰ������
			if(minIndex!=i){
				sortedArray[minIndex]=sortedArray[i];
				sortedArray[i]=minInt;
			}
		}
		return sortedArray;
	}
}