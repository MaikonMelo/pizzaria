
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.SaborPR;
import vo.ConsultarSaborVO;

/**
 *
 * @author MAIKON
 */
public class SaborRN {
    
    public SaborRN(){
        
    }
    
    public ArrayList<ConsultarSaborVO> buscarSabor() throws SQLException, Exception{
        
        SaborPR saborPR = new SaborPR();
        return saborPR.buscarSabor();
        
    }
    
    public int pegarUltimoID()throws SQLException, Exception{
        SaborPR saborPR = new SaborPR();
        return saborPR.ultimoID();
    }
    
    public void excluirSabor(int codigo) throws SQLException, Exception{
        SaborPR saborPR = new SaborPR();
        saborPR.excluirSabor(codigo);
    }
    
    public void cadastrarSabor(ConsultarSaborVO saborVO) throws SQLException, Exception{
        SaborPR saborPR = new SaborPR();
        saborPR.cadastrarSabor(saborVO);
    }
    
    public void atualizarSabor(ConsultarSaborVO saborVO) throws SQLException, Exception{
        SaborPR saborPR = new SaborPR();
        saborPR.atualizarSabor(saborVO);
    }
}
