package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *  *
 *  * @author test
 
 */
public class ConsommationPluieDataServiceJPAImpl extends AbstracCrudServiceJPA<ConsommationPluie> implements ConsommationPluieDataService {

    public ConsommationPluieDataServiceJPAImpl(String PU) {
        super(PU);
    }

    @Override
    public List<ConsommationPluie> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<ConsommationPluie> consommationspluie = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT c FROM ConsommationPluie c WHERE c.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            consommationspluie = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return consommationspluie;
    }    
}
