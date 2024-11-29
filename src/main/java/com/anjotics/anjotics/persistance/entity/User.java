package com.anjotics.anjotics.persistance.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_user", columnDefinition = "UUID")
  private UUID idUser;

  @NotNull
  @Column(name = "id_number", unique = true)
  private Integer idNumber;

  @NotNull
  private String name;

  @NotNull
  @Column(name = "image_profile_url")
  private String imageProfileUrl;

  @NotNull
  private String area;

  @NotNull
  @Column(name = "profile_url")
  private String profileUrl;

  @NotNull
  private String office;

  private String[] tags;

  @NotNull
  @Column(name = "position_name")
  private String positionName;

  /*
   * Exception is the positionName is CEO
   */
  @Column(name = "id_parent")
  private Integer idParent;

  public UUID getIdUser() {
    return idUser;
  }

  public void setIdUser(UUID idUser) {
    this.idUser = idUser;
  }

  public Integer getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(Integer idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageProfileUrl() {
    return imageProfileUrl;
  }

  public void setImageProfileUrl(String imageProfileUrl) {
    this.imageProfileUrl = imageProfileUrl;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
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

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public Integer getIdParent() {
    return idParent;
  }

  public void setIdParent(Integer idParent) {
    if ("CEO".equals(this.positionName)) {
      this.idParent = null;
    } else {
      this.idParent = idParent;
    }
  }
}
