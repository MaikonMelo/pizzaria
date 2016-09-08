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
import java.util.List;
import vo.ConsultarClienteVO;
import vo.ConsultarPedidoVO;
import vo.PedidoVO;

/**
 *
 * @author Raphael
 */
public class PedidoPR {

    Conexao conexao;

    public PedidoPR() {
        this.conexao = new Conexao();
    }

    public ArrayList<PedidoVO> listarComboSabor() throws SQLException, ClassNotFoundException, Exception {

        ArrayList<PedidoVO> combo = new ArrayList();

        String sql = "select * from sabor";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            PedidoVO pedidovo = new PedidoVO();
            pedidovo.setSabor(rs.getString("sab_nome"));

            combo.add(pedidovo);
        }

        return combo;
    }

    public ArrayList<PedidoVO> listarComboBorda() throws SQLException, ClassNotFoundException, Exception {

        ArrayList<PedidoVO> combo = new ArrayList();

        String sql = "select * from borda";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            PedidoVO pedidovo = new PedidoVO();
            pedidovo.setBorda(rs.getString("bor_sabor"));

            combo.add(pedidovo);
        }

        return combo;
    }

    public ArrayList<PedidoVO> listarComboBebida() throws SQLException, ClassNotFoundException, Exception {

        ArrayList<PedidoVO> combo = new ArrayList();

        String sql = "select * from bebida";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            PedidoVO pedidovo = new PedidoVO();
            pedidovo.setBebida(rs.getString("beb_nome"));

            combo.add(pedidovo);
        }

        return combo;
    }

    public ArrayList<ConsultarClienteVO> listarComboEstado() throws SQLException, ClassNotFoundException, Exception {

        ArrayList<ConsultarClienteVO> combo = new ArrayList();

        String sql = "select * from estado";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            ConsultarClienteVO clientevo = new ConsultarClienteVO();
            clientevo.setEstado(rs.getString("est_nome"));

            combo.add(clientevo);
        }

        return combo;
    }

    public PedidoVO valorPizza(PedidoVO saborValor) throws SQLException, Exception {
        float soma = 0;
        String sql = "select * from sabor where sab_nome ='" + saborValor.getSabor1() + "'";
        String sql2 = "select * from sabor where sab_nome ='" + saborValor.getSabor2() + "'";
        String sql3 = "select * from sabor where sab_nome ='" + saborValor.getSabor3() + "'";
        String sql4 = "select * from borda where bor_sabor ='" + saborValor.getBorda() + "'";

        

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            soma = soma + rs.getFloat("sab_preco");
        }
        ResultSet rs2 = stm.executeQuery(sql2);
        if (rs2.next()) {
            soma = ((soma + Float.parseFloat(rs2.getString("sab_preco"))) / 2);
        }
        ResultSet rs3 = stm.executeQuery(sql3);
        if (rs3.next()) {
            soma = ((soma + Float.parseFloat(rs3.getString("sab_preco"))) / 2);
        }
        ResultSet rs4 = stm.executeQuery(sql4);
        if (rs4.next()) {
            soma = soma + Float.parseFloat(rs4.getString("bor_preco"));
        }

        soma = soma * saborValor.getQuant();
        
        switch (saborValor.getTamanho()) {
            case "M":
                soma = soma + 10;
                break;
            case "G":
                soma = soma + 20;
                break;
            case "GG":
                soma = soma + 30;
                break;
        }

        String result = String.valueOf(soma);
        saborValor.setTotal(soma);
        saborValor.setValor("R$ " + result.format("%.2f", soma));

        return saborValor;

    }

    public PedidoVO valorBebida(PedidoVO bebidaValor) throws SQLException, Exception {
        float soma = 0;
        String sql = "select * from bebida where beb_nome ='" + bebidaValor.getBebida() + "'";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            soma = rs.getFloat("beb_preco");
        }
        String result = String.valueOf(soma);
        bebidaValor.setTotal(soma);
        bebidaValor.setValor("R$ " + result.format("%.2f", soma));

        return bebidaValor;

    }

    public void alterarCliente(ConsultarClienteVO cliente) throws SQLException, Exception {
        Integer estadoCodigo = 0;
        String sql = "select * from logradouro where log_cep='" + cliente.getCep() + "'";
        String sql2 = "select * from estado where est_nome ='" + cliente.getEstado() + "'";
        String sql4 = "update cliente set cli_telefone = " + cliente.getTelefone()
                + ", log_cep = '" + cliente.getCep()
                + "', cli_nome = '" + cliente.getNome()
                + "', cli_numerocasa = '" + cliente.getNumerocasa()
                + "', cli_complemento = '" + cliente.getComplemento()
                + "' where cli_telefone = " + cliente.getTelefone();

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if (rs.next()) {
            stm.execute(sql4);
        } else {
            ResultSet rs2 = stm.executeQuery(sql2);
            if (rs2.next()) {
                estadoCodigo = rs2.getInt("est_codigo");
                String sql3 = "insert into logradouro values ('" + cliente.getCep()
                        + "', " + estadoCodigo
                        + ", '" + cliente.getCidade()
                        + "', '" + cliente.getLogradouro()
                        + "', '" + cliente.getBairro()
                        + "')";
                stm.execute(sql3);

                stm.execute(sql4);
            }
        }

    }

    public ConsultarClienteVO buscaCliente(long cod) throws SQLException, Exception {
        ConsultarClienteVO clientevo = null;

        String sql = "select * from cliente c, logradouro l, estado e where c.log_cep = l.log_cep and l.log_estado=e.est_codigo and cli_telefone=" + cod;

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {

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

    public void finalizarPedido(Long cliente, ArrayList<PedidoVO> bebida, ArrayList<PedidoVO> pizza, Float total) throws SQLException, Exception {       
        Integer codigoPedido = null;
        Integer codigoBorda = null;
        Integer codigoBebida = null;
        String sabor1 = null;
        String sabor2 = null;
        String sabor3 = null;
        String sabores = null;
        Float totalItem = null;

        String sql = "insert into pedido(cli_telefone, ped_data, ped_valor_total) values (" + cliente + ", CURRENT_DATE, " + total + ")";
        String sql2 = "select MAX(ped_codigo) from pedido";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        for (PedidoVO listarTabela : pizza) {
            if (!"X".equals(listarTabela.getBorda())) {
                String sql3 = "select * from borda where bor_sabor='" + listarTabela.getBorda() + "'";
                ResultSet rs3 = stm.executeQuery(sql3);
                if (rs3.next()) {
                    codigoBorda = Integer.parseInt(rs.getString("bor_codigo"));
                }
            }
            sabor1 = listarTabela.getSabor1();
            sabor2 = listarTabela.getSabor2();
            sabor3 = listarTabela.getSabor3();
            if ("X".equals(listarTabela.getSabor1())) {
                sabor1 = "";
            }
            if ("X".equals(listarTabela.getSabor2())) {
                sabor2 = "";
            }
            if ("X".equals(listarTabela.getSabor3())) {
                sabor3 = "";
            }

            sabores = sabor1 + " " + sabor2 + " " + sabor3;

            ResultSet rs2 = stm.executeQuery(sql2);
            if (rs2.next()) {
                codigoPedido = rs.getInt("max");
            }

            totalItem = Float.parseFloat(listarTabela.getValor().replace(" ", "").replace("R", "").replace("$", "")) * listarTabela.getQuant();
            String sqli = "insert into item_pedido values (" + codigoBorda
                    + ", '" + sabores
                    + "', null, " + codigoPedido
                    + ", '" + listarTabela.getTamanho()
                    + "', " + listarTabela.getValor()
                    + ", " + listarTabela.getQuant()
                    + ", " + totalItem + ")";

            stm.executeQuery(sqli);
        }

        for (PedidoVO listarTabela : bebida) {
            if (!" ".equals(listarTabela.getBorda())) {
                String sql5 = "select * from bebida where beb_nome='" + listarTabela.getBebida() + "'";
                ResultSet rs5 = stm.executeQuery(sql5);
                if (rs5.next()) {
                    codigoBebida = Integer.parseInt(rs.getString("beb_codigo"));
                }
            }
            totalItem = Float.parseFloat(listarTabela.getValor().replace(" ", "").replace("R", "").replace("$", "")) * listarTabela.getQuant();
            String sql7 = "insert into item_pedido values (null, null, " + codigoBebida
                    + ", " + codigoPedido
                    + ", null"
                    + ", " + listarTabela.getValor()
                    + ", " + listarTabela.getQuant()
                    + ", " + totalItem + ")";

            stm.executeQuery(sql7);
        }
    }

    public List<ConsultarPedidoVO> buscarPedidoPorNome(String nome) throws SQLException, Exception {
        ConsultarPedidoVO pedidoVO = new ConsultarPedidoVO();
        List<ConsultarPedidoVO> pedido = new ArrayList<>();
        try {
            Connection con = conexao.conectar();
            Statement stmt = con.createStatement();

            String sql = "select ped_codigo,p.cli_telefone,cli_nome from pedido p, cliente c where cli_nome ILIKE '%" + nome + "%' AND c.cli_telefone = p.cli_telefone ORDER BY ped_codigo ASC;";
            //sql = "SELECT id_funcionario, nome, login FROM funcionario WHERE nome ILIKE '%" + nome + "%' AND id_funcionario != 1 ORDER BY id_funcionario ASC;";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                pedidoVO.setPedido_codigo(rs.getString("ped_codigo"));
                pedidoVO.setCliente_telefone(rs.getString("cli_telefone"));
                pedidoVO.setCliente_nome(rs.getString("cli_nome"));
                pedido.add(pedidoVO);
            }
        } finally {
            conexao.desconectar();
        }

        return pedido;
    }

    public ArrayList<ConsultarPedidoVO> buscarPedido() throws SQLException, Exception {

        ArrayList<ConsultarPedidoVO> pedido = new ArrayList();
        ConsultarPedidoVO consultarpedidoVO = null;

        String sql = "select ped_codigo,p.cli_telefone,cli_nome from pedido p, cliente c where p.cli_telefone = c.cli_telefone";
        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            consultarpedidoVO = new ConsultarPedidoVO();

            consultarpedidoVO.setPedido_codigo(rs.getString("ped_codigo"));
            consultarpedidoVO.setCliente_telefone(rs.getString("cli_telefone"));
            consultarpedidoVO.setCliente_nome(rs.getString("cli_nome"));

            pedido.add(consultarpedidoVO);
        }

        return pedido;

    }

    public void excluirPedido(int codigo) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from pedido where ped_codigo = " + codigo;

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }

}
