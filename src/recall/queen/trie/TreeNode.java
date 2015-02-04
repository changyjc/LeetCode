package recall.queen.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * 1.无序
 * 2.属性：层layer，值value
 * 3.结构属性：父节点（TreeNode），子节点（ArrayList）
 * 4.方法：
 * 		a.一般
 * 		b.特殊
 */
public class TreeNode {
		public static final int SIZE = 8;
    	private int layer;
    	private int value;
    	private TreeNode parentNode;
    	private List<TreeNode> childList;
    
    	public TreeNode(int value){
    		childList = new ArrayList<TreeNode>();
    		this.value = value;
    	}
    
	    public TreeNode(int layer, int value){
	    	childList = new ArrayList<TreeNode>();
	    	this.layer = layer;
	        this.value = value;
	    }
	    
	    public void add(TreeNode childNode) {
	    	childNode.setParentNode(this);
	    	childNode.setLayer(this.layer + 1);
	    	childNode.format();
	    	/*
	    	if(childNode.layer == SIZE){
	    		TreeNode t = this;
	    		while(t != null) {
		    		System.out.print(this.value);
		    		t = t.parentNode;
	    		}
	    		System.out.println();
	    	}
	    	*/
	    	childList.add(childNode);
	    	   	
	    }

	    
	    public ArrayList<Integer> getParentSurvial(){
	    	TreeNode parent = this.getParentNode();
	    	ArrayList<Integer> survival = new ArrayList<Integer>();
			Iterator<TreeNode> iterator = parent.getChildList().iterator();
			while(iterator.hasNext()){
				survival.add(iterator.next().getValue());
			}
			
			return survival;
	    }
		
	    /**
	     * 杀死其他格子
	     * @param id
	     * @param survivalPoint
	     * @return
	     */
		@SuppressWarnings("unchecked")
		public ArrayList<Integer> kill(Integer value, ArrayList<Integer> survivalPoint){
			ArrayList<Integer> killedSurvial = new ArrayList<Integer>();
			killedSurvial = (ArrayList<Integer>) survivalPoint.clone();
			
			//横
			for(int i=1; i<=SIZE; i++){
				int c = value/10;
				for(int index=0; index < survivalPoint.size(); index++){
					if(survivalPoint.get(index) == c*10+i){
//						System.out.println("remove" + Integer.valueOf(c*10+i));
						killedSurvial.remove(Integer.valueOf(c*10+i));
					}
				}
			}
			
			//纵
			for(int i=1; i<=SIZE; i++){
				int r = value%10;
				int index;
				for(index=0; index < survivalPoint.size(); index++){
					if(survivalPoint.get(index) == i*10+r){
//						System.out.println("remove" + Integer.valueOf(i*10+r));
						killedSurvial.remove(Integer.valueOf(i*10+r));
					}
				}
			}
			
			//斜
			ArrayList<Integer> slantValue = new ArrayList<Integer>();
			for(int n=1; n<=SIZE; n++){
				int c = value/10;
				int r = value%10;
				
				if(c+n <= SIZE && r+n <= SIZE){
					slantValue.add((c+n)*10 + (r+n));
				}
				if(c-n > 0 && r-n > 0){
					slantValue.add((c-n)*10 + (r-n));
				}
				if(c-n > 0 && r+n <= SIZE){
					slantValue.add((c-n)*10 + (r+n));
				}
				if(c+n <= SIZE && r-n > 0){
					slantValue.add((c+n)*10 + (r-n));
				}
			}
			Iterator<Integer> iterator = slantValue.iterator();
			while(iterator.hasNext()){
//				if(survivalPoint.get(index) == iterator.next()){
				int x = iterator.next();
					if(killedSurvial.contains(Integer.valueOf(x))){
						killedSurvial.remove(Integer.valueOf(x));
//						System.out.println("remove" + Integer.valueOf(x));
					}
					
//			}
			}
			

			/*
			for(int index=0; index < survivalPoint.size(); index++){
				Iterator<Integer> iterator = slantValue.iterator();
				while(iterator.hasNext()){
					
					if(survivalPoint.get(index) == iterator.next()){
						System.out.println("remove" + Integer.valueOf(iterator.next()));
						killedSurvial.remove(Integer.valueOf(iterator.next()));
					}
				}

			}
			*/
			
			return killedSurvial;
		}
		
		/**
		 * 格式化
		 * 
		 */
		public void format(){
			ArrayList<Integer> parentSurvival = getParentSurvial();
			ArrayList<Integer> survival = kill(value, parentSurvival);
			
			if(survival != null){
				Iterator<Integer> iterator = survival.iterator();
				while(iterator.hasNext()){
					TreeNode childNode = new TreeNode(iterator.next());
					this.add(childNode);
				}
			}
			
		}
		
		/**
		 * Print子树
		 */
		public void print() {
			print("");
		}
		
		public void print(String prefix) {
			StringBuilder builder = new StringBuilder();
			
			//创建一个list，存储结果
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			
//			builder.append(prefix);
			if(layer == SIZE) {
				
				TreeNode parent = parentNode;
				
				result.add(value);
//				builder.append(value + " ");
				while(parent != null & parent.value != 0) {
					result.add(parent.value);
//					builder.append(parent.value + " ");
					parent = parent.parentNode;
				}
//				System.out.println(builder);
				
				Board board = new Board(result);
				board.print();
				System.out.println();
				
//				builder.append("第" + layer +"层;" + "值：" + value 
//						+ " parent=" + ((parentNode != null) ? parentNode.value : "NULL")
//						+ " parent2=" + ((parentNode.parentNode != null) ? parentNode.parentNode.value : "NULL")
//						);


			}
			
			Iterator<TreeNode> iterator = this.getChildList().iterator();
			while(iterator.hasNext()){
				TreeNode next = iterator.next();
				next.print(prefix + "");
			}
		}
		
		/**
		 * 前序遍历，查找解
		 *
		 */
		public void solve() {
			//第8层，返回路径

			if(layer == 8) {
				System.out.print(value);
				TreeNode parent = parentNode;

				while(parent != null) {
					parent = parent.parentNode;
					
					System.out.print(value);
				}
			}

			//不是第8层，递归
			Iterator<TreeNode> iterator = this.getChildList().iterator();
			while(iterator.hasNext()){
				TreeNode next = iterator.next();
				next.solve();
			}
		}
		
	    /**
	     * set.get方法
	     * @return
	     */
		public TreeNode getParentNode() {
			return parentNode;
		}
	
		public void setParentNode(TreeNode parentNode) {
			this.parentNode = parentNode;
		}
	
	   public int getLayer() {
			return layer;
		}

		public void setLayer(int layer) {
			this.layer = layer;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public List<TreeNode> getChildList() {
			return childList;
		}

		public void setChildList(List<TreeNode> childList) {
			this.childList = childList;
		}
}