package com.anjotics.anjotics.domain.repository;

import java.util.List;

import com.anjotics.anjotics.domain.UserDomain;

/**
 * This interface is used to define the methods that will be implemented by the
 * UserRepositoryImplementation class.
 */
public interface UserRepository {
  List<UserDomain> getAll();
}
