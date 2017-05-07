import com.telerivet.*;
import java.io.IOException;

public class Test 
{    
    public static void main(String[] args) throws IOException {
   
        String API_KEY = "up426oENT4Tl3byVHGlECkEbuXUdpGTi";  // from https://telerivet.com/api/keys
        String PROJECT_ID = "PJ2e156d5ed55bf62e";

        TelerivetAPI tr = new TelerivetAPI(API_KEY);

        Project project = tr.initProjectById(PROJECT_ID);

        // Import a contact
        Contact contact = project.getOrCreateContact(Util.options(
            "name", "John Smith",
            "phone_number", "555-0001",
            "vars", Util.options(
                "birthdate", "1981-03-04",
                "network", "Vodacom"
            )
        ));
        
        // Add a contact to a group    
        Group group = project.getOrCreateGroup("Subscribers");
        contact.addToGroup(group);
    }
}