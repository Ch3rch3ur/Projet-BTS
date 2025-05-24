package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.transactionel.ConsommationVilleService;
import lml.snir.gestioneau.physique.data.ConsommationVilleDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class ConsommationVilleServiceImpl implements ConsommationVilleService {
    private final ConsommationVilleDataService consVilleSrv;
    
    public ConsommationVilleServiceImpl() throws Exception {
        consVilleSrv = PhysiqueDataFactory.getConsommationVilleDataService();
    }

    @Override
    public List<ConsommationVille> getByDate(Date date) throws Exception {
        return this.consVilleSrv.getByDate(date);
    }

    @Override
    public ConsommationVille add(ConsommationVille t) throws Exception {
        try {
            return this.consVilleSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Consommation de la ville déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(ConsommationVille t) throws Exception {
        this.consVilleSrv.remove(t);
    }

    @Override
    public void update(ConsommationVille t) throws Exception {
        this.consVilleSrv.update(t);
    }

    @Override
    public ConsommationVille getById(Long l) throws Exception {
        return this.consVilleSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.consVilleSrv.getCount();
    }

    @Override
    public List<ConsommationVille> getAll() throws Exception {
        return this.consVilleSrv.getAll();
    }

    @Override
    public List<ConsommationVille> getAll(int i, int i1) throws Exception {
        return this.consVilleSrv.getAll(i, i1);
    }
}
