package amazon;

public class WishlistDAO {
	public void addBook(int userId, int id){
		Wishlist w = getWishlistForUser(userId);
		boolean exists = false;
		for (Title title : w.getTitles()) {
			if(title.getId() == id){
				exists = true;
			}
		}
		if(!exists){
		//	make the update to the database to add the book
		} else {
			//report title already exists in wishlist
		}
	}
	
	//same as add book code wise but business logic dictates separation
	public void removeBook(int userId, int id){
		Wishlist w = getWishlistForUser(userId);
		
		boolean exists = false;
		
		for (Title title : w.getTitles()) {
			if(title.getId() == id){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//make the update to the database to remove book from wishlist
		} else{
			//report error that an attempt was made to remove a non-existent book
		}
	}
	
	public Wishlist getWishlistForUser(int userId){
		//call database for wishlist based on userId
		//report database availability errors 
		return null;
	}
}
