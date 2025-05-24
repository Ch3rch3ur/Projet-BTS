/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.transactionel.ConsommationVilleService;
import lml.snir.rest.server.RestException;

/**
 *
 * @author saturne
 */
@Path("/ConsommationVille")
@Consumes("application/json")
@Produces("application/json")
public class ConsommationVilleServiceRESTSRVImpl {
    private final ConsommationVilleService consVilleService = MetierFactory.getConsommationVilleService();
    
    public ConsommationVilleServiceRESTSRVImpl() throws Exception {
    }
    
     @POST
    @Path("/")
    public ConsommationVille add(ConsommationVille t) throws Exception {
        try {
            return this.consVilleService.add(t);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @DELETE
    @Path("/")
    public void remove(ConsommationVille consVille) throws Exception {
        try {
            this.consVilleService.remove(consVille);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @PUT
    @Path("/")
    public void update(ConsommationVille consVille) throws Exception {
        try {
            this.consVilleService.update(consVille);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/")
    public List<ConsommationVille> getAll() throws Exception {
        try {
            return this.consVilleService.getAll();
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }


    @GET
    @Path("/getByDate/{date}")
    public List<ConsommationVille> getByDate(@PathParam("date") Date date) throws Exception {
        try {
            return this.consVilleService.getByDate(date);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
    
    @GET
    @Path("/{l}")
    public ConsommationVille getById(@PathParam("l") Long l) throws Exception {
        try {
            return this.consVilleService.getById(l);
        } catch (Exception ex) {
            throw new RestException(500, ex.getMessage());
        }
    }
}
