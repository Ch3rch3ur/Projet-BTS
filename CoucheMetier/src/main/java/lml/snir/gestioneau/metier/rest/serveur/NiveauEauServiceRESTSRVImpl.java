
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
import lml.snir.gestioneau.metier.entity.NiveauEau;
import lml.snir.gestioneau.metier.transactionel.NiveauEauService;
import lml.snir.rest.server.RestException;


@Path("/NiveauEau")
@Consumes("application/json")
@Produces("application/json")
public class NiveauEauServiceRESTSRVImpl {
    private final NiveauEauService niveaueauService = MetierFactory.getNiveauEauService();
    
    public NiveauEauServiceRESTSRVImpl() throws Exception {
    }
    
    @POST
    @Path("/")
    public NiveauEau add(NiveauEau niveaueau) throws Exception {
        try {
            return this.niveaueauService.add(niveaueau);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(NiveauEau niveaueau) throws Exception {
        try {
            this.niveaueauService.remove(niveaueau);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(NiveauEau niveaueau) throws Exception {
        try {
            this.niveaueauService.update(niveaueau);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<NiveauEau> getAll() throws Exception {
        try {
            return this.niveaueauService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


   
    @GET
    @Path("/getLastNiveauEau")
    public NiveauEau getLastNiveauEau() throws Exception {
        try {
            return this.niveaueauService.getLast();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public NiveauEau getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.niveaueauService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
}
