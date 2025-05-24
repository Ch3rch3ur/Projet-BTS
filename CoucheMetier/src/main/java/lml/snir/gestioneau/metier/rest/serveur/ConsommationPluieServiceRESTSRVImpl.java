package lml.snir.gestioneau.metier.rest.serveur;

import java.util.Date;
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
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.transactionel.ConsommationPluieService;
import lml.snir.rest.server.RestException;

@Path("/ConsommationPluie")
@Consumes("application/json")
@Produces("application/json")
public class ConsommationPluieServiceRESTSRVImpl {
    private final ConsommationPluieService consPluieService = MetierFactory.getConsommationPluieService();
    
    public ConsommationPluieServiceRESTSRVImpl() throws Exception {
    }
    
    @POST
    @Path("/")
    public ConsommationPluie add(ConsommationPluie t) throws Exception {
        try {
            return this.consPluieService.add(t);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @DELETE
    @Path("/")
    public void remove(ConsommationPluie consPluie) throws Exception {
        try {
            this.consPluieService.remove(consPluie);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @PUT
    @Path("/")
    public void update(ConsommationPluie consPluie) throws Exception {
        try {
            this.consPluieService.update(consPluie);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/")
    public List<ConsommationPluie> getAll() throws Exception {
        try {
            return this.consPluieService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/getByDate/{date}")
    public List<ConsommationPluie> getByDate(@PathParam("date") Date date) throws Exception {
        try {
            return this.consPluieService.getByDate(date);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public ConsommationPluie getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.consPluieService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}
