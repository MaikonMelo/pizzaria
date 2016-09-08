/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.ConsultarClienteVO;

/**
 *
 * @author Raphael
 */
public class ConsultarClientePR {
    Conexao conexao;
    
    public ConsultarClientePR(){
        this.conexao=new Conexao();
    }
    
    public ArrayList <ConsultarClienteVO> listarClientes() throws SQLException, Exception {
        
        ArrayList <ConsultarClienteVO> clientes = new ArrayList();
       
        String sql="select * from cliente c, logradouro l, estado e where c.log_cep = l.log_cep and l.log_estado=e.est_codigo";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            ConsultarClienteVO clientevo = new ConsultarClienteVO();
            clientevo.setTelefone(Long.parseLong(rs.getString("cli_telefone")));
            clientevo.setNome(rs.getString("cli_nome"));
            clientevo.setCep(rs.getString("log_cep"));
            clientevo.setEstado(rs.getString("est_nome"));
            clientevo.setCidade(rs.getString("log_cidade"));
            clientevo.setLogradouro(rs.getString("log_logradouro"));
            clientevo.setBairro(rs.getString("log_bairro"));
            clientevo.setNumerocasa(Integer.parseInt(rs.getString("cli_numerocasa")));
            clientevo.setComplemento(rs.getString("cli_complemento"));
            
            clientes.add(clientevo);
        }
        
        return clientes;
    }
    
    public ConsultarClienteVO buscarCliente(Long cod) throws SQLException, Exception {
        
        ConsultarClienteVO clientevo = null;
        
        String sql="select * from cliente c, logradouro l, estado e where c.log_cep = l.log_cep and l.log_estado=e.est_codigo and cli_telefone="+cod;
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        if(rs.next()) {
            
            clientevo = new ConsultarClienteVO();
            clientevo.setTelefone(Long.parseLong(rs.getString("cli_telefone")));
            clientevo.setNome(rs.getString("cli_nome"));
            clientevo.setCep(rs.getString("log_cep"));
            clientevo.setEstado(rs.getString("est_nome"));
            clientevo.setCidade(rs.getString("log_cidade"));
            clientevo.setLogradouro(rs.getString("log_logradouro"));
            clientevo.setBairro(rs.getString("log_bairro"));
            clientevo.setNumerocasa(Integer.parseInt(rs.getString("cli_numerocasa")));
            clientevo.setComplemento(rs.getString("cli_complemento"));
        }
        
        return clientevo;
    }
}
