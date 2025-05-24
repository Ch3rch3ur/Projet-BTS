package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.transactionel.GrandeurPhysiqueService;
import lml.snir.gestioneau.physique.data.GrandeurPhysiqueDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class GrandeurPhysiqueServiceImpl implements GrandeurPhysiqueService {
    private final GrandeurPhysiqueDataService gphysiqueSrv;
    
    public GrandeurPhysiqueServiceImpl() throws Exception {
        gphysiqueSrv = PhysiqueDataFactory.getGrandeurPhysiqueDataService();
    }

    @Override
    public GrandeurPhysique add(GrandeurPhysique t) throws Exception {
        try {
            return this.gphysiqueSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Cuve déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(GrandeurPhysique t) throws Exception {
        this.gphysiqueSrv.remove(t);
    }

    @Override
    public void update(GrandeurPhysique t) throws Exception {
        this.gphysiqueSrv.update(t);
    }

    @Override
    public GrandeurPhysique getById(Long l) throws Exception {
        return this.gphysiqueSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.gphysiqueSrv.getCount();
    }

    @Override
    public List<GrandeurPhysique> getAll() throws Exception {
        return this.gphysiqueSrv.getAll();
    }

    @Override
    public List<GrandeurPhysique> getAll(int i, int i1) throws Exception {
        return this.gphysiqueSrv.getAll(i, i1);
    }
    
}
