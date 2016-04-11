package action.PaiXu;

public class XuanZe {

	/**选择排序
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={1,5,2,87,24,12,5,9,25};
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[i]){
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		for(Integer i:a){
			System.out.println(i);
		}
	}

}
