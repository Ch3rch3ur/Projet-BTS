
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
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.transactionel.PressionService;
import lml.snir.rest.server.RestException;

@Path("/Pression")
@Consumes("application/json")
@Produces("application/json")
public class PressionServiceRESTSRVImpl {
    private final PressionService pressionService = MetierFactory.getPressionService();
    
    public PressionServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public Pression add(Pression pression) throws Exception {
        try {
            return this.pressionService.add(pression);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Pression pression) throws Exception {
        try {
            this.pressionService.remove(pression);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Pression pression) throws Exception {
        try {
            this.pressionService.update(pression);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Pression> getAll() throws Exception {
        try {
            return this.pressionService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/{l}")
    public Pression getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.pressionService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

}
