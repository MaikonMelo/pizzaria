/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BebidaPers;
import vo.BebidaVO;

/**
 *
 * @author Waly
 */
public class BebidaRN {
    public BebidaRN(){
        
    }
    public int pegarUltimoID()throws SQLException, Exception{
        BebidaPers bebidapr = new BebidaPers();
        return bebidapr.ultimoID();
    }
    public void cadastrarBebida(BebidaVO bebidaVO) throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        bebidaPers.cadastrarBebida(bebidaVO);
    }
    public ArrayList<BebidaVO> listarBebida() throws SQLException, Exception{
        BebidaPers bebidaPers = new BebidaPers();
        return bebidaPers.listarBebida();
    }
    
    public ArrayList<BebidaVO> popularMarca() throws SQLException, Exception{
        BebidaPers bebidaPers = new BebidaPers();
        return bebidaPers.popularMarca();
    }
    public ArrayList<BebidaVO> popularTipo() throws SQLException, Exception{
        BebidaPers bebidaPers = new BebidaPers();
        return bebidaPers.popularTipo();
    }

    public ArrayList<BebidaVO> buscarBebida() throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        return bebidaPers.buscarBebida();
    }
    
    public void editarBebida(BebidaVO bebidaVO) throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        bebidaPers.editarBebida(bebidaVO);
    }
    
    public void excluirBebida(BebidaVO bebidaVO) throws SQLException, Exception {
        
        BebidaPers bebidaPers = new BebidaPers();
        bebidaPers.excluirBebida(bebidaVO);
    }
    
}
