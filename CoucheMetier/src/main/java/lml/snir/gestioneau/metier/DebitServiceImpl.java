package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.transactionel.DebitService;
import lml.snir.gestioneau.physique.data.DebitDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class DebitServiceImpl implements DebitService {
    private final DebitDataService debitSrv;
    
    public DebitServiceImpl() throws Exception {
        debitSrv = PhysiqueDataFactory.getDebitDataService();
    }

    @Override
    public Debit add(Debit t) throws Exception {
        try {
            return this.debitSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Débit déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Debit t) throws Exception {
        this.debitSrv.remove(t);
    }

    @Override
    public void update(Debit t) throws Exception {
        this.debitSrv.update(t);
    }

    @Override
    public Debit getById(Long l) throws Exception {
        return this.debitSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.debitSrv.getCount();
    }

    @Override
    public List<Debit> getAll() throws Exception {
        return this.debitSrv.getAll();
    }

    @Override
    public List<Debit> getAll(int i, int i1) throws Exception {
        return this.debitSrv.getAll(i, i1);
    }
    
    
    
}
