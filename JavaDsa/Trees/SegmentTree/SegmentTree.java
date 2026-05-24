package Trees.SegmentTree;

public class SegmentTree {
   public SegmentNode root;
  public static class SegmentNode{
    public int data;
    public int startIndex;
    public int endIndex;
    public SegmentNode left;
    public SegmentNode right;

    public SegmentNode(int startIndex,int endIndex){
      this.startIndex=startIndex;
      this.endIndex=endIndex;
    }

  }

  public SegmentTree(int[] arr){
    this.root=populateTree(arr);

  }
  public SegmentNode populateTree(int[] arr){
  return populateTree(arr,0,arr.length-1);
  }
  public SegmentNode populateTree(int[] arr,int startIndex,int endIndex){
    if(startIndex==endIndex){
        SegmentNode leafNode=new SegmentNode(startIndex, endIndex);
        leafNode.data=arr[startIndex];
        return leafNode;
    }
    SegmentNode newNode=new SegmentNode(startIndex, endIndex);
    int mid=startIndex+(endIndex-startIndex)/2;
    newNode.left=populateTree(arr,startIndex,mid);
    newNode.right=populateTree(arr, mid+1, endIndex);
    newNode.data=newNode.left.data+newNode.right.data;
    return newNode;

  }
 public void display(){
    if(this.root!=null){
display(this.root);
    }
    else{
        System.out.println("tree is empty");
    }
 }
public void display(SegmentNode node){
if(node==null){
    return;
}

String str="";
str=str+"interval [ "+ node.startIndex+" - "+node.endIndex+" ] data :"+node.data;
System.out.println(str);
display(node.left);
display(node.right);



}

public int query(int startIndex,int endIndex){
if(this.root!=null){
    return query(this.root,startIndex,endIndex);
}
else{
    return -1;
}
}

public int query(SegmentNode node,int startIndex,int endIndex){
    //invalid
    if(node==null || startIndex>node.endIndex || endIndex<node.startIndex){
        return 0;
    }
    //complete overlap
   if(node.startIndex>=startIndex&&node.endIndex<=endIndex){
    return node.data;
   }
//partial overal  if (startIndex <= node.endIndex && endIndex >= node.startIndex) 

    return query(node.left,startIndex, endIndex)+query(node.right, startIndex, endIndex);
}
public void update(int index,int data){
     this.root.data=update(this.root,index, data);
}
public int update(SegmentNode node,int index,int data){
    if(node.startIndex==node.endIndex){
        node.data=data;
        return data;
    }
    int mid=(node.startIndex+node.endIndex)/2;
  if(index<=mid){
    update(node.left, index, data);
  }
  else{
    update(node.right, index, data);
  }
  node.data=node.left.data+node.right.data;

return node.data;
}


public static void main(String[] args) {
    int[] arr={1,2,3,6,3,8,-4,2,5};
    SegmentTree segmentTree=new SegmentTree(arr);
    segmentTree.display();
    System.out.println(segmentTree.query(2,6));
    segmentTree.update(6, 0);
    System.out.println(segmentTree.query(2,6));
}
    
}