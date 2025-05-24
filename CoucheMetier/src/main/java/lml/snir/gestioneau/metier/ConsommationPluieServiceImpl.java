package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.transactionel.ConsommationPluieService;
import lml.snir.gestioneau.physique.data.ConsommationPluieDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class ConsommationPluieServiceImpl implements ConsommationPluieService {
    private final ConsommationPluieDataService consPluieSrv;
    
    public ConsommationPluieServiceImpl() throws Exception {
        consPluieSrv = PhysiqueDataFactory.getConsommationPluieDataService();
    }

    @Override
    public List<ConsommationPluie> getByDate(Date date) throws Exception {
        return this.consPluieSrv.getByDate(date);
    
    }

    @Override
    public ConsommationPluie add(ConsommationPluie t) throws Exception {
        try {
            return this.consPluieSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Consommation de la pluie déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(ConsommationPluie t) throws Exception {
        this.consPluieSrv.remove(t);
    }

    @Override
    public void update(ConsommationPluie t) throws Exception {
        this.consPluieSrv.update(t);
    }

    @Override
    public ConsommationPluie getById(Long l) throws Exception {
        return this.consPluieSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.consPluieSrv.getCount();
    }

    @Override
    public List<ConsommationPluie> getAll() throws Exception {
        return this.consPluieSrv.getAll();
    }

    @Override
    public List<ConsommationPluie> getAll(int i, int i1) throws Exception {
        return this.consPluieSrv.getAll(i, i1);
    }
}
