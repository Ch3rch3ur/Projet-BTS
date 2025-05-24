package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author saturne
 */
public class DebitDataServiceJPAImpl extends AbstracCrudServiceJPA<Debit> implements DebitDataService {
    DebitDataServiceJPAImpl(String PU) {
        super(PU);
    }

    @Override
    public List<Debit> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<Debit> debit = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT d FROM Debit d WHERE d.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            debit = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return debit;
    }
}
