package controleur;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import metier.HotelLocal;
import metier.entities.Booking;
import metier.entities.Room;

@ManagedBean(name="BookMB")
@RequestScoped
public class ControleurBook {

	private static final long serialVersionUID = 1L;
	@EJB
	private HotelLocal metier;
	private String firstame;
	private String lastname;
    private Date startDate;
    private Date endDate;   
	private int idRoom; 
	private int room;
	private double price;
	private Long idBook;


	public Long getIdBook() {
		return idBook;
	}


	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}


	public int getRoom() {
		return room;
	}


	public void setRoom(int room) {
		this.room = room;
	}

	public HotelLocal getMetier() {
		return metier;
	}

	public void setMetier(HotelLocal metier) {
		this.metier = metier;
	}

	public String getFirstame() {
		return firstame;
	}

	public void setFirstame(String firstame) {
		this.firstame = firstame;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String addBooking(){
	/*if(idRoom==0 && nbOfBeds==0 && pricePerNight==0){  
		
	}	else{*/
		try{
			System.out.println("Chambre:"+room);
		Booking b=new Booking(firstame, lastname, startDate, endDate,  price, new Room(room));
	metier.addBook(b);
	
	FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Nouvelle Réservation ajoutee avec succes","");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec d'ajout d'une nouvelle Réservation","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}	
	//}
		
	return"success";	
	}
	
	public List<Booking> listerBook(){
	return metier.listBooks("Disponible");
	}
	public String getParam()
	 {
	FacesContext fc= FacesContext.getCurrentInstance();
	Map<String, String> param= fc.getExternalContext().getRequestParameterMap();
	String idBook= param.get("idBook");
		return idBook; 
	 }
	
	public List<Booking>lister(){	
	return metier.listBooks();	
	}
	
	public String getBook(){
		Long idBk=Long.parseLong(getParam());
		Booking b=metier.getBook(idBk);
		idBook=b.getIdBook();
		firstame=b.getFirstname();
		lastname=b.getLastname();
		endDate=b.getEndDate();
		startDate=b.getStartDate();
		room=b.getRoom().getIdRoom();
		return"success";
	}
	public String updateBooking(){
	/*if(idRoom==0 && nbOfBeds==0 && pricePerNight==0){  
		
	}	else{*/
		try{
			System.out.println("Chambre:"+room);
		Booking b=new Booking(idBook,firstame, lastname, startDate, endDate,  price, new Room(room));
	metier.updateBook(b);
	
	FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_INFO,"Réservation modifiee avec succes","");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	
		}catch(Exception e){
			
			FacesMessage msg  =new FacesMessage(FacesMessage.SEVERITY_ERROR,"Echec de modification de cette Réservation","");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		}	
	//}
		
	return"success";	
	}
	
	public List<Room> getRooms(){
		return metier.listRooms("Disponible");
		}
}
		
