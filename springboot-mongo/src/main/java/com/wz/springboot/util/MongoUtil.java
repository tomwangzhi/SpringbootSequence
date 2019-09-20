package com.wz.springboot.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * mongo操作类
 */
@Component
public  class MongoUtil {


    private static MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        MongoUtil.mongoTemplate = mongoTemplate;
    }

    /**
     *
     * @param t
     * @param collectionName 没有指定哪个集合，就根据类型去map里面获取对应的集合名
     * @param <T>
     * @return
     */
    public static  <T>  T  insertObjInMongo(T t,String collectionName) {
        if(t == null) {
            throw new NullPointerException("insert obj is not null");
        }
        T value = mongoTemplate.insert(t,collectionName);
        return value;
    }

    /**
     * 批量插入
     * @param collection
     * @param collectionName 没有指定哪个集合，就根据类型去map里面获取对应的集合名
     * @param <T>
     * @return
     */
    public static <T> Collection<T> batchInsertObj(Collection<T> collection,String collectionName) {
        Collection<T> collects = mongoTemplate.insert(collection,collectionName);
        return collects;
    }

    /**
     * 删除对象
     * @param t
     * @param collcetionName
     * @param <T>
     * @return
     */
    public static <T> boolean delObj(T t,String collcetionName) {
        DeleteResult remove = mongoTemplate.remove(t,collcetionName);
        return remove.getDeletedCount() > 0 ? true:false;
    }

    public static MongoCollection<Document> createDefaulCollection(String name) {
        return mongoTemplate.createCollection(name);
    }
    public static Set<String> getCollectionsName() {
        return mongoTemplate.getCollectionNames();
    }




}
