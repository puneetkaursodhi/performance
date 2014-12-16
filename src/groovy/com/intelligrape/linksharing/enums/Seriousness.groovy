package com.intelligrape.linksharing.enums


public enum Seriousness {
    CASUAL('Male'),
    SERIOUS('Female'),
    VERY_SERIOUS('Very Serious')

    final String displayName

    Seriousness(String displayName) {
        this.displayName = displayName
    }
}