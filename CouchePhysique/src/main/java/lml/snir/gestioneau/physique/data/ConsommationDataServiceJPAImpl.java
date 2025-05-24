package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.Consommation;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
import lml.snir.tools.DateConverter;

/**
 *
 * @author joris
 */
public class ConsommationDataServiceJPAImpl extends AbstracCrudServiceJPA<Consommation> implements ConsommationDataService {

    ConsommationDataServiceJPAImpl(String PU) {
        super(PU);
    }

    @Override
    public List<Consommation> getByDate(Date date) throws Exception {
        String strDate = DateConverter.formatDate(date)+"%";
        List<Consommation> consommations = null;

        try {
            this.open();
            Query query = em.createQuery("SELECT c FROM Consommation c WHERE c.date LIKE :fdate");
            query.setParameter("fdate", strDate);
            consommations = query.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            this.close();
        }
        return consommations;
    }

    @Override
    public ConsommationPluie getLastConsommationPluie() throws Exception {
        ConsommationPluie consommation = null;

        try {
            this.open();
            // Requête JPQL sans LIMIT
            Query query = em.createQuery("SELECT c FROM Consommation c WHERE TYPE(c) = :fclass ORDER BY c.date DESC");
            query.setParameter("fclass", ConsommationPluie.class);
            query.setMaxResults(1); // Limiter à un seul résultat

            // Vérification des résultats
            List<ConsommationPluie> resultList = query.getResultList();
            if (resultList.isEmpty()) {
                System.out.println("Aucun résultat trouvé");
            } else {
                System.out.println("Dernière ConsommationPluie trouvé : " + resultList.get(0));
            }

            // Si un résultat est trouvé, récupérer le premier (car on a limité à 1)
            if (!resultList.isEmpty()) {
                consommation = resultList.get(0);
            }
        } catch (NoResultException ex) {
            System.out.println("Aucune ConsommationPluie trouvé : " + ex.getMessage());
            return null; // Aucun résultat trouvé
        } finally {
            this.close();
        }

        return consommation; // Retourner l'objet ConsommationPluie
    }

    @Override
    public ConsommationVille getLastConsommationVille() throws Exception {
        ConsommationVille consommation = null;

        try {
            this.open();
            // Requête JPQL pour ConsommationVille
            Query query = em.createQuery("SELECT c FROM Consommation c WHERE TYPE(c) = :fclass ORDER BY c.date DESC");
            query.setParameter("fclass", ConsommationVille.class);
            query.setMaxResults(1); // Limiter à un seul résultat

            // Récupérer les résultats
            List<ConsommationVille> resultList = query.getResultList();
            if (resultList.isEmpty()) {
                System.out.println("Aucun résultat trouvé");
            } else {
                System.out.println("Dernière ConsommationVille : " + resultList.get(0));
            }

            // Si un résultat est trouvé, récupérer le premier
            if (!resultList.isEmpty()) {
                consommation = resultList.get(0);
            }
        } catch (NoResultException ex) {
            System.out.println("Aucune ConsommationVille trouvé : " + ex.getMessage());
            return null; // Aucun résultat trouvé
        } finally {
            this.close();
        }

        return consommation; // Retourner l'objet ConsommationVille
    }

}
