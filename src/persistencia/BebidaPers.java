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
import vo.BebidaVO;

/**
 *
 * @author Waly
 */
public class BebidaPers {
    Conexao conexao;
    public BebidaPers(){
        this.conexao = new Conexao();
    }
    
    public void cadastrarBebida(BebidaVO bebidaVO)throws SQLException, Exception {
        try{
        Connection con;
        Statement stm;
        String sql;
        
        con = conexao.conectar();
        
        stm = con.createStatement();
        
        sql = "insert into bebida(beb_codigo, beb_nome, mar_codigo, bebtip_codigo, beb_volume, beb_unidade_medida, beb_preco, beb_status)"
               +"values("+bebidaVO.getCodigo()+", "
               +"'"+bebidaVO.getMarca()+"  "+bebidaVO.getVolume()+bebidaVO.getUnidade()+"', "
               +"(SELECT mar_codigo FROM marca WHERE mar_nome= '"+ bebidaVO.getMarca()+"'), "
               +"(SELECT bebtip_codigo FROM tipobebida WHERE bebtip_nome= '"+ bebidaVO.getTipo()+"'), "
               +bebidaVO.getVolume()+", "
               +"'"+bebidaVO.getUnidade()+"', "
               +bebidaVO.getPreco()+", "
               +"true);";
                
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
            ultimoID = stm.executeQuery("select MAX(beb_codigo) from bebida");
            
            if(ultimoID.next()){
                id = ultimoID.getInt(1);
            }
            
        } finally {

            conexao.desconectar();
            return id;
        }
    }
    
    public ArrayList <BebidaVO> listarBebida() throws SQLException, Exception {
        
        ArrayList <BebidaVO> bebida = new ArrayList();
       
        String sql="select beb_codigo, beb_nome, mar_nome, bebtip_nome, beb_preco, beb_unidade_medida, beb_volume from bebida b, marca m, tipobebida t WHERE b.mar_codigo = m.mar_codigo and b.bebtip_codigo = t.bebtip_codigo";
        float preco1;
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            
            BebidaVO bebidaVO = new BebidaVO();
            bebidaVO.setCodigo((int) Long.parseLong(rs.getString("beb_codigo")));
            bebidaVO.setNome(rs.getString("beb_nome"));
            bebidaVO.setMarca(rs.getString("mar_nome"));
            bebidaVO.setTipo(rs.getString("bebtip_nome"));
            preco1 = Float.parseFloat(rs.getString("beb_preco"));
            String result= String.valueOf(preco1);
            bebidaVO.setPreco("R$ "+ result.format("%.2f", preco1));
            bebidaVO.setUnidade(rs.getString("beb_unidade_medida"));
            bebidaVO.setVolume(Long.parseLong(rs.getString("beb_volume")));
            
            bebida.add(bebidaVO);
        }
        
        return bebida;
    }
    public ArrayList <BebidaVO> popularMarca() throws SQLException, Exception {
        ArrayList <BebidaVO> bebida = new ArrayList();
        String sql="SELECT mar_nome FROM marca";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()) {
            
            BebidaVO bebidaVO = new BebidaVO();
            bebidaVO.setMarca(rs.getString("mar_nome"));
            
            bebida.add(bebidaVO);
        }
        conexao.desconectar();
        return bebida;
    }
    
    public ArrayList <BebidaVO> popularTipo() throws SQLException, Exception {
        ArrayList <BebidaVO> bebida = new ArrayList();
        String sql="SELECT bebtip_nome FROM tipobebida";
        
        Connection con=conexao.conectar();
        Statement stm=con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()) {
            
            BebidaVO bebidaVO = new BebidaVO();
            bebidaVO.setTipo(rs.getString("bebtip_nome"));
            
            bebida.add(bebidaVO);
        }
        conexao.desconectar();
        return bebida;
    }
    
    
    public ArrayList <BebidaVO> buscarBebida() throws SQLException, Exception {

        ArrayList <BebidaVO> bebida = new ArrayList();
        
        try {

            Connection con;
            Statement stm;
            ResultSet consulta;
            
            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from marca");

            while (consulta.next()) {

                BebidaVO bebidaVO = new BebidaVO();
                bebidaVO.setCodigo((int) Long.parseLong(consulta.getString("beb_codigo")));
                bebidaVO.setNome(consulta.getString("mar_nome"));
                bebidaVO.setCodigoMarca((int) Long.parseLong(consulta.getString("mar_codigo")));
                bebidaVO.setCodigoTipo((int)Long.parseLong(consulta.getString("bebtip_codigo")));
                bebidaVO.setVolume(Long.parseLong(consulta.getString("beb_volume")));
                bebidaVO.setUnidade(consulta.getString("beb_unidade_medida"));
                bebidaVO.setPreco("R$ " + consulta.getString("beb_preco"));
                bebidaVO.setStatus(consulta.getString("beb_status"));
            
            bebida.add(bebidaVO);
            }
                
        } finally {

            conexao.desconectar();
            return bebida;
        }
    }
    
    public void editarBebida(BebidaVO bebidaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update bebida "
                + "set beb_nome = '"+bebidaVO.getMarca()+"  "+bebidaVO.getVolume()+bebidaVO.getUnidade()+ "', "
                + "mar_codigo = (SELECT mar_codigo FROM marca WHERE mar_nome= '"+ bebidaVO.getMarca()+"'), "
                + "bebtip_codigo = (SELECT bebtip_codigo FROM tipobebida WHERE bebtip_nome= '"+ bebidaVO.getTipo()+"'), "
                + "beb_volume = "+ bebidaVO.getVolume()+", "
                + "beb_unidade_medida= '"+ bebidaVO.getUnidade()+"', "
                + "beb_preco = "+ bebidaVO.getPreco()+", "
                + "beb_status = true where beb_codigo ="+bebidaVO.getCodigo();
                
            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirBebida(BebidaVO bebidaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from bebida where beb_codigo = " + bebidaVO.getCodigo();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}
