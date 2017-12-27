package com.greg.slackstack.dao;

import com.greg.slackstack.model.Item;

import java.util.Collection;

public interface ItemDao {

    Collection<Item> getAllItems();

    Item getItemById(Integer id);

    void removeItemById(Integer id);

    void insertItemIntoDb(Item item);

}
