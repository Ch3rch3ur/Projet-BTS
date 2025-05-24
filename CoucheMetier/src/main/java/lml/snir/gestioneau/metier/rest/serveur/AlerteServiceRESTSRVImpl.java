package lml.snir.gestioneau.metier.rest.serveur;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import lml.snir.gestioneau.metier.AlerteService;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.Alerte;
import lml.snir.rest.server.RestException;

/**
 *
 * @author saturne
 */
@Path("/Alerte")
@Consumes("application/json")
@Produces("application/json")
public class AlerteServiceRESTSRVImpl {

    private final AlerteService alerteService = MetierFactory.getAlerteService();
    
    @POST
    @Path("/")
    public void add(String alerte) throws Exception {
        try {
            this.alerteService.add(Alerte.valueOf(alerte));
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/getLast")
    public String getLast(/*@QueryParam("token") String token*/) {
        try {
            return this.alerteService.getLast().toString();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}

