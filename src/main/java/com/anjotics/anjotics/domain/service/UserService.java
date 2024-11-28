package com.anjotics.anjotics.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.repository.UserRepository;

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
}
