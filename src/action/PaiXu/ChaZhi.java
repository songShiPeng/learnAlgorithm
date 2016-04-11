package action.PaiXu;

public class ChaZhi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={8,5,9,2,6,3};
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int j=i;
			for(;j>0&&temp<a[j-1];j--){
					a[j]=a[j-1];
			}
			a[j]=temp;
		}
		for(Integer i:a){
			System.out.println(i);
		}
	}

}
