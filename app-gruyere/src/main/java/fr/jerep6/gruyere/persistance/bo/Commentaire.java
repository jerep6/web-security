package fr.jerep6.gruyere.persistance.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTAIRE")
public class Commentaire {

  @Id
  @Column(name = "COM_ID", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer techid;

  @Column(name = "COM_CONTENU", nullable = false)
  private String contenu;

  @ManyToOne
  @JoinColumn(name = "PRD_ID", nullable = false)
  private Produit produit;

  @ManyToOne
  @JoinColumn(name = "UTI_ID", nullable = false)
  private Utilisateur utilisateur;

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

  public Produit getProduit() {
    return produit;
  }

  public void setProduit(Produit produit) {
    this.produit = produit;
  }

  @Override
  public String toString() {
    return "Produit [techid=" + techid + ", contenu=" + contenu + "]";
  }

}
