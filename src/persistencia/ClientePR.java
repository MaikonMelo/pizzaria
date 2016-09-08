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
import vo.ClienteVO;
import vo.ConsultarClienteVO;

/**
 *
 * @author Waly
 */
public class ClientePR {
    Conexao conexao;
    
    public ClientePR(){
        this.conexao = new Conexao();
    }
    
    public void cadastrarCliente(ClienteVO clienteVO)throws SQLException, Exception {
        try{
        Connection con;
        Statement stm;
        String sql;
        
        con = conexao.conectar();
        
        stm = con.createStatement();
        
        sql = "insert into cliente(cli_telefone, log_cep, cli_nome, cli_numerocasa, cli_complemento, cli_status) "
               +"values("+clienteVO.getTelefone()+", "
               +"'"+clienteVO.getCep()+"', "
               +"'"+clienteVO.getNome()+"', "
                +""+clienteVO.getCasa()+", "
                +"'"+clienteVO.getComplemento()+"', "
                +"'"+clienteVO.getStatus()+"');";
                
         //sql = "insert into borda(bor_codigo, bor_sabor, bor_preco, bor_tipo, bor_status) values(11, 'morango',"+5.00+", 'Doce',"+true+");";
        
        stm.executeUpdate(sql);
        

        } finally {

            conexao.desconectar();
        }
    }
    
    public ConsultarClienteVO buscaCep(String cod) throws SQLException, Exception{
        ConsultarClienteVO clientevo = null;
        
        String sql="select log_cep, est_nome, log_cidade, log_logradouro, log_bairro from logradouro l, estado e where  l.log_cep ='"+cod+ "' and l.log_estado = e.est_codigo" ;
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        if(rs.next()) {
            
            clientevo = new ConsultarClienteVO();
           
            clientevo.setCep(rs.getString("log_cep"));
            clientevo.setEstado(rs.getString("est_nome"));
            clientevo.setCidade(rs.getString("log_cidade"));
            clientevo.setLogradouro(rs.getString("log_logradouro"));
            clientevo.setBairro(rs.getString("log_bairro"));
        }
        
        return clientevo;      
        
        
    }
    
   public ArrayList <ClienteVO> listarClientes() throws SQLException, Exception {
        
        ArrayList <ClienteVO> clientes = new ArrayList();
       
        String sql="select * from cliente c, logradouro l, estado e where c.log_cep = l.log_cep and l.log_estado=e.est_codigo";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            ClienteVO clientevo = new ClienteVO();
            clientevo.setTelefone(Long.parseLong(rs.getString("cli_telefone")));
            clientevo.setNome(rs.getString("cli_nome"));
            clientevo.setCep(rs.getString("log_cep"));
            clientevo.setEstado(rs.getString("est_nome"));
            clientevo.setCidade(rs.getString("log_cidade"));
            clientevo.setLogradouro(rs.getString("log_logradouro"));
            clientevo.setBairro(rs.getString("log_bairro"));
            clientevo.setNumerocasa(Integer.parseInt(rs.getString("cli_numerocasa")));
            clientevo.setComplemento(rs.getString("cli_complemento"));
            clientevo.setStatus(rs.getString("cli_status"));
            
            clientes.add(clientevo);
        }
        
        
        return clientes;
    }
   
   public ClienteVO buscarCliente(long cod) throws SQLException, Exception {
        
        ClienteVO clientevo = new ClienteVO();
       
        String sql="select * from cliente c, logradouro l, estado e where c.log_cep = l.log_cep and l.log_estado=e.est_codigo and cli_telefone="+cod;
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            
            clientevo.setTelefone(Long.parseLong(rs.getString("cli_telefone")));
            clientevo.setNome(rs.getString("cli_nome"));
            clientevo.setCep(rs.getString("log_cep"));
            clientevo.setEstado(rs.getString("est_nome"));
            clientevo.setCidade(rs.getString("log_cidade"));
            clientevo.setLogradouro(rs.getString("log_logradouro"));
            clientevo.setBairro(rs.getString("log_bairro"));
            clientevo.setNumerocasa(Integer.parseInt(rs.getString("cli_numerocasa")));
            clientevo.setComplemento(rs.getString("cli_complemento"));
            clientevo.setStatus(rs.getString("cli_status"));
            
            
        }

        return clientevo;
    }
    
    public void editarCliente(ClienteVO clienteVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update cliente "
                + "set log_cep = '" + clienteVO.getCep() + "', "
                + "cli_nome = '" + clienteVO.getNome() + "', "
                + "cli_numerocasa = " + clienteVO.getCasa() + ", "
                + "cli_complemento = '" + clienteVO.getComplemento() + "', "
                + "cli_status = '" + clienteVO.getStatus()+"'"
                + "where cli_telefone = "+clienteVO.getTelefone()+"";
            
            
                
            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirCliente(ClienteVO clienteVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from cliente where cli_telefone = " + clienteVO.getTelefone();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}
