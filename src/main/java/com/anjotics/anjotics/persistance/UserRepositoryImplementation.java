package com.anjotics.anjotics.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.domain.repository.UserRepository;
import com.anjotics.anjotics.persistance.crud.UserCrudRepository;
import com.anjotics.anjotics.persistance.entity.User;
import com.anjotics.anjotics.persistance.mapper.UserMapper;

/**
 * This class is the implementation of the UserRepository interface.
 */
@Repository
public class UserRepositoryImplementation implements UserRepository {
  /**
   * This is the UserCrudRepository instance that is used to perform CRUD
   * operations on the User entity. (implementation for interface)
   */
  @Autowired
  private UserCrudRepository userCrudRepository;

  /**
   * When a component or beans from spring then it is @Autowired is requiered.
   */
  @Autowired
  private UserMapper mapper;

  /**
   * This method is used to get all users from the database.
   * 
   * @return List<UserDomain>
   */
  @Override
  public List<UserDomain> getAll() {
    return mapper.userEntityToDomain((List<User>) userCrudRepository.findAll());
  }
}
