package action.PaiXu;

public class ShellSort {

	/**谢尔排序
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={8,5,9,2,6,3};
		for(int g=a.length/2;g>0;g=g==2?1:(int)(g/2.2)){
			for(int i=g;i<a.length;i++){
				int temp=a[i];
				int j=i;
				for(;j>=g&&temp<a[j-g];j-=g){
						a[j]=a[j-g];
				}
				a[j]=temp;
			}
		}
		for(Integer i:a){
			System.out.println(i);
		}
	}

}
