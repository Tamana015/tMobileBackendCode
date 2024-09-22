package com.deutsche.telco.controller;

import com.deutsche.telco.model.Cart;
import com.deutsche.telco.model.User;
import com.deutsche.telco.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/add-in-group")
    public ResponseEntity<User> addInGroup(@RequestParam int userId, @RequestParam String mobileNumber){
        User user = groupService.addInGroup(userId, mobileNumber);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
