package com.anjotics.anjotics.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {
  /**
   * This is the ObjectMapper instance that is used to convert UserDomain objects to JSON strings.
   */
  private final ObjectMapper objectMapper = new ObjectMapper();

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
   * Endpoint to import users from a CSV file.
   * 
   * This method accepts a CSV file as input, parses the file to extract user data,
   * and saves the users to the database. The CSV file should have a specific format
   * with ';' as the separator. The first row is expected to be the header, and the
   * subsequent rows should contain user data.
   * 
   * @param file The CSV file containing user data. It should be uploaded as a
   *             multipart file with the request.
   * @return ResponseEntity containing a map with the import status, message, and
   *         the list of imported users. If successful, the response will have a
   *         status code of 200. In case of an error, the response will have a
   *         status code of 500.
   * 
   * @throws IOException  If an I/O error occurs while reading the file.
   * @throws CsvException If a CSV parsing error occurs.
   */
  @PostMapping("/import")
  @Operation(summary = "Import users from a CSV file", description = "Imports users from a CSV file and saves them to the database.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully imported users"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  public ResponseEntity<Map<String, Object>> importUsers(@RequestParam("file") MultipartFile file) {
      try {
          List<UserDomain> records = userService.parseCsvFile(file.getInputStream());
          
          Map<String, Object> response = new LinkedHashMap<>();
          response.put("Message", "Successfully imported " + records.size() + " users");
          response.put("Status code", 200);
          response.put("Data", records);
          
          return ResponseEntity.ok(response);
      } catch (IOException | CsvException e) {
          Map<String, Object> errorResponse = new HashMap<>();
          errorResponse.put("message", "Error importing users");
          errorResponse.put("status code", 500);
          
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
      }
  }
}
