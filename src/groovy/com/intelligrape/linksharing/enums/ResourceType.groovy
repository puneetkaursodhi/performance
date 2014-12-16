package com.intelligrape.linksharing.enums


public enum ResourceType {
    LINK('Link'),
    DOCUMENT('Document'),

    final String displayName

    ResourceType(String displayName) {
        this.displayName = displayName
    }
}