package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author joris
 */
public class ConsommationVilleDataServiceJPAImpl extends AbstracCrudServiceJPA<ConsommationVille> implements ConsommationVilleDataService {
    ConsommationVilleDataServiceJPAImpl(String PU) {
        super(PU);
    }
    
    @Override
    public List<ConsommationVille> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<ConsommationVille> consommationsVille = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT c FROM ConsommationVille c WHERE c.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            consommationsVille = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return consommationsVille;
        
    }
    
}
