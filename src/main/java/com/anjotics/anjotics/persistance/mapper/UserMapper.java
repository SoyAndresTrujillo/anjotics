package com.anjotics.anjotics.persistance.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.anjotics.anjotics.domain.UserDomain;
import com.anjotics.anjotics.persistance.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  /**
   * This method is used to map the User entity to the UserDomain.
   * 
   * @param userEntity
   * @return UserDomain
   */
  @Mappings({
          @Mapping(source = "idUser", target = "idUser"),
          @Mapping(source = "idNumber", target = "positionNumber"),
          @Mapping(source = "name", target = "name"),
          @Mapping(source = "imageProfileUrl", target = "profilePicture"),
          @Mapping(source = "area", target = "area"),
          @Mapping(source = "profileUrl", target = "portfolioUrl"),
          @Mapping(source = "office", target = "office"),
          @Mapping(source = "tags", target = "tags"),
          @Mapping(source = "positionName", target = "position"),
          @Mapping(source = "idParent", target = "relationBoss")
  })
  UserDomain userEntityToDomain(User userEntity);

  List<UserDomain> userEntityToDomain(List<User> userEntities);
}
