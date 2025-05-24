
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
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.transactionel.DebitService;
import lml.snir.rest.server.RestException;

@Path("/Debit")
@Consumes("application/json")
@Produces("application/json")
public class DebitServiceRESTSRVImpl {
    private final DebitService debitService = MetierFactory.getDebitService();
    
    public DebitServiceRESTSRVImpl() throws Exception {
    }
     @POST
    @Path("/")
    public Debit add(Debit debit) throws Exception {
        try {
            return this.debitService.add(debit);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(Debit debit) throws Exception {
        try {
            this.debitService.remove(debit);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(Debit debit) throws Exception {
        try {
            this.debitService.update(debit);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<Debit> getAll() throws Exception {
        try {
            return this.debitService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    @GET
    @Path("/{l}")
    public Debit getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.debitService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }

    
}
