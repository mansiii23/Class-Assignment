import java.util.*;  
public class InverseLevelOrder 
{ 
    static class Node
{ 
    int data; 
    Node left, right; 
    public Node(int data) 
    { 
        this.data = data; 
        left = right = null; 
    } 
} ;
    

    static void printLevelOrder(Node root) 
    { 
        int h = height(root);  
        for (int i=h; i>=1; i--) {
            printGivenLevel(root, i);
            System.out.println(); 
        }
    }
    static int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 

            int lheight = height(root.left); 
            int rheight = height(root.right);
            if (lheight >= rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    }
   static void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
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
            current=current.right;
        }
        else{
            current=current.left;
        }
    }
    if(parent.data>=data){
        parent.right=node;
    }
    else{
        parent.left=node;
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
    printLevelOrder(root); 

    } 
} 