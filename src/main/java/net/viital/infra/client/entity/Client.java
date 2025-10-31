package net.viital.infra.client.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private UUID id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private User user;

  @Column
  private String name;

  @Column
  private String idType;

  @Column
  private long idDocValue;

  @Column
  private String mobileNumber;

  @Column
  private String email;

  @Column
  private boolean isActive;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdType() {
    return idType;
  }

  public void setIdType(String idType) {
    this.idType = idType;
  }

  public long getIdDocValue() {
    return idDocValue;
  }

  public void setIdDocValue(long idDocValue) {
    this.idDocValue = idDocValue;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }
}
