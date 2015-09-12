package fr.jerep6.gruyere.transfert;

public class CommentaireDTO {
  private Integer techid;
  private String contenu;
  private Integer utilisateurId;
  private String utilisateurLogin;

  public CommentaireDTO(Integer techid, String contenu, Integer utilisateurId,
      String utilisateurLogin) {
    super();
    this.techid = techid;
    this.contenu = contenu;
    this.utilisateurId = utilisateurId;
    this.utilisateurLogin = utilisateurLogin;
  }

  public Integer getTechid() {
    return techid;
  }

  public void setTechid(Integer techid) {
    this.techid = techid;
  }

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public String getUtilisateurLogin() {
    return utilisateurLogin;
  }

  public void setUtilisateurLogin(String utilisateurLogin) {
    this.utilisateurLogin = utilisateurLogin;
  }

}
