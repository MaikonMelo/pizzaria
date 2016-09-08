/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.MarcaPR;
import vo.MarcaVO;

/**
 *
 * @author Waly
 */
public class MarcaRN {
    public MarcaRN(){
        
    }
    public int pegarUltimoID()throws SQLException, Exception{
        MarcaPR marcapr = new MarcaPR();
        return marcapr.ultimoID();
    }
    
    public void cadastrarMarca(MarcaVO marcaVO) throws SQLException, Exception {
        
        MarcaPR marcaPers = new MarcaPR();
        marcaPers.cadastrarMarca(marcaVO);
    }
    public ArrayList<MarcaVO> listarMarca() throws SQLException, Exception{
        MarcaPR marcaPers = new MarcaPR();
        return marcaPers.listarMarca();
    }

    public ArrayList <MarcaVO> buscarMarca() throws SQLException, Exception {
        
        MarcaPR marcaPers = new MarcaPR();
        return marcaPers.buscarMarca();
    }
    
    public void editarMarca(MarcaVO marcaVO) throws SQLException, Exception {
        
        MarcaPR marcaPers = new MarcaPR();
        marcaPers.editarMarca(marcaVO);
    }
    
    public void excluirMarca(MarcaVO marcaVO) throws SQLException, Exception {
        
        MarcaPR marcaPers = new MarcaPR();
        marcaPers.excluirMarca(marcaVO);
    }
}
