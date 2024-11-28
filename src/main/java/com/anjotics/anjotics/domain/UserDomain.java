package com.anjotics.anjotics.domain;

import java.util.UUID;

public class UserDomain {
  private UUID idUser;
  private Integer positionNumber;
  private String name;
  private String profilePicture;
  private String area;
  private String portfolioUrl;
  private String office;
  private String[] tags;
  private String position;
  private Integer relationBoss;

  public UUID getIdUser() {
    return idUser;
  }

  public void setIdUser(UUID idUser) {
    this.idUser = idUser;
  }

  public Integer getPositionNumber() {
    return positionNumber;
  }

  public void setPositionNumber(Integer positionNumber) {
    this.positionNumber = positionNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getPortfolioUrl() {
    return portfolioUrl;
  }

  public void setPortfolioUrl(String portfolioUrl) {
    this.portfolioUrl = portfolioUrl;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getRelationBoss() {
    return relationBoss;
  }

  public void setRelationBoss(Integer relationBoss) {
    this.relationBoss = relationBoss;
  }
}
