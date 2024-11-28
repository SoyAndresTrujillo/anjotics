package com.anjotics.anjotics.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  /**
   * This is the UserService instance that is used to perform CRUD operations
   * on the User entity.
   */
  @Autowired
  private UserService userService;

  /**
   * This method is used to get all users from the database.
   * 
   * @return List<UserDomain>
   */
  @GetMapping("/all")
  public ResponseEntity<List<UserDomain>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }
}
