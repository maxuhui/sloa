package com.maxh.sloa.common.enums;

/**
 * 权限类型枚举
 */
public enum ResourceType {
    MENU("菜单"),
    FUNCTION("功能"),
    BLOCK("区域");

    private String display;

    ResourceType(String display) {
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
