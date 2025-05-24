package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Consommation;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.transactionel.ConsommationService;
import lml.snir.gestioneau.physique.data.ConsommationDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class ConsommationServiceImpl implements ConsommationService {

    private final ConsommationDataService consSrv;

    public ConsommationServiceImpl() throws Exception {
        consSrv = PhysiqueDataFactory.getConsommationDataService();
    }

    @Override
    public List<Consommation> getByDate(Date date) throws Exception {
        return this.consSrv.getByDate(date);
    }

    @Override
    public Consommation add(Consommation t) throws Exception {
        try {
            return this.consSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Consommation est déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Consommation t) throws Exception {
        this.consSrv.remove(t);
    }

    @Override
    public void update(Consommation t) throws Exception {
        this.consSrv.remove(t);
    }

    @Override
    public Consommation getById(Long l) throws Exception {
        return this.consSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.consSrv.getCount();
    }

    @Override
    public List<Consommation> getAll() throws Exception {
        return this.consSrv.getAll();
    }

    @Override
    public List<Consommation> getAll(int i, int i1) throws Exception {
        return this.consSrv.getAll(i, i1);
    }

    @Override
    public ConsommationPluie getLastConsommationPluie() throws Exception {
        return this.consSrv.getLastConsommationPluie();
    }

    @Override
    public ConsommationVille getLastConsommationVille() throws Exception {
        return this.consSrv.getLastConsommationVille();
    }

}
