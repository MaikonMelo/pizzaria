package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.EstadoVO;

/**
 *
 * @author MAIKON
 */
public class EstadoPR {

    Conexao conexao;

    public EstadoPR() {
        this.conexao = new Conexao();
    }

    public ArrayList<EstadoVO> listarComboEstado() throws SQLException, ClassNotFoundException, Exception {

        ArrayList<EstadoVO> combo = new ArrayList();

        String sql = "select * from estado";

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            EstadoVO estadoVO = new EstadoVO();
            estadoVO.setEst_nome(rs.getString("est_nome"));

            combo.add(estadoVO);
        }

        return combo;
    }

    public ArrayList<String> buscarEstado(int cod_estado) throws SQLException, Exception {

        ArrayList<String> estado = new ArrayList();

        String sql = "select * from estado where est_codigo=" + cod_estado;

        Connection con = conexao.conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            estado.add(rs.getString("est_nome"));
        }

        return estado;
    }
}
