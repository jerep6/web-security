package fr.jerep6.gruyere.persistance.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

  @Id
  @Column(name = "UTI_ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer techid;

  @Column(name = "UTI_LOGIN", nullable = false)
  private String login;

  @Column(name = "UTI_PWD", nullable = false)
  private String pwd;

  public Integer getTechid() {
    return techid;
  }

  public void setTechid(Integer techid) {
    this.techid = techid;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "Utilisateur [techid=" + techid + ", login=" + login + "]";
  }

}
