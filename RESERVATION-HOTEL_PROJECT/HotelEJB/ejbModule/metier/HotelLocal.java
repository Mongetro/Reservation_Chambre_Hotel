package metier;

import java.util.List;
import javax.ejb.Local;

import metier.entities.UserRole;
import metier.entities.UtilisateurEntity;
import metier.entities.Booking;
import metier.entities.Room;

@Local
public interface HotelLocal {

	//services for Room interface 	
		public void addRoom (Room rm);
		public Room getRoom (int idRoom); 
		public void updateRoom (Room rm);
		public List<Room> listRooms();
		public List<Room> listRooms(String etat);
		public void deleteRoom (int idRoom);
		
	//services for Booking interface 	
		public void addBook (Booking bk);
		public Booking getBook (Long idBook); 
		public void updateBook (Booking bk);
		public List<Booking> listBooks();
		public List<Booking> listBooks(String guestName);
		
		
		//Service Utilisateur
		public void AddUtilisateur(UtilisateurEntity u,UserRole ur);
		public void UpdateUtilisateur(UtilisateurEntity u);
		public UtilisateurEntity FindOneUtilisateur(String id);
		public UtilisateurEntity FindOneUtilisateurBy(String MC);
		public List<UtilisateurEntity> GetAllUtilisateur();
		public void DeleteUtilisateur(String id);
	
}
