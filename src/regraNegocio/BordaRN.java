/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import vo.BordaVO;
import persistencia.BordaPR;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Waly
 */
public class BordaRN {
    
    public BordaRN(){
        
    }
    public int pegarUltimoID()throws SQLException, Exception{
        BordaPR bordapr = new BordaPR();
        return bordapr.ultimoID();
    }
    
    public void cadastrarBorda(BordaVO bordaVO) throws SQLException, Exception {
        
        BordaPR bordaPR = new BordaPR();
        bordaPR.cadastrarBorda(bordaVO);
    }
    public ArrayList<BordaVO> listarBorda() throws SQLException, Exception{
        BordaPR bordaPR = new BordaPR();
        return bordaPR.listarBorda();
    }

    public BordaVO buscarBorda(BordaVO bordaVO) throws SQLException, Exception {
        
        BordaPR bordaPR = new BordaPR();
        bordaPR.buscarBorda(bordaVO);
        return bordaVO;
    }
    
    public void editarBorda(BordaVO bordaVO) throws SQLException, Exception {
        
        BordaPR bordaPR = new BordaPR();
        bordaPR.editarBorda(bordaVO);
    }
    
    public void excluirBorda(BordaVO bordaVO) throws SQLException, Exception {
        
        BordaPR bordaPR = new BordaPR();
        bordaPR.excluirBorda(bordaVO);
    }
}
