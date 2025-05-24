package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author saturne
 */
public class TemperatureDataServiceJPAImpl extends AbstracCrudServiceJPA<Temperature> implements TemperatureDataService {
    TemperatureDataServiceJPAImpl(String PU) {
        super(PU);
    }

    @Override
    public List<Temperature> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<Temperature> temperature = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT t FROM Temperature t WHERE t.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            temperature = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return temperature;
    }
}
