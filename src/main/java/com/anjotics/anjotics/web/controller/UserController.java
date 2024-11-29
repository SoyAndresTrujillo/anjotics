package com.anjotics.anjotics.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.service.UserService;
import com.opencsv.exceptions.CsvException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
  @Operation(summary = "Get all users", description = "Returns a list of all users")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public ResponseEntity<List<UserDomain>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  /**
   * This controller is used for create new users (called bull process) from a
   * csv file in body request with key file.
   * The response is a message with success or failed records.
   * 
   * @param file
   * @return ResponseEntity<String>
   */
  @PostMapping("/import")
  @Operation(summary = "Import users from a csv file", description = "Imports users from a csv file")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Successfully imported users"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public ResponseEntity<String> importUsers(@RequestParam("file") MultipartFile file) {
    try {
        List<String[]> records = userService.parseCsvFile(file.getInputStream());
        return ResponseEntity.ok("Successfully imported " + records.size() + " users");
    } catch (IOException | CsvException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing users");
    }
  }
}
