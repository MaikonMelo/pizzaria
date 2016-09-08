/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.PedidoPR;
import vo.ConsultarClienteVO;
import vo.ConsultarPedidoVO;
import vo.PedidoVO;

/**
 *
 * @author Raphael
 */
public class PedidoRN {

    public ArrayList<PedidoVO> listarComboSabor() throws SQLException, ClassNotFoundException, Exception {

        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.listarComboSabor();
    }

    public ArrayList<PedidoVO> listarComboBorda() throws SQLException, ClassNotFoundException, Exception {

        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.listarComboBorda();
    }

    public ArrayList<PedidoVO> listarComboBebida() throws SQLException, ClassNotFoundException, Exception {

        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.listarComboBebida();
    }

    public ArrayList<ConsultarClienteVO> listarComboEstado() throws SQLException, ClassNotFoundException, Exception {

        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.listarComboEstado();
    }

    public PedidoVO valorPizza(PedidoVO saborValor) throws Exception {
        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.valorPizza(saborValor);
    }

    public void alterarCliente(ConsultarClienteVO cliente) throws Exception {
        PedidoPR pedidopr = new PedidoPR();
        pedidopr.alterarCliente(cliente);
    }

    public ConsultarClienteVO buscaCliente(long cliente) throws Exception {
        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.buscaCliente(cliente);
    }

    public ArrayList<ConsultarPedidoVO> buscarPedido() throws SQLException, ClassNotFoundException, Exception {

        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.buscarPedido();
    }

    public List<ConsultarPedidoVO> buscarPedidoPorNome(String nome) throws Exception {
        List<ConsultarPedidoVO> pedido = new ArrayList<>();

        PedidoPR pedidoPR = new PedidoPR();

        return pedidoPR.buscarPedidoPorNome(nome);
    }

    public void excluirPedido(int codigo) throws SQLException, Exception {
        PedidoPR pedidoPR = new PedidoPR();
        pedidoPR.excluirPedido(codigo);
    }

    public PedidoVO valorBebida(PedidoVO bebidaValor) throws Exception {
        PedidoPR pedidopr = new PedidoPR();
        return pedidopr.valorBebida(bebidaValor);
    }
    
    public void finalizarPedido (Long cliente, ArrayList<PedidoVO> bebida, ArrayList<PedidoVO> pizza, Float total) throws Exception{
        PedidoPR pedidopr = new PedidoPR();
        pedidopr.finalizarPedido(cliente, bebida, pizza, total);
    }
}
