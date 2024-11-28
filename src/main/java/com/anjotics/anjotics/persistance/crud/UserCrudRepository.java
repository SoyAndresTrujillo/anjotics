package com.anjotics.anjotics.persistance.crud;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.anjotics.anjotics.persistance.entity.User;

/**
 * The UserCrudRepository interface serves as a Data Access Object (DAO) for
 * the User entity. It leverages Spring Data JPA to provide CRUD (Create, Read,
 * Update, Delete) operations without the need for boilerplate code.
 * 
 * Dont use this interface for methods like findAll, findById, save, delete or
 * other methods by default. Use the UserRepository interface instead. Because
 * this interface is used for custom queries.
 */
public interface UserCrudRepository extends CrudRepository<User, UUID> {

}