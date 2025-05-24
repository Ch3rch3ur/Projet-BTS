
package lml.snir.gestioneau.metier.rest.serveur;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.transactionel.TemperatureService;
import lml.snir.rest.server.RestException;

@Path("/Temperature")
@Consumes("application/json")
@Produces("application/json")
public class TemperatureServiceRESTSRVImpl {
    private final TemperatureService tempService = MetierFactory.getTemperatureService();
    
    public TemperatureServiceRESTSRVImpl() throws Exception {
    }
    
    @POST
    @Path("/")
    public Temperature add(Temperature temperature) throws Exception {
        try {
            return this.tempService.add(temperature);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Temperature temperature) throws Exception {
        try {
            this.tempService.remove(temperature);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Temperature temperature) throws Exception {
        try {
            this.tempService.update(temperature);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Temperature> getAll() throws Exception {
        try {
            return this.tempService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public Temperature getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.tempService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
}
