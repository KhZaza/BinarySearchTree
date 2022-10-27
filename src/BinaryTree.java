public class BinaryTree {

    public static void main(String[] args){

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
