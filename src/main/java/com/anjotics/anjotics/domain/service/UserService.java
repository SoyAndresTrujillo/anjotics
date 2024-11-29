package com.anjotics.anjotics.domain.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.repository.UserRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class UserService {
  /**
   * This is the UserRepository instance that is used to perform CRUD operations
   * on the User entity.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * This method is used to get all users from the database.
   * 
   * @return List<UserDomain>
   */
  public List<UserDomain> getAll() {
    return userRepository.getAll();
  }

  /**
   * This method is used to get all records from a csv file and return a list
   * of String arrays.
   * 
   * @param file
   * @return List<String[]>
   */
  public List<String[]> parseCsvFile(InputStream file) throws IOException, CsvException {
    try (CSVReader csvReader = new CSVReader(new InputStreamReader(file))) {
        return csvReader.readAll();
    }
  }
}
