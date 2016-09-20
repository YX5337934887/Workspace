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
//				查找出最小的数并和当前数交换
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
			//获取当前已知的最小数
			int minInt=sortedArray[i];
			int minIndex=i;
//			获取最小数的索引
			for(int j=i+1;j<toSortArray.length;j++) {
				if(minInt>sortedArray[j]) {
					minInt=sortedArray[j];
					minIndex=j;
				}
			}
			//将最小的数与当前数交换
			if(minIndex!=i){
				sortedArray[minIndex]=sortedArray[i];
				sortedArray[i]=minInt;
			}
		}
		return sortedArray;
	}
}