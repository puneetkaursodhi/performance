<%@ page import="com.intelligrape.linksharing.Topic" %>

<div class="form-group" ${hasErrors(bean: topicInstance, field: 'title', 'error')} required>
    <label class="col-md-2 zeroLeftMrgn fivePxTopMrgn" for="title">
        <span>Title</span>
    </label>

<div class="col-md-5">
    <g:textField name="title" rows="3" value="${topicInstance?.title}" class="form-control input-md"/>
</div>
</div>

<div class="form-group">
    <label class="col-md-2 zeroLeftMrgn fivePxTopMrgn" for="description">
        <span><g:message code="coupon.description.label" default="Description"/></span>
    </label>

    <div class="col-md-5">
        <g:textArea name="description" rows="3" value="${topicInstance?.description}" class="form-control"/>
    </div>
</div>

<div class="form-group ${hasErrors(bean: topicInstance, field: 'creator', 'error')} required">
    <label class="col-md-2 zeroLeftMrgn fivePxTopMrgn" for="creator">
        <span><g:message code="coupon.couponType.label" default="Creator"/></span>
    </label>

    <div class="col-md-2">
        <g:select class="form-control" name="creator.id" from="${com.intelligrape.linksharing.User.list()}"
                  value="${topicInstance?.creator?.id}"
                  optionValue="firstName" optionKey="id"/>
    </div>
</div>




<div class="form-group ${hasErrors(bean: topicInstance, field: 'visibility', 'error')} required">
    <label class="col-md-2 zeroLeftMrgn fivePxTopMrgn" for="visibility">
        <span><g:message code="coupon.couponType.label" default="Visibility"/></span>
    </label>

    <div class="col-md-2">
        <g:select class="form-control" name="visibility" from="${com.intelligrape.linksharing.enums.Visibility?.values()}" value="${topicInstance?.visibility?.displayName}"
                  optionValue="displayName"/>
    </div>
</div>




