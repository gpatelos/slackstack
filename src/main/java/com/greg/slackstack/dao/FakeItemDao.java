package com.greg.slackstack.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.greg.slackstack.model.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeItem")
public class FakeItemDao implements ItemDao {

    private static Map<Integer, Item> itemMap;

    static {

        itemMap = new HashMap<Integer, Item>() {

            {
                put(0, new Item());
                put(1, new Item());
                put(2, new Item());
            }
        };
    }


    @Override
    public Collection<Item> getAllItems() {
        return this.itemMap.values();
    }

    @Override
    public Item getItemById(Integer id) {
        return this.itemMap.get(id);
    }

    @Override
    public void removeItemById(Integer id) {
        this.itemMap.remove(id);
    }

    @Override
    public void insertItemIntoDb(Item item) {
        itemMap.put(itemMap.size(),item);

    }
}
