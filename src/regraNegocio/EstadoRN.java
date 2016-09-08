
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.EstadoPR;
import vo.EstadoVO;

/**
 *
 * @author MAIKON
 */
public class EstadoRN {
    
    public EstadoRN(){
        
    }
    
    public ArrayList<EstadoVO> listarComboEstado() throws SQLException, ClassNotFoundException, Exception {

        EstadoPR consultarEstadoPR = new EstadoPR();
        return consultarEstadoPR.listarComboEstado();
    }
    
    public ArrayList<String> buscarEstado(int cod_estado) throws SQLException, Exception{
        EstadoPR estadoPR = new EstadoPR();
        return estadoPR.buscarEstado(cod_estado);
    }
}
