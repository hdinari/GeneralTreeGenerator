package com.misc.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTree {
    private static Random random = new Random();

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node node = new Node();
        node.setLevelNumber(0);
        node.setId("Main-Tree-Root");
        generateItsChilds(node);
        tree.setNode(node);
        System.out.println("MainTree:" + tree);
        copyTree(tree);
    }

    private static void copyTree(Tree tree) {
        Node treeRoot = tree.getNode();
        Tree tree2=new Tree();
        Node anotherTree = new Node();
        anotherTree.setId("Another-Tree-Root");
        tree2.setNode(anotherTree);
        copyToAnotherTree(treeRoot, anotherTree);
        System.out.println("Another-Tree:" + tree2);
    }

    private static void copyToAnotherTree(Node root, Node anotherTree) {
        List<Node> childs = root.getChilds();
        if (childs != null && anotherTree.getChilds() == null) {
            anotherTree.setChilds(root.getChilds());
            copyToAnotherTree(root, anotherTree);
        }
        if (childs != null && anotherTree.getChilds() != null) {
            for (int i = 0; i < childs.size(); i++) {
                anotherTree.getChilds().get(i).setChilds(childs.get(i).getChilds());
                copyToAnotherTree(childs.get(i), anotherTree.getChilds().get(i));
            }
        }
    }

    private static void generateItsChilds(Node node) {
        if (node.getLevelNumber() == 8)
            return;
        int numberOfChild = random.nextInt(3) + 1;
        List<Node> childsOfNode = new ArrayList<>();
        if (node.getChilds() == null) {
            for (int i = 0; i < numberOfChild; i++) {
                Node child = new Node();
                child.setId("child-" + i + "th");
                child.setLevelNumber(node.getLevelNumber() + 1);
                childsOfNode.add(child);
            }
            node.setChilds(childsOfNode);
        }
        for (Node child : node.getChilds())
            generateItsChilds(child);
    }
}
