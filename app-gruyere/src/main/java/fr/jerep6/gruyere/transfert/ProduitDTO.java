package fr.jerep6.gruyere.transfert;

import java.util.ArrayList;
import java.util.List;

public class ProduitDTO {
  private Integer techid;
  private String titre;
  private String description;
  private String prix;
  private String image;
  private String categorie;
  private Integer utilisateurId;
  private String utilisateurLogin;

  private List<CommentaireDTO> commentaires = new ArrayList<>();

  public ProduitDTO() {}

  public ProduitDTO(Integer techid, String titre, String description, Float prix, String image,
      String categorie, Integer utilisateurId, String utilisateurLogin) {
    super();
    this.techid = techid;
    this.titre = titre;
    this.description = description;
    this.prix = prix.toString();
    this.image = image;
    this.categorie = categorie;
    this.utilisateurId = utilisateurId;
    this.utilisateurLogin = utilisateurLogin;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((techid == null) ? 0 : techid.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ProduitDTO other = (ProduitDTO) obj;
    if (techid == null) {
      if (other.techid != null) return false;
    }
    else if (!techid.equals(other.techid)) return false;
    return true;
  }

  public List<CommentaireDTO> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(List<CommentaireDTO> commentaires) {
    this.commentaires = commentaires;
  }

  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
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

  @Override
  public String toString() {
    return "ProduitDTO [techid=" + techid + ", titre=" + titre + "]";
  }

  public Integer getTechid() {
    return techid;
  }

  public void setTechid(Integer techid) {
    this.techid = techid;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPrix() {
    return prix;
  }

  public void setPrix(String prix) {
    this.prix = prix;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

}
