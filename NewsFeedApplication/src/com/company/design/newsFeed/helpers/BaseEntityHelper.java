package com.company.design.newsFeed.helpers;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public class BaseEntityHelper {
    
    public static void addDefaultDataOnSave(BaseEntity baseEntity){
        baseEntity.setId(UUID.randomUUID().toString());
        baseEntity.setCreatedAt(new Date());
        baseEntity.setModifiedAt(new Date());
    }

    public static void addDefaultDataOnUpdate(BaseEntity baseEntity){
        baseEntity.setModifiedAt(new Date());
    }
}
