package com.misc.graph;

import java.util.List;
import java.util.StringJoiner;

public class Node implements Cloneable {
    private String id;
    private int levelNumber;
    private List<Node> childs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("levelNumber=" + levelNumber)
                .add("childs=" + childs)
                .toString();
    }
}
