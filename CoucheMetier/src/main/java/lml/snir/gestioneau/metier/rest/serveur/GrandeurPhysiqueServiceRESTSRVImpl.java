
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
import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.gestioneau.metier.transactionel.GrandeurPhysiqueService;
import lml.snir.rest.server.RestException;

@Path("/GrandeurPhysique")
@Consumes("application/json")
@Produces("application/json")
public class GrandeurPhysiqueServiceRESTSRVImpl {
    private final GrandeurPhysiqueService gphysiqueService = MetierFactory.getGrandeurPhysiqueService();
    
    public GrandeurPhysiqueServiceRESTSRVImpl() throws Exception {
    }
    
    @POST
    @Path("/")
    public GrandeurPhysique add(GrandeurPhysique grandeurphysique) throws Exception {
        try {
            return this.gphysiqueService.add(grandeurphysique);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(GrandeurPhysique grandeurphysique) throws Exception {
        try {
            this.gphysiqueService.remove(grandeurphysique);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(GrandeurPhysique grandeurphysique) throws Exception {
        try {
            this.gphysiqueService.update(grandeurphysique);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<GrandeurPhysique> getAll() throws Exception {
        try {
            return this.gphysiqueService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/{l}")
    public GrandeurPhysique getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.gphysiqueService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

}
