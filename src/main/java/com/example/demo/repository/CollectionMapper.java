package com.example.demo.repository;

public interface CollectionMapper {

    Integer selectCollectionNumber(Integer blogid);

    void insert(Integer userid,Integer blogid);

    Integer selectByPrimaryKey(Integer userid,Integer blogid);

    void deleteByPrimaryKey(Integer userid,Integer blogid);
}
