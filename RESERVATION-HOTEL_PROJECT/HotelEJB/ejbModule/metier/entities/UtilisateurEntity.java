/**
 * 
 */
package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_Utilisateur")
public class UtilisateurEntity implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@Column(name="Utilisateur_email")
private String UtilisateurEmail;
@Column(name="Utilisateur_motdepasse")
private String UtilisateurMotdepasse;
@Column(name="Utilisateur_etatcompte")
private String UtilisateurEtatcompte;
@OneToOne(mappedBy="user")
private UserRole iDuserRole;
@Temporal(TemporalType.TIMESTAMP)
private Date dateCreation;


public UtilisateurEntity(String utilisateurEmail) {
	super();
	UtilisateurEmail = utilisateurEmail;
}
public UtilisateurEntity(String utilisateurEmail, String utilisateurMotdepasse, String utilisateurEtatcompte,
		Date dateCreation) {
	super();
	UtilisateurEmail = utilisateurEmail;
	UtilisateurMotdepasse = utilisateurMotdepasse;
	UtilisateurEtatcompte = utilisateurEtatcompte;
	this.dateCreation = dateCreation;
}
public UtilisateurEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public UserRole getiDuserRole() {
	return iDuserRole;
}
public void setiDuserRole(UserRole iDuserRole) {
	this.iDuserRole = iDuserRole;
}
/**
 * @return the utilisateurId
 */
public String getUtilisateurEmail() {
	return UtilisateurEmail;
}
/**
 * @param utilisateurId the utilisateurId to set
 */
public void setUtilisateurEmail(String utilisateurId) {
	UtilisateurEmail = utilisateurId;
}


public String getUtilisateurMotdepasse() {
	return UtilisateurMotdepasse;
}
/**
 * @param utilisateurMotdepasse the utilisateurMotdepasse to set
 */
public void setUtilisateurMotdepasse(String utilisateurMotdepasse) {
	UtilisateurMotdepasse = utilisateurMotdepasse;
}
/**
 * @return the utilisateurEtatcompte
 */
public String getUtilisateurEtatcompte() {
	return UtilisateurEtatcompte;
}
/**
 * @param utilisateurEtatcompte the utilisateurEtatcompte to set
 */
public void setUtilisateurEtatcompte(String utilisateurEtatcompte) {
	UtilisateurEtatcompte = utilisateurEtatcompte;
}



}