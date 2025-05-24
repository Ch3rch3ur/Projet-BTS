package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author joris
 */
public class PressionDataServiceJPAImpl extends AbstracCrudServiceJPA<Pression> implements PressionDataService {
    PressionDataServiceJPAImpl(String PU) {
        super(PU);
    }
    
    @Override
    public List<Pression> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<Pression> pression = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT p FROM Pression p WHERE p.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            pression = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return pression;
    }
    
}