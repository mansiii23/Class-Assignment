import java.util.*; 
public class AufbauPrinting 
{ 
    static class Node
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
};

    static int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            int lh = height(root.left); 
            int rh = height(root.right); 
            if (lh >= rh) 
                 return(lh+1); 
            else 
                return(rh+1);  
        } 
    } 
    static void printLeftRoots(Node root){
        if(root==null){
            System.out.print(" ");
        }
        else{
            printLeftRoots(root.left);
            System.out.print(root.data +" ");
        }
    }
    static void printRightRoots(Node root){
        if (root==null){
            System.out.print(" ");
        }
        else{
            printRightRoots(root.right);
            System.out.print(root.data+" ");
        }
    }
   static void print(Node root){
        int h=height(root);
        for(int i=0;i<h;i++){
            printLeftRoots(root);
            printRightRoots(root);
        }
        }
  /*  static void printLeftRoots (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printLeftLevel(root.left, level-1); 
            printLeftLevel(root.right, level-1); 
        } 
    }   
    static void printRightRoots (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printRightLevel(root.left, level-1); 
            printRightLevel(root.right, level-1); 
        } 
    } */  
    static Node insert(Node root, int data)  
   {  
    Node node= new Node(data);
    if(root==null){
        return node;
    } 
    Node parent=null, current = root;
    while(current!=null){
        parent=current;
        if(current.data>=data){
            current=current.left;
        }
        else{
            current=current.right;
        }
    }
    if(parent.data>=data){
        parent.left=node;
    }
    else{
        parent.right=node;
    }
    return root;
    }
public static void main(String args[])  
{

    Node root = null;  
    root = insert(root, 40);  
    insert(root, 30);  
    insert(root, 20);  
    insert(root, 35);  
    insert(root, 70);  
    insert(root, 50);  
    insert(root, 80);   
    print(root);
}  
}