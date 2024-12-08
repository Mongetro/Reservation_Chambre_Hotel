package controleur;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import metier.HotelLocal;
import metier.entities.Room;

@ManagedBean(name="RoomMB")
@RequestScoped
public class ControleurRoom {

	private static final long serialVersionUID = 1L;
	@EJB
	private HotelLocal metier;
	private int idRoom;
	private int nbOfBeds;
	private double pricePerNight;
	private String etat;

	public String getEtat() {
	return etat;
}

public void setEtat(String etat) {
	this.etat = etat;
}
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom=idRoom;
	}

	public int getNbOfBeds() {
		return nbOfBeds;
	}
	public void setNbOfBeds(int nbOfBeds) {
		this.nbOfBeds = nbOfBeds;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	
	public String addRoom(){
	/*if(idRoom==0 && nbOfBeds==0 && pricePerNight==0){  
		
	}	else{*/
		try{
			
		
	Room r=new Room(nbOfBeds, pricePerNight, "Disponible");	
	metier.addRoom(r);
	FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Nouvelle chambre ajoutee avec succes","");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'ajout d'une nouvelle chambre","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}	
	//}
		
	return"success";	
	}
	
	public String getRoom(){
		int idroom=Integer.parseInt(getParam());
		Room r=metier.getRoom(idroom);
		idRoom=r.getIdRoom();
		etat=r.getEtat();
		nbOfBeds=r.getNbOfBeds();
		pricePerNight=r.getPricePerNight();
		return"";
	}
	
	
	public String updateRoom(){
		
		try{
			
		
	Room r=new Room(idRoom,nbOfBeds, pricePerNight, "Disponible");	
	metier.updateRoom(r);
	FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Chambre modifiee avec succes","");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification de la chambre","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}
	return"";	
	}
	
	public String getParam()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String idRoom= param.get("idRoom");
		return idRoom; 
	 }
	
	
	public List<Room> getRooms(){
		return metier.listRooms("Disponible");
		}
	
	public List<Room> listerRooms(){
		return metier.listRooms();
		}
}
		
