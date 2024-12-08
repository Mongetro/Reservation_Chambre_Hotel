package controleur;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import metier.HotelLocal;
import metier.entities.UtilisateurEntity;

@SessionScoped
@ManagedBean(name="connect")
public class Login {
	@EJB
	private HotelLocal metier;
	 private String email;
	 private String password;
	
	public void login() throws IOException {
		FacesContext context =
		FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)
		context.getExternalContext().getRequest();
					
		try {
		request.login(email,password); 
		UtilisateurEntity ut= metier.FindOneUtilisateur(email);
		context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("/HotelWeb/faces/Page/AddBook.xhtml");  
   
		} catch (ServletException e) {
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ou mot de passe invalide",""));
		//message="Email ou mot de passe invalide";
		}
	
	}
	

	   public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void logout() throws ServletException {
			/*FacesContext context =
					FacesContext.getCurrentInstance();
					HttpServletRequest request = (HttpServletRequest)
					context.getExternalContext().getRequest();
					*/
					
				    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				    
				    
            try {
            //	request.logout();
            	ec.invalidateSession();
            	ec.redirect(ec.getRequestContextPath() + "/HotelWeb/faces/static/signin.xhtml");
    			//context.getExternalContext().redirect("/systraui/faces/static/signin.xhtml");
            	//message="Vous vous êtes deconnecté du systeme";
            	/*password=""; 
		        email="";*/
		        
	} catch (IOException e) {
			
			e.printStackTrace();
		}  
	       
	  
	    }
}
