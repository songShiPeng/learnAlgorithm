package action.PaiXu;

public class GuiBing {

	/**归并排序算法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={1,24,13,12,8};
		int []temp=new int[a.length];
		mergeSorte(a,temp,0,a.length-1);
		for(Integer i:a){
			System.out.println(i);
		}
	}
	public static void mergeSorte(int []a,int[] temp,int left,int right){
		if(left<right){
			int center =(left+right)/2;
			mergeSorte(a,temp,left,center);
			mergeSorte(a,temp,center+1,right);
			merge(a,temp,left,center+1,right);
		}
	}
	//把左右合并--核心
	public static void merge(int [] a,int []temp,int leftBegin,int rightBegin,int rightEnd){
		int leftEnd=rightBegin-1;
		int tempBegin=leftBegin;
		int numElements=rightEnd-leftBegin+1;
		//主循环
		while(leftBegin<=leftEnd&&rightBegin<=rightEnd){
			if(a[leftBegin]<=a[rightBegin]){
				temp[tempBegin++]=a[leftBegin++];
			}
			else{
				temp[tempBegin++]=a[rightBegin++];
			}
		}
		while(leftBegin<=leftEnd){
			temp[tempBegin++]=a[leftBegin++];
		}
		while(rightBegin<=rightEnd){
			temp[tempBegin++]=a[rightBegin++];
		}
		for(int i=0;i<numElements;i++,rightEnd--){
			a[rightEnd]=temp[rightEnd];
		}
	}

}
