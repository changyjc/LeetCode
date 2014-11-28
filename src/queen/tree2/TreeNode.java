package queen.tree2;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TreeNode{
    private int parentId;
    private int selfId;
    protected Integer nodeName;
    protected Object obj;
    protected TreeNode parentNode;
    protected List<TreeNode> childList;

    public TreeNode(Integer id) {
        initChildList();
        this.nodeName = id;
    }

    public TreeNode(TreeNode parentNode) {
        this.getParentNode();
        initChildList();
    }

    public boolean isLeaf() {
        if (childList == null) {
            return true;
        } else {
            if (childList.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* 插入一个child节点到当前节点中 */
    public void addChildNode(TreeNode treeNode) {
        initChildList();
        childList.add(treeNode);
    }

    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<TreeNode>();
    }

    public boolean isValidTree() {
        return true;
    }

    /* 返回当前节点的父辈节点集合 */
    public List<TreeNode> getElders() {
        List<TreeNode> elderList = new ArrayList<TreeNode>();
        TreeNode parentNode = this.getParentNode();
        if (parentNode == null) {
            return elderList;
        } else {
            elderList.add(parentNode);
            elderList.addAll(parentNode.getElders());
            return elderList;
        }
    }

    /* 返回当前节点的晚辈集合 */
    public List<TreeNode> getJuniors() {
        List<TreeNode> juniorList = new ArrayList<TreeNode>();
        List<TreeNode> childList = this.getChildList();
        if (childList == null) {
            return juniorList;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode junior = childList.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }

    /* 返回当前节点的孩子集合 */
    public List<TreeNode> getChildList() {
        return childList;
    }

    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        TreeNode parentNode = this.getParentNode();
        int id = this.getSelfId();

        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    }

    /* 删除当前节点的某个子节点 */
    public void deleteChildNode(int childId) {
        List<TreeNode> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getSelfId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }

    /* 动态的插入一个新的节点到当前树中 */
    public boolean insertJuniorNode(TreeNode treeNode) {
        int juniorParentId = treeNode.getParentId();
        if (this.parentId == juniorParentId) {
            addChildNode(treeNode);
            return true;
        } else {
            List<TreeNode> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                TreeNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }

    /* 找到一颗树中某个节点 */
    public TreeNode findTreeNodeById(int id) {
        if (this.selfId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode child = childList.get(i);
                TreeNode resultNode = child.findTreeNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }

    /* 遍历一棵树，层次遍历 */
    public void traverse() {
        if (selfId < 0)
            return;
        print(this.selfId);
        if (childList == null || childList.isEmpty())
            return;
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            child.traverse();
        }
    }

    public void print(String content) {
        System.out.println(content);
    }

    public void print(int content) {
        System.out.println(String.valueOf(content));
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public Integer getNodeName() {
        return nodeName;
    }

    public void setNodeName(Integer nodeName) {
        this.nodeName = nodeName;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
    
    public ArrayList<Integer> getParentSurvial(){
    	TreeNode parent = this.getParentNode();
    	ArrayList<Integer> survival = new ArrayList<Integer>();
		Iterator<TreeNode> iterator = parent.getChildList().iterator();
		while(iterator.hasNext()){
			survival.add(iterator.next().getNodeName());
		}
   
    	return survival;
    }
}