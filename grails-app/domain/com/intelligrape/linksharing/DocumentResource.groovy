package com.intelligrape.linksharing

class DocumentResource extends Resource {
    String path
    String contentType

    static constraints = {
        path(blank: false, nullable: false)
    }

}
