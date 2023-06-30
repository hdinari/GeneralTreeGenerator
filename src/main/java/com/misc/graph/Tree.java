package com.misc.graph;

import java.util.StringJoiner;

public class Tree {
    private Node node;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tree.class.getSimpleName() + "[", "]")
                .add("node=" + node)
                .toString();
    }
}
