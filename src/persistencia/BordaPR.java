/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import vo.BordaVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Waly
 */
public class BordaPR {
    
    Conexao conexao;
    
    public BordaPR(){
        this.conexao = new Conexao();
    }
    
    public void cadastrarBorda(BordaVO bordaVO)throws SQLException, Exception {
        try{
        Connection con;
        Statement stm;
        String sql;
        
        con = conexao.conectar();
        
        stm = con.createStatement();
        
        sql = "insert into borda(bor_codigo, bor_sabor, bor_preco, bor_tipo, bor_status) "
               +"values("+bordaVO.getCodigo()+", "
               +"'"+bordaVO.getSabor()+"', "
               +bordaVO.getPreco()+", "
                +"'"+bordaVO.getTipo()+"', "
               +true+");";
         //sql = "insert into borda(bor_codigo, bor_sabor, bor_preco, bor_tipo, bor_status) values(11, 'morango',"+5.00+", 'Doce',"+true+");";
        
        stm.executeUpdate(sql);
        

        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <BordaVO> listarBorda() throws SQLException, Exception {
        
        ArrayList <BordaVO> bordas = new ArrayList();
        float preco1;
        String sql="select * from borda";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            BordaVO bordaVO = new BordaVO();
            bordaVO.setCodigo((int) Long.parseLong(rs.getString("bor_codigo")));
            bordaVO.setSabor(rs.getString("bor_sabor"));
            preco1 = Float.parseFloat(rs.getString("bor_preco"));
            String result= String.valueOf(preco1);
            bordaVO.setPreco("R$ "+ result.format("%.2f", preco1));
            bordaVO.setTipo(rs.getString("bor_tipo"));
            bordaVO.setStatus(rs.getString("bor_status"));
            
            
            bordas.add(bordaVO);
        }
        
        return bordas;
    }
    public int ultimoID() throws SQLException, Exception {

        int id = 0;
        try {

            Connection con;
            Statement stm;
            ResultSet ultimoID;

            con = conexao.conectar();
            stm = con.createStatement();
            ultimoID = stm.executeQuery("select MAX(bor_codigo) from borda");
            
            if(ultimoID.next()){
                id = ultimoID.getInt(1);
            }
            
        } finally {

            conexao.desconectar();
            return id;
        }
    }
    
    public BordaVO buscarBorda(BordaVO bordaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from borda where bor_codigo = "+bordaVO.getCodigo());

            while (consulta.next()) {

                
                bordaVO.setCodigo(consulta.getInt("bor_codigo"));
                bordaVO.setSabor(consulta.getString("bor_sabor"));
                float preco1 = Float.parseFloat(consulta.getString("beb_preco"));
                String result= String.valueOf(preco1);
                bordaVO.setPreco("R$ "+ result.format("%.2f", preco1));
                bordaVO.setTipo(consulta.getString("bor_tipo"));
                bordaVO.setStatus(consulta.getString("bor_status"));
            }
            
            return bordaVO;
        } finally {

            conexao.desconectar();
            return bordaVO;
        }
        
    }
    
    
    public void editarBorda(BordaVO bordaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update borda "
                + "set bor_sabor = '" + bordaVO.getSabor() + "', "
                + "bor_preco = " + bordaVO.getPreco() + ", "
                + "bor_tipo = '" + bordaVO.getTipo() + "', "
                + "bor_status = " + true + " "
                + "where bor_codigo = "+bordaVO.getCodigo()+"";
            
            
                
            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirBorda(BordaVO bordaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from borda where bor_codigo = " + bordaVO.getCodigo();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    
}
