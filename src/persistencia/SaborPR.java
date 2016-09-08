
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.ConsultarSaborVO;

/**
 *
 * @author MAIKON
 */
public class SaborPR {
    
    Conexao conexao;
    
    public SaborPR(){
        
        this.conexao = new Conexao();
        
    }
    
    public ArrayList <ConsultarSaborVO> buscarSabor() throws SQLException, Exception {

        ArrayList <ConsultarSaborVO> sabor = new ArrayList();
        
        try {
            
            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from sabor");

            while (consulta.next()) {
                
                ConsultarSaborVO saborVO = new ConsultarSaborVO();
                
                saborVO.setSab_codigo(consulta.getInt("sab_codigo"));
                saborVO.setSab_nome(consulta.getString("sab_nome"));
                saborVO.setSab_preco(consulta.getFloat("sab_preco"));
                saborVO.setSab_ingredientes(consulta.getString("sab_igredi"));
                saborVO.setSab_tipo(consulta.getString("sab_tipo"));
                saborVO.setSab_status(consulta.getBoolean("sab_status"));
                
                System.out.println("persistencia: " + saborVO.getSab_codigo());
                sabor.add(saborVO);
                
                
            }

        } finally {

            conexao.desconectar();
            return sabor;
        }
    }
    
    public int ultimoID() throws SQLException, Exception {

        int id = 0;
        try {

            Connection con;
            Statement stm;
            ResultSet ultimoID;

            con = conexao.conectar();
            stm = con.createStatement();
            ultimoID = stm.executeQuery("select MAX(sab_codigo) from sabor");
            
            if(ultimoID.next()){
                id = ultimoID.getInt(1);
            }
            
        } finally {

            conexao.desconectar();
            return id;
        }
    }
    
    public void excluirSabor(int codigo) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from sabor where sab_codigo = " + codigo;

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void cadastrarSabor(ConsultarSaborVO saborVO) throws SQLException, Exception {
        
        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "insert into sabor (sab_nome, sab_preco, sab_igredi, sab_tipo, sab_status) "
                    + "values('" + saborVO.getSab_nome()+ "', "
                    + saborVO.getSab_preco()+ ", "
                    + "'" + saborVO.getSab_ingredientes()+ "', "
                    + "'" + saborVO.getSab_tipo()+ "', "
                    + saborVO.isSab_status()+ ");";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
        
    }
    
    public void atualizarSabor(ConsultarSaborVO saborVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update sabor "
                + "set sab_nome = '" + saborVO.getSab_nome()+ "', "
                + "sab_preco = " + saborVO.getSab_preco()+ ", "
                + "sab_igredi = '" + saborVO.getSab_ingredientes()+ "', "
                + "sab_tipo = '" + saborVO.getSab_tipo()+ "', "
                + "sab_status = " + saborVO.isSab_status()+ " "
                + "where sab_codigo = '" + saborVO.getSab_codigo()+ "'";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}
