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
//search for a node
    public Node findNode(int key){
        Node focusNode  = root;
        while (focusNode.key != key){
            //less than the current node search left
            if (key < focusNode.key){
                focusNode = focusNode.leftChild;
            }
            else{
                focusNode = focusNode.rightChild;
            }
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }


    public boolean remove (int key){
        Node focusNode = root;
        //to start at the top of the binary tree
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.key != key){

            parent = focusNode;

            //search to the left
            if(key < focusNode.key){
                isItALeftChild = true;
                focusNode = focusNode.leftChild;

            }
            //search to the right
            else {
                isItALeftChild = false;
                focusNode = focusNode.rightChild;
            }

            if(focusNode == null)
                return false;

        }
        //Delete if they are in a leaf format or they don't have any children
        if(focusNode.leftChild == null && focusNode.rightChild == null){

            if(focusNode == root){
                root = null;
            }

            else if(isItALeftChild){
                parent.leftChild = null;
            }
            else{
                parent.rightChild = null;
            }
        }
        //Delete if there is no right child
        else if( focusNode.rightChild == null){
            if(focusNode == root)
                root = focusNode.leftChild;
            else if (isItALeftChild)
                parent.leftChild = focusNode.leftChild;
            else
                parent.rightChild = focusNode.leftChild;
        }
        //if there is no left child
        else if( focusNode.leftChild == null){
            if(focusNode == root)
                root = focusNode.rightChild;
            else if (isItALeftChild)
                parent.leftChild = focusNode.rightChild;
            else
                parent.rightChild = focusNode.leftChild;
        }
        else{
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root){
                root = replacement;
            }
            else if (isItALeftChild)
                parent.leftChild = replacement;
            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;
        }
        return true;

    }

    public Node getReplacementNode(Node replaceNode){
        Node replacementParent = replaceNode;
        Node replacement =replaceNode;
        Node focusNode = replaceNode.rightChild;

        while(focusNode!= null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if (replacement != replaceNode.rightChild){
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceNode.rightChild;
        }
        return replacement;
    }




    public static void main(String[] args){
        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50,"Boss");
        theTree.addNode(25,"VP");
        theTree.addNode(15,"CEO");
        theTree.addNode(30,"SEC");
        theTree.addNode(75,"CTO");
        theTree.addNode(85,"Sales");

        System.out.println("Remove Key 25");
        theTree.remove(25);


        theTree.preOrderTraverseTree(theTree.root);

//        System.out.println("Search for 30");
//        System.out.println(theTree.findNode(30));
//



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
