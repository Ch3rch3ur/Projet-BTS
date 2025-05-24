
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
import lml.snir.gestioneau.metier.entity.Cuve;
import lml.snir.gestioneau.metier.transactionel.CuveService;
import lml.snir.rest.server.RestException;

@Path("/Cuve")
@Consumes("application/json")
@Produces("application/json")
public class CuveServiceRESTSRVImpl {
    private final CuveService cuveService = MetierFactory.getCuveService();
    
    public CuveServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public Cuve add(Cuve cuve) throws Exception {
        try {
            return this.cuveService.add(cuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Cuve cuve) throws Exception {
        try {
            this.cuveService.remove(cuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Cuve cuve) throws Exception {
        try {
            this.cuveService.update(cuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Cuve> getAll() throws Exception {
        try {
            return this.cuveService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public Cuve getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.cuveService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
}
