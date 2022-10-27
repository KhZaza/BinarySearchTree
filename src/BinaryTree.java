public class BinaryTree {

    Node root;
//Add a new Node
    public void addNode(int key, String name){
        Node newNode = new Node(key, name);

        // if the root is indeed the root element of the tree
        if(root == null){
            root = newNode;
        }
        //if it is not the actual root
        else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                //if hte key is less than the foucsNOde, then to set teh focusNOde as the left child
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    //if it has no children place the new node to the left
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                //else place it to the right child
                else{
                    focusNode = focusNode.rightChild;
                    // if it has no children then put it in the right
                    if(focusNode ==  null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);

        }
    }
    public void preOrderTraverseTree(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);

            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);

        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if(focusNode != null){

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);


        }
    }

    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"VP");
        theTree.addNode(15,"CEO");
        theTree.addNode(30,"SEC");
        theTree.addNode(75,"CTO");
        theTree.addNode(85,"Sales");

        theTree.postOrderTraverseTree(theTree.root);


    }

}



//class node to setup the nodes and add the keys to them
class Node{
    int key;
    String name;


    Node leftChild;
    Node rightChild;

    Node(int key, String name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;
    }


}
