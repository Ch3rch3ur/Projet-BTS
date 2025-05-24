package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.NiveauEau;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author joris
 */
public class NiveauEauDataServiceJPAImpl extends AbstracCrudServiceJPA<NiveauEau> implements NiveauEauDataService {

    NiveauEauDataServiceJPAImpl(String PU) {
        super(PU);
    }

    @Override
    public List<NiveauEau> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<NiveauEau> niveauEau = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT niveauEau FROM NiveauEau niveauEau WHERE niveauEau.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            niveauEau = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return niveauEau;
    }

    @Override
public NiveauEau getLast() throws Exception {
    NiveauEau niveauEau = null;

    try {
        this.open();
        // Requête JPQL pour obtenir le dernier NiveauEau
        Query query = em.createQuery("SELECT n FROM NiveauEau n ORDER BY n.date DESC");
        query.setMaxResults(1); // Limiter à un seul résultat

        // Récupérer les résultats
        List<NiveauEau> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            System.out.println("Aucun résultat trouvé");
        } else {
            System.out.println("Dernière Niveau d'Eau : " + resultList.get(0));
        }

        // Si un résultat est trouvé, récupérer le premier
        if (!resultList.isEmpty()) {
            niveauEau = resultList.get(0);
        }
    } catch (NoResultException ex) {
        System.out.println("Aucun Niveau d'Eau trouvé : " + ex.getMessage());
        return null; // Aucun résultat trouvé
    } finally {
        this.close();
    }

    return niveauEau; // Retourner l'objet NiveauEau
}

}
