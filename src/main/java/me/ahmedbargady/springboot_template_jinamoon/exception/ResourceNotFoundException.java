package me.ahmedbargady.springboot_template_jinamoon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceNameString, String fieldNameString, Object fieldValueObject) {
        super(String.format("%s not found with %s : '%s'", resourceNameString, fieldNameString, fieldValueObject));
        this.resourceName = resourceNameString;
        this.fieldName = fieldNameString;
        this.fieldValue = fieldValueObject;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
