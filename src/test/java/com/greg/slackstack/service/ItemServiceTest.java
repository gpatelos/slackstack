package com.greg.slackstack.service;

import com.greg.slackstack.dao.FakeItemDao;
import com.greg.slackstack.model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;


public class ItemServiceTest {

    ItemService itemService =new ItemService();



    @Before
    public void setUp() throws Exception {
        Item fakeItem = new Item();
        fakeItem.setTitle("spring rest 4eva");
        fakeItem.setScore(100);
        fakeItem.setAnswered(true);
        fakeItem.setQuestionId(12345);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("java");
        strings.add("redhat");
        strings.add("green camel");
        fakeItem.setTags(strings);
        itemService.addItem(fakeItem);
    }

//    @Test
//    public void getItemFromApiTest(){
//        fakeItemDao.
//    }
//
    @Test
    public void addItemByIdTest() {
        Item greg = new Item();
        itemService.addItem(greg);
        String expected = "Item parsed to ->\n" +
                "questionId: 12345\n" +
                "isAnswered: true\n" +
                "tags: [java, redhat, green camel]\n" +
                "owner: null\n" +
                "score: 100\n" +
                "link: null\n" +
                "title: spring rest 4eva";
        System.out.println(itemService.getAllItems().size());
        String actual = itemService.getItemById(0).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getItemByIdTest() {

        String actual = itemService.getItemById(1).toString();
        String expected = "Item parsed to ->\n" +
                "questionId: null\n" +
                "isAnswered: null\n" +
                "tags: null\n" +
                "owner: null\n" +
                "score: null\n" +
                "link: null\n" +
                "title: null";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAllItemsTest() {

        String actual = itemService.getAllItems().toString();
        String expected = "[Item parsed to ->\n" +
                "questionId: null\n" +
                "isAnswered: null\n" +
                "tags: null\n" +
                "owner: null\n" +
                "score: null\n" +
                "link: null\n" +
                "title: null, Item parsed to ->\n" +
                "questionId: null\n" +
                "isAnswered: null\n" +
                "tags: null\n" +
                "owner: null\n" +
                "score: null\n" +
                "link: null\n" +
                "title: null, Item parsed to ->\n" +
                "questionId: null\n" +
                "isAnswered: null\n" +
                "tags: null\n" +
                "owner: null\n" +
                "score: null\n" +
                "link: null\n" +
                "title: null]";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteItemByIdTest() {

        Item actualItem = itemService.getItemById(2);
        itemService.deleteItemById(2);

        Collection<Item> allItems = itemService.getAllItems();
        Assert.assertFalse(allItems.contains(actualItem));
    }


}