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
import lml.snir.gestioneau.metier.entity.Consommation;
import lml.snir.gestioneau.metier.transactionel.ConsommationService;
import lml.snir.rest.server.RestException;

@Path("/ConsommationService")
@Consumes("application/json")
@Produces("application/json")
public class ConsommationServiceRESTSRVImpl {

    private final ConsommationService consService = MetierFactory.getConsommationService();

    public ConsommationServiceRESTSRVImpl() throws Exception {
    }
    
    @POST
    @Path("/")
    public Consommation add(Consommation consommation) throws Exception {
        try {
            return this.consService.add(consommation);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Consommation consommation) throws Exception {
        try {
            this.consService.remove(consommation);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Consommation consommation) throws Exception {
        try {
            this.consService.update(consommation);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Consommation> getAll() throws Exception {
        try {
            return this.consService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/getByDate/{date}")
    public List<Consommation> getByDate(@PathParam("date") Date date) throws Exception {
        try {
            return this.consService.getByDate(date);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/getLastPluie")
    public Consommation getLastConsommationPluie() throws Exception {
        try {
            return this.consService.getLastConsommationPluie();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/getLastVille")
    public Consommation getLastConsommationVille() throws Exception {
        try {
            return this.consService.getLastConsommationVille();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public Consommation getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.consService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}
 