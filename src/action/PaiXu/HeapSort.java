package action.PaiXu;

public class HeapSort {
	public static void main(String [] args){
		int []a={1,5,2,87,24,12,5,9,25};
		for(int i=1;i<a.length;i++){
			makeHeap(a,i);
		}
		//重复从堆中删除根，实现排序
		for(int i=a.length-1;i>0;){
			int temp=a[i];
			a[i]=a[0];
			a[0]=temp;
			rebuildHeap(a,--i);
		}
		for(Integer i:a){
			System.out.println(i);
		}
	}
	//初始化堆 在a[0...k]中建立一个堆,假定a[0....k-1]已经是个堆
	public static void makeHeap(int[] a,int k){
		int target=k;
		while(target>0&&a[target]>a[(target-1)/2]){
			int temp=a[target];
			a[target]=a[(target-1)/2];
			a[(target-1)/2]=temp;
			target=(target-1)/2;
		}
	}
	//重建堆，将根与最后一个元素交换，然后删除根，然后重建堆.当前除a[0]外其他元素满足堆
	public static void rebuildHeap(int [] a,int last){
		int target=0;
		boolean isHeap=false;
		while(!isHeap){
			int left=2*target+1;
			int right=2*target+2;
			int max=target;
			if(left<=last&&a[left]>a[max]){
				max=left;
			}
			if(right<=last&&a[right]>a[max]){
				max=right;
			}
			if(max!=target){
				int temp=a[target];
				a[target]=a[max];
				a[max]=temp;
				target=max;
			}
			else{
				isHeap=true;
			}
		}
	}
}
