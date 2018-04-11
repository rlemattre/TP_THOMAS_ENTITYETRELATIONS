/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author romua
 */
@Entity
//@Table(name="movie") // permet de changer le nom de la table
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany(mappedBy="filmsRealises")
    private List<Personne> realisateurs = new ArrayList<>();
    
    @ManyToMany(mappedBy="filmsInterpretes")
    private List<Personne> acteurs = new ArrayList<>();
       
    @Column(nullable = false, length=35, unique = true)
    private String titre;
    
    @Column(length = 4000)
    private String synopsis;
    
    @Column(nullable = false)
    private int anneeDeProduction;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSortie;
    
    @OneToMany(mappedBy = "film") // fait référence à la variable film de l'entité qui contient la clé étrangère
    private List<Lien> liens = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="pays_id")
    private Pays pays;
    
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;
    
    public Long getId() {
        return id;
    }

    public int getAnneeDeProduction() {
        return anneeDeProduction;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitre() {
        return titre;
    }

    public String getSynopsis() {
        return synopsis;
    }
    
    public Date getDateSortie () {
        return dateSortie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAnneeDeProduction(int anneeDeProduction) {
        this.anneeDeProduction = anneeDeProduction;
    }
    
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "streaming.entity.Film[ id=" + id + " ]";
    }
    
}
