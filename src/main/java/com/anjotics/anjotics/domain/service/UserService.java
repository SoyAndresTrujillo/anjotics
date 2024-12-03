package com.anjotics.anjotics.domain.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.repository.UserRepository;
import com.anjotics.anjotics.exceptions.EmptyCsvException;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
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
   * This method reads all records from a CSV file with ';' as the separator, maps them to UserDomain objects,
   * saves them to the database, and returns the list of saved records.
   *
   * @param file InputStream of the CSV file
   * @return List<UserDomain> List of saved UserDomain objects
   * @throws IOException If an I/O error occurs
   * @throws CsvException If a CSV parsing error occurs
   */
  public List<UserDomain> parseCsvFile(InputStream file) throws IOException, CsvException {
      List<String[]> records;
      try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(file))
              .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
              .build()) {
          records = csvReader.readAll();
      }
      if (records.isEmpty()) throw new EmptyCsvException("The uploaded CSV file is empty 😞.");
      if (records.get(0).length < 9) throw new EmptyCsvException("The uploaded CSV file not have sufficient headers 😞.");
      if (records.size() == 1) throw new EmptyCsvException("The uploaded CSV file not have correct sufficient columns 😞.");

      List<UserDomain> users = new ArrayList<>();
      // Start from 1 to skip header
      for (int i = 1; i < records.size(); i++) {
          String[] record = records.get(i);
          if (record.length < 9) {
              // Handle insufficient columns
              throw new EmptyCsvException("The uploaded CSV file not have correct columns 😞.");
          }

          UserDomain user = new UserDomain();
          user.setName(record[0]);
          user.setProfilePicture(record[1]);
          user.setArea(record[2]);
          user.setPortfolioUrl(record[3]);
          user.setOffice(record[4]);
          // Trim each tag to remove leading/trailing spaces
          List<String> tags = Arrays.asList(record[5].split(","));
          tags.replaceAll(String::trim);
          user.setTags(tags.toArray(String[]::new));
          user.setPosition(record[6]);
          user.setPositionNumber(record[7]);
          user.setRelationBoss(record[8].isEmpty() ? null : record[8]);

          users.add(user);
      }

      // Save all users to the repository
      // List<UserDomain> savedUsers = userRepository.saveAll(users);
      return users;
  }
}
