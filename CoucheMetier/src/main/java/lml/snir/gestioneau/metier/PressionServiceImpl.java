package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.transactionel.PressionService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;
import lml.snir.gestioneau.physique.data.PressionDataService;

/**
 *
 * @author joris
 */
public class PressionServiceImpl implements PressionService {
    private final PressionDataService pressionSrv;
    
    public PressionServiceImpl() throws Exception {
        pressionSrv = PhysiqueDataFactory.getPressionDataService();
    }

    @Override
    public Pression add(Pression t) throws Exception {
        try {
            return this.pressionSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Pression déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Pression t) throws Exception {
        this.pressionSrv.remove(t);
    }

    @Override
    public void update(Pression t) throws Exception {
        this.pressionSrv.update(t);
    }

    @Override
    public Pression getById(Long l) throws Exception {
        return this.pressionSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.pressionSrv.getCount();
    }

    @Override
    public List<Pression> getAll() throws Exception {
        return this.pressionSrv.getAll();
    }

    @Override
    public List<Pression> getAll(int i, int i1) throws Exception {
        return this.pressionSrv.getAll(i, i1);
    }
    
}
