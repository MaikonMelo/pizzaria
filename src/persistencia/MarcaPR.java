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
import vo.MarcaVO;

/**
 *
 * @author Waly
 */
public class MarcaPR {
    Conexao conexao;
    
    public MarcaPR(){
        this.conexao = new Conexao();
    }
    
    public void cadastrarMarca(MarcaVO marcaVO)throws SQLException, Exception {
        try{
        Connection con;
        Statement stm;
        String sql;
        
        con = conexao.conectar();
        
        stm = con.createStatement();
        
        sql = "insert into marca(mar_nome) "
               +"values('"+marcaVO.getNome()+"');";
        
        stm.executeUpdate(sql);
        

        } finally {

            conexao.desconectar();
        }
    }
    
    public ArrayList <MarcaVO> listarMarca() throws SQLException, Exception {
        
        ArrayList <MarcaVO> marca = new ArrayList();
       
        String sql="select * from marca";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            MarcaVO marcaVO = new MarcaVO();
            marcaVO.setCodigo((int) Long.parseLong(rs.getString("mar_codigo")));
            marcaVO.setNome(rs.getString("mar_nome"));
            
            
            marca.add(marcaVO);
        }
        
        return marca;
    }
    
    public ArrayList <MarcaVO> buscarMarca() throws SQLException, Exception {

        ArrayList <MarcaVO> marca = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from marca");

            while (consulta.next()) {

                MarcaVO marcaVO = new MarcaVO();
                
                marcaVO.setCodigo(consulta.getInt("mar_codigo"));
                marcaVO.setNome(consulta.getString("mar_nome"));
                
                
                
                marca.add(marcaVO);
            }
                
        } finally {

            conexao.desconectar();
            return marca;
        }
        
    }
    
    
    public void editarMarca(MarcaVO marcaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update marca "
                + "set mar_nome = '" + marcaVO.getNome() + "' "
                + "where mar_codigo = "+marcaVO.getCodigo();
            
            
                
            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
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
            ultimoID = stm.executeQuery("select MAX(mar_codigo) from marca");
            
            if(ultimoID.next()){
                id = ultimoID.getInt(1);
            }
            
        } finally {

            conexao.desconectar();
            return id;
        }
    }
    
    public void excluirMarca(MarcaVO marcaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from marca where mar_codigo = " + marcaVO.getCodigo();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}

