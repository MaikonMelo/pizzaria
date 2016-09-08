package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.TipoBebidaPR;
import vo.TipoBebidaVO;

/**
 *
 * @author MAIKON
 */
public class TipoBebidaRN {

    public TipoBebidaRN() {

    }

    public ArrayList<TipoBebidaVO> buscarTiposBebidas() throws SQLException, Exception {

        TipoBebidaPR tipoBebidaPers = new TipoBebidaPR();
        return tipoBebidaPers.buscarTiposBebidas();
    }

    public void excluirTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {

        TipoBebidaPR tipoBebidaPR = new TipoBebidaPR();
        tipoBebidaPR.excluirTipoBebida(tipoBebidaVO);
    }
    
    public void cadastrarTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {
        
        TipoBebidaPR tipoBebidaPR = new TipoBebidaPR();
        tipoBebidaPR.cadastrarTipoBebida(tipoBebidaVO);
    }
    
    public void editarTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {
        
        TipoBebidaPR tipoBebidaPR = new TipoBebidaPR();
        tipoBebidaPR.editarTipoBebida(tipoBebidaVO);
    }
}
