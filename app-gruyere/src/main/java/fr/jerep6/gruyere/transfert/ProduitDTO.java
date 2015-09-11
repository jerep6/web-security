package fr.jerep6.gruyere.transfert;

public class ProduitDTO {
  private Integer techid;
  private String titre;
  private String description;
  private String prix;
  private String image;

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
