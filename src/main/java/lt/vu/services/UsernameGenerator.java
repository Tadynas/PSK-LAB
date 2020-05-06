package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.Serializable;

@ApplicationScoped
public class UsernameGenerator implements Serializable {

    public String generateUsername() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Client client = ClientBuilder.newClient();


        return "gerulis";
    }
}