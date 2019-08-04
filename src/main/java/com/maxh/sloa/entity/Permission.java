package com.maxh.sloa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Permission {
    private Long id;
    private Permission parent;
    private String name;
    private String permissionKey;
    private Type type;
    private String path;
    private String resource;
    private Boolean enable = false;
    private String description;
    private Integer weight = 0;
    private Long parent_id;
    private List<Permission> children;
    /**
     * 权限类型枚举
     */
    public enum Type {
        MENU("菜单"),
        FUNCTION("功能"),
        BLOCK("区域");

        private String display;

        Type(String display) {
            this.display = display;
        }

        public String display() {
            return display;
        }

        @Override
        public String toString() {
            return this.display + "[" + this.name() + "]";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public Type getType() {
        return type;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", permissionKey='" + permissionKey + '\'' +
                ", type=" + type +
                ", path='" + path + '\'' +
                ", resource='" + resource + '\'' +
                ", enable=" + enable +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                '}';
    }
}
