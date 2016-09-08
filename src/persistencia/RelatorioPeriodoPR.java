/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import vo.RelatorioVO;

/**
 *
 * @author Leonardo
 */
public class RelatorioPeriodoPR {
    Conexao conexao;
    
    public RelatorioPeriodoPR(){
        this.conexao=new Conexao();
    }
    
    public ArrayList <RelatorioVO> gerarRelatorio(Date dtInicial, Date dtFinal) throws SQLException, IOException, Exception{
        ArrayList <RelatorioVO> relatorioLista=new ArrayList();
//            String sqlcli="select * from cliente c, logradouro l, estado e where cli_telefone="+tel+" and c.log_cep=l.log_cep and l.log_estado=e.est_codigo";
            
            String sqlped="select distinct * from pedido ped, (select i.piz_sabores as sabores, i.item_quant as quant, item_tamanho as tamanho, item_valorunit as valor_uni, item_valortotal as total from item_pedido i, pedido p where p.ped_codigo=i.ped_codigo) pizza, (select b.bor_sabor from borda b, item_pedido i, pedido p where b.bor_codigo=i.bor_codigo and p.ped_codigo=i.ped_codigo) bor, (select b.beb_nome from bebida b, item_pedido i, pedido p where b.beb_codigo=i.beb_codigo and p.ped_codigo=i.ped_codigo) beb where ped.ped_data between '"+dtInicial+"' and '"+dtFinal+"'";
            
            Connection con=conexao.conectar();
            Statement stm=con.createStatement();
//            Statement stm2=con.createStatement();
            ResultSet rs = stm.executeQuery(sqlped);
//            ResultSet rs2 = stm2.executeQuery(sqlcli);
            
            while(rs.next()){
                RelatorioVO relatoriovo=new RelatorioVO();
                relatoriovo.setCodigo(rs.getString("ped_codigo"));
                relatoriovo.setTelefone(rs.getString("cli_telefone"));
                relatoriovo.setData(rs.getString("ped_data"));
                relatoriovo.setQuant(rs.getString("quant"));
                relatoriovo.setTamanho(rs.getString("tamanho"));
                relatoriovo.setSabores(rs.getString("sabores"));
                relatoriovo.setBorda(rs.getString("bor_sabor"));
                relatoriovo.setBebida(rs.getString("beb_nome"));
                relatoriovo.setValor_unit(rs.getString("valor_uni"));
                relatoriovo.setTotal(rs.getString("total"));
                relatoriovo.setValor_total(rs.getString("ped_valor_total"));
                
                relatorioLista.add(relatoriovo);
            }
        return relatorioLista;
    }
}
