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
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.transactionel.MesurePompeService;
import lml.snir.rest.server.RestException;

@Path("/MesurePompe")
@Consumes("application/json")
@Produces("application/json")
public class MesurePompeServiceRESTSRVImpl {
    private final MesurePompeService mesurepompeService = MetierFactory.getMesurePompeService();
    
    public MesurePompeServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public MesurePompe add(MesurePompe mesurepompe) throws Exception {
        try {
            return this.mesurepompeService.add(mesurepompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @DELETE
    @Path("/")
    public void remove(MesurePompe mesurepompe) throws Exception {
        try {
            this.mesurepompeService.remove(mesurepompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @PUT
    @Path("/")
    public void update(MesurePompe mesurepompe) throws Exception {
        try {
            this.mesurepompeService.update(mesurepompe);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/")
    public List<MesurePompe> getAll() throws Exception {
        try {
            return this.mesurepompeService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/getByDate/{date}")
    public List<MesurePompe> getByDate(@PathParam("date") Date date) throws Exception {
        try {
            return this.mesurepompeService.getByDate(date);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/getLastTemperature")
    public MesurePompe getLastTemperature() throws Exception {
        return this.mesurepompeService.getLastTemperature();
    }

    @GET
    @Path("/getLastPression")
    public MesurePompe getLastPression() throws Exception {
        return this.mesurepompeService.getLastPression();
    }

    @GET
    @Path("/getLastDebit")
    public MesurePompe getLastDebit() throws Exception {
        return this.mesurepompeService.getLastDebit();
    }  
    
    @GET
    @Path("/{l}")
    public MesurePompe getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.mesurepompeService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}
