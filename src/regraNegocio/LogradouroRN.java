
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.LogradouroPR;
import vo.LogradouroVO;

/**
 *
 * @author MAIKON
 */
public class LogradouroRN {
    
    public LogradouroRN(){
        
    }
    
    public ArrayList <LogradouroVO> buscarCEP() throws SQLException, Exception {
        
        LogradouroPR logradouroPR = new LogradouroPR();
        return logradouroPR.buscarCEP();
    }
    
    public void cadastrarCep(LogradouroVO logradouroVO) throws SQLException, Exception {

        LogradouroPR logradouroPR = new LogradouroPR();
        logradouroPR.cadastrarCep(logradouroVO);
    }
    
    public void atualizarCep(LogradouroVO logradouroVO)throws SQLException, Exception{
        
        LogradouroPR logradouroPR = new LogradouroPR();
        logradouroPR.atualizarCep(logradouroVO);
    }
    
    public void excluirSabor(String codigo) throws SQLException, Exception{
        LogradouroPR logradouroPR = new LogradouroPR();
        logradouroPR.excluirCEP(codigo);
    }
}
