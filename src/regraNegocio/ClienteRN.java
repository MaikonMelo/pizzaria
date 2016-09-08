/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.ClientePR;
import vo.ClienteVO;
import vo.ConsultarClienteVO;

/**
 *
 * @author Waly
 */
public class ClienteRN {
    public ClienteRN(){
        
    }
    
    public void cadastrarCliente(ClienteVO clienteVO) throws SQLException, Exception {
        
        ClientePR clientePers = new ClientePR();
        clientePers.cadastrarCliente(clienteVO);
    }
   public ConsultarClienteVO buscaCep(String cep) throws Exception{
        ClientePR clientepr = new ClientePR();
        return clientepr.buscaCep(cep);
   }
   public ClienteVO buscaCliente(Long cliente) throws Exception{
        ClientePR clientepr = new ClientePR();
        return clientepr.buscarCliente(cliente);
   }
    public void editarCliente(ClienteVO clienteVO) throws SQLException, Exception {
        
        ClientePR clientePers = new ClientePR();
        clientePers.editarCliente(clienteVO);
    }
    
    public ArrayList<ClienteVO> listarClientes() throws Exception{
        ClientePR clientepr = new ClientePR();
        return clientepr.listarClientes();
    }
    
    public void excluirCliente(ClienteVO clienteVO) throws SQLException, Exception {
        
        ClientePR clientePers = new ClientePR();
        clientePers.excluirCliente(clienteVO);
    }
}
