package com.greg.slackstack.controller;

import com.greg.slackstack.model.Item;
import com.greg.slackstack.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Collection;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/stackItems")
    public Collection<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/stackItems/{index}")
    public Item getItemById(@PathVariable Integer index) {
        return itemService.getItemById(index);
    }

    @GetMapping("/stackItems/questionLookup/{questionId}")
    public Item getItemByQuestionId(@PathVariable Integer questionId){
        Item itemFromAPI;
        itemFromAPI = itemService.getStackItemByQuestionId(questionId);
        itemService.addItem(itemFromAPI);
        return itemFromAPI;
    }


    @PostMapping("/stackItems")
    public ResponseEntity<Void> addMessage(@RequestBody Item newItem) {

        itemService.addItem(newItem);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{questionId}").buildAndExpand(newItem.getQuestionId()).toUri();

        return ResponseEntity.created(location).build();
    }
//
//    @PutMapping("/messages/{messageId}")
//    public ResponseEntity<Void> updateMessage(@RequestBody Message updatedMessage) {
//
//        messageService.updateMessage(updatedMessage);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .buildAndExpand(updatedMessage.getMessageId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }

    @DeleteMapping("/stackItems/{index}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Integer index) {
        itemService.deleteItemById(index);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();

        return ResponseEntity.created(location).build();
    }

}