/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.util.ArrayList;
import persistencia.ConsultarClientePR;
import vo.ConsultarClienteVO;

/**
 *
 * @author Raphael
 */
public class ConsultarClienteRN {
    
    public ArrayList<ConsultarClienteVO> listarClientes() throws Exception{
        ConsultarClientePR clientepr = new ConsultarClientePR();
        return clientepr.listarClientes();
    }
    
    public ConsultarClienteVO buscarCliente(Long cod) throws Exception{
        ConsultarClientePR clientepr = new ConsultarClientePR();
        return clientepr.buscarCliente(cod);
    }
}
