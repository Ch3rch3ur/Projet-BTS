package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.NiveauEau;
import lml.snir.gestioneau.metier.transactionel.NiveauEauService;
import lml.snir.gestioneau.physique.data.NiveauEauDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class NiveauEauServiceImpl implements NiveauEauService {
    private final NiveauEauDataService niveaueauSrv;
    
    public NiveauEauServiceImpl() throws Exception {
        niveaueauSrv = PhysiqueDataFactory.getNiveauEauDataService();
    }

    @Override
    public List<NiveauEau> getByDate(Date date) throws Exception {
        return this.niveaueauSrv.getByDate(date);
    }

    @Override
    public NiveauEau add(NiveauEau t) throws Exception {
        try {
            return this.niveaueauSrv.add(t);
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
    public void remove(NiveauEau t) throws Exception {
        this.niveaueauSrv.remove(t);
    }

    @Override
    public void update(NiveauEau t) throws Exception {
        this.niveaueauSrv.update(t);
    }

    @Override
    public NiveauEau getById(Long l) throws Exception {
        return this.niveaueauSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.niveaueauSrv.getCount();
    }

    @Override
    public List<NiveauEau> getAll() throws Exception {
        return this.niveaueauSrv.getAll();
    }

    @Override
    public List<NiveauEau> getAll(int i, int i1) throws Exception {
        return this.niveaueauSrv.getAll(i, i1);
    }

    @Override
    public NiveauEau getLast() throws Exception {
        return this.niveaueauSrv.getLast();
    }
    
}
