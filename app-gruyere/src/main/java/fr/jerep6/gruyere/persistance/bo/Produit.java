package fr.jerep6.gruyere.persistance.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class Produit {

  @Id
  @Column(name = "PRD_ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer techid;

  @Column(name = "PRD_TITRE", nullable = false)
  private String titre;

  @Column(name = "PRD_DESCRIPTION", nullable = false)
  private String description;

  @Column(name = "PRD_PRIX", nullable = false)
  private String prix;

  @Column(name = "PRD_IMAGE", nullable = false)
  private String image;

  @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
  @OrderBy("techid ASC")
  private Set<Commentaire> commentaires = new HashSet<>(0);

  @OneToOne(optional = false)
  @JoinColumn(name = "UTI_ID")
  private Utilisateur proprietaire;

  public Utilisateur getProprietaire() {
    return proprietaire;
  }

  public void setProprietaire(Utilisateur proprietaire) {
    this.proprietaire = proprietaire;
  }

  public Set<Commentaire> getCommentaires() {
    return commentaires;
  }

  public void setCommentaires(Set<Commentaire> commentaires) {
    this.commentaires = commentaires;
  }

  public Integer getTechid() {
    return techid;
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

  public void setTechid(Integer techid) {
    this.techid = techid;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  @Override
  public String toString() {
    return "Produit [techid=" + techid + ", titre=" + titre + "]";
  }

}
