package action.PaiXu;

public class MaoPao {

	/**冒泡排序法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={1,5,2,87,24,12,5,9,25};
		boolean needNext=true;//判断是否有交换产生
		for(int i=1;i<a.length&&needNext==true;i++){
			needNext=false;
			for(int j=0;j<a.length-i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					needNext=true;
				}
			}
		}
		for(Integer i:a){
			System.out.println(i);
		}
	}

}
