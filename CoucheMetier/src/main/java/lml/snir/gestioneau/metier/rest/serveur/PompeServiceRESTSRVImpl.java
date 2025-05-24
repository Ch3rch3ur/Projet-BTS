
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
import lml.snir.gestioneau.metier.entity.Pompe;
import lml.snir.gestioneau.metier.transactionel.PompeService;
import lml.snir.rest.server.RestException;


@Path("/Pompe")
@Consumes("application/json")
@Produces("application/json")
public class PompeServiceRESTSRVImpl {
    private final PompeService pompeService = MetierFactory.getPompeService();
    
    public PompeServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public Pompe add(Pompe pompe) throws Exception {
        try {
            return this.pompeService.add(pompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Pompe pompe) throws Exception {
        try {
            this.pompeService.remove(pompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Pompe pompe) throws Exception {
        try {
            this.pompeService.update(pompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Pompe> getAll() throws Exception {
        try {
            return this.pompeService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/{l}")
    public Pompe getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.pompeService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


}
