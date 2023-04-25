package com.company.design.newsFeed.dtos;

import java.util.*;

public abstract class BaseDto {
    private String id;
    private Date createdAt;
    private Date modifiedAt;

    public BaseDto(){}

    public BaseDto(String id, Date createdAt, Date modifiedAt){
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
