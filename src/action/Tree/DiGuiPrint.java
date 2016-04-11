package action.Tree;

public class DiGuiPrint {

	/**递归的前序，后序，中序打印
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode<Integer> bn0=new BinaryNode<Integer>(2,null,null);
		BinaryNode<Integer> bn1=new BinaryNode<Integer>(5,null,bn0);
		BinaryNode<Integer> bn2=new BinaryNode<Integer>(4,null,null);
		BinaryNode<Integer> bn3=new BinaryNode<Integer>(3,bn1,bn2);
		bn3.printPreOrder();
	}

}
class BinaryNode<T>{
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private T t;
	public BinaryNode(T t,BinaryNode<T> left,BinaryNode<T> right){
		this.t=t;
		this.left=left;
		this.right=right;
	}
	//前序排列
	public void printPreOrder(){
		System.out.println(t);
		if(left!=null){
			left.printPreOrder();
		}
		if(right!=null){
			right.printPreOrder();
		}
	}
}
class BinaryTree<T>{
	private BinaryNode<T> root;

	//构造根节点为root的树
	public BinaryTree (BinaryNode<T> root){
		this.root=root;
	}
	public BinaryNode<T> getRoot() {
		return root;
	}
	//保存树,t作为root t1和t2作为左右树
	public void merge(T t,BinaryTree<T> t1,BinaryTree<T> t2){
		//如果t1等于t2且不是空则不执行
		if(t1.root==t2.root&&t1.root!=null){
			return;
		}
		root=new BinaryNode<T>(t,t1.root,t2.root);
		if(this!=t1){
			t1.root=null;
		}
		if(this!=t2){
			t2.root=null;
		}
	}
	//前序排列
	public void printPreOrder(){
		if(root!=null){
			root.printPreOrder();
		}
	}
}
