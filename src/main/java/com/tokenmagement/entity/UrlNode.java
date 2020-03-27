package com.tokenmagement.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UrlNode {
    private String name;
    private Set<UrlNode> nextNodes = new HashSet<>();

    public UrlNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UrlNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(Set<UrlNode> nextNodes) {
        this.nextNodes = nextNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlNode urlNode = (UrlNode) o;
        return name.equals(urlNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
