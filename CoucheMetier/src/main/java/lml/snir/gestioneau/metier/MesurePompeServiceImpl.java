package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.transactionel.MesurePompeService;
import lml.snir.gestioneau.physique.data.MesurePompeDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class MesurePompeServiceImpl implements MesurePompeService {

    private final MesurePompeDataService mesurepompeSrv;

    public MesurePompeServiceImpl() throws Exception {
        mesurepompeSrv = PhysiqueDataFactory.getMesurePompeDataService();
    }

    @Override
    public List<MesurePompe> getByDate(Date date) throws Exception {
        return this.mesurepompeSrv.getByDate(date);
    }

    @Override
    public MesurePompe add(MesurePompe t) throws Exception {
        try {
            return this.mesurepompeSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("MesurePompe déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(MesurePompe t) throws Exception {
        this.mesurepompeSrv.remove(t);
    }

    @Override
    public void update(MesurePompe t) throws Exception {
        this.mesurepompeSrv.update(t);
    }

    @Override
    public MesurePompe getById(Long l) throws Exception {
        return this.mesurepompeSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.mesurepompeSrv.getCount();
    }

    @Override
    public List<MesurePompe> getAll() throws Exception {
        return this.mesurepompeSrv.getAll();
    }

    @Override
    public List<MesurePompe> getAll(int i, int i1) throws Exception {
        return this.mesurepompeSrv.getAll(i, i1);
    }

    @Override
    public MesurePompe getLastTemperature() throws Exception {
        return this.mesurepompeSrv.getLastTemperature();
    }

    @Override
    public MesurePompe getLastPression() throws Exception {
        return this.mesurepompeSrv.getLastPression();
    }

    @Override
    public MesurePompe getLastDebit() throws Exception {
        return this.mesurepompeSrv.getLastDebit();
    }

}
