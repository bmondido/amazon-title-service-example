package amazon;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/titles")
public class AmazonService {

	TitleDAO titleDAO = new TitleDAO();
	WishlistDAO wishlistDAO = new WishlistDAO();
	UserDAO userDAO = new UserDAO();
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Title> getTitles( @FormParam("filter") List<String> filter, @FormParam("sort") List<String> sortBy) {
		//if anything happens at the dao layer (database unavailable, the DAO itself should be doing some error reporting
		//it depends on how we want to implement error handling. 
		return titleDAO.find(filter,sortBy);
		
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Title getTitle(@PathParam("id") int id, @QueryParam("sort") List<String> sortBy){
		return titleDAO.findById(id, sortBy);
	}
	
	@POST @Path("{id}/wishlist/{action}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void wishlist(@PathParam("id") int id, @FormParam("userId") int userId, @QueryParam("action") String action){
		User u = userDAO.getUser(userId);
		
		if(u != null){
			if(action.equals("add")){
				wishlistDAO.addBook(userId, id);
			} else if(action.equals("remove")){
				wishlistDAO.removeBook(userId, id);
			}
		} else {
			//report error in logs and to user
		}
		 
	}
	
	@POST @Path("/wishlist")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Wishlist getUserWishlist(@FormParam("userId") int userId){
		return wishlistDAO.getWishlistForUser(userId);
	}
}
