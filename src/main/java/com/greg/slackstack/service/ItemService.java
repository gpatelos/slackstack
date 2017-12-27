package com.greg.slackstack.service;

import com.greg.slackstack.dao.ItemDao;
import com.greg.slackstack.model.Item;
import com.greg.slackstack.model.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;



@Service
public class ItemService {

    @Autowired
    @Qualifier("fakeItem")
    private ItemDao itemDao;

    public Item getStackItemByQuestionId(Integer id){

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        Wrapper wrapper = restTemplate.getForObject(
                "http://api.stackexchange.com/2.2/questions/"+ id +"?order=desc&sort=activity&site=stackoverflow", Wrapper.class);

        Item item;
        item = wrapper.getItem().get(0);
        return item;

    }


    public Collection<Item> getAllItems() {
        return this.itemDao.getAllItems();
    }

    public Item getItemById(Integer id) {
        return this.itemDao.getItemById(id);
    }

    public void deleteItemById(Integer id) {
        this.itemDao.removeItemById(id);
    }

    public void addItem(Item item) {
        this.itemDao.insertItemIntoDb(item);
    }

}
