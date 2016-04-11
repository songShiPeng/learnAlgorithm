package action.PaiXu;

public class KuaiSu {

	/**快速排序
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={1,5,2,87,24,12,5,9,25};
		//int []a={2,4,7,3,5};
		quickSort(a,0,a.length-1);
		for(Integer i:a){
			System.out.println(i);
		}
	}
	
	public static void quickSort(int[] a,int low,int heigh){
		int temp=0;
		if(heigh>low){
			int center=(low+heigh)/2;
			//对 low middle heigh排序
			if(a[center]<a[low]){
				swap(a,center,low);
			}
			if(a[heigh]<a[low]){
				swap(a,heigh,low);
			}
			if(a[heigh]<a[center]){
				swap(a,heigh,center);
			}
			//交换cneter和high-1
			swap(a,center,heigh-1);
			//得到需要的中值
			int middle=heigh-1;
			//核心算法
			int i,j;
			for( i=low,j=heigh-1;;){
					if(i<a.length-1)
					//优化--事实证明从low+1和heigh-2开始循环比较好
						while(a[++i]<a[middle]);
					if(j>0)
						while(a[--j]>a[middle]);
					//如果i和j交叉，跳出
					if(i>=j)
						break;
					swap(a,i,j);
				
			}
			//重新开始排序，现在i指向一个大于或等于中心点的值
			swap(a,i,heigh-1);//把中心点放到原来的位置上
			quickSort(a,low,i-1);
			quickSort(a,i+1,heigh);
		}
	}
	public static void swap(int []a,int b,int c){
		int temp=a[b];
		a[b]=a[c];
		a[c]=temp;
	}

}
