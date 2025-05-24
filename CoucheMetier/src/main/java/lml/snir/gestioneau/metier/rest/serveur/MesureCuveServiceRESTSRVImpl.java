
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
import lml.snir.gestioneau.metier.entity.MesureCuve;
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.transactionel.MesureCuveService;
import lml.snir.rest.server.RestException;

@Path("/MesureCuve")
@Consumes("application/json")
@Produces("application/json")
public class MesureCuveServiceRESTSRVImpl {
    private final MesureCuveService mesurecuveService = MetierFactory.getMesureCuveService();
    
    public MesureCuveServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public MesureCuve add(MesureCuve mesurecuve) throws Exception {
        try {
            return this.mesurecuveService.add(mesurecuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(MesureCuve mesurecuve) throws Exception {
        try {
            this.mesurecuveService.remove(mesurecuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(MesureCuve mesurecuve) throws Exception {
        try {
            this.mesurecuveService.update(mesurecuve);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<MesureCuve> getAll() throws Exception {
        try {
            return this.mesurecuveService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/getByDate/{date}")
    public List<MesureCuve> getByDate(@PathParam("date") Date date) throws Exception {
        try {
            return this.mesurecuveService.getByDate(date);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/getLastTemperature")
    public MesureCuve getLastTemperature() throws Exception {
        return this.mesurecuveService.getLastTemperature();
    }
    
    @GET
    @Path("/{l}")
    public MesureCuve getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.mesurecuveService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}