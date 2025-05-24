package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Pompe;
import lml.snir.gestioneau.metier.transactionel.PompeService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;
import lml.snir.gestioneau.physique.data.PompeDataService;

/**
 *
 * @author joris
 */
public class PompeServiceImpl implements PompeService {
    private final PompeDataService pompeSrv;
    
    public PompeServiceImpl() throws Exception {
        pompeSrv = PhysiqueDataFactory.getPompeDataService();
    }

    @Override
    public Pompe add(Pompe t) throws Exception {
        try {
            return this.pompeSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Pompe déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Pompe t) throws Exception {
        this.pompeSrv.remove(t);
    }

    @Override
    public void update(Pompe t) throws Exception {
        this.pompeSrv.update(t);
    }

    @Override
    public Pompe getById(Long l) throws Exception {
        return this.pompeSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.pompeSrv.getCount();
    }

    @Override
    public List<Pompe> getAll() throws Exception {
        return this.pompeSrv.getAll();
    }

    @Override
    public List<Pompe> getAll(int i, int i1) throws Exception {
        return this.pompeSrv.getAll(i, i1);
    }
    
}
