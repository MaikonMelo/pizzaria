package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.TipoBebidaVO;

/**
 *
 * @author MAIKON
 */
public class TipoBebidaPR {

    Conexao conexao;

    public TipoBebidaPR() {

        this.conexao = new Conexao();
    }

    public ArrayList<TipoBebidaVO> buscarTiposBebidas() throws SQLException, Exception {

        ArrayList<TipoBebidaVO> tipoBebida = new ArrayList();

        try {

            Connection con;
            Statement stm;
            ResultSet consulta;

            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from tipobebida order by bebtip_codigo");

            while (consulta.next()) {

                TipoBebidaVO tipoBebidaVO = new TipoBebidaVO();

                tipoBebidaVO.setBebtip_codigo(consulta.getInt("bebtip_codigo"));
                tipoBebidaVO.setBebtip_nome(consulta.getString("bebtip_nome"));

                tipoBebida.add(tipoBebidaVO);
            }

        } finally {

            conexao.desconectar();
            return tipoBebida;
        }
    }

    public void excluirTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from tipobebida where bebtip_codigo = " + tipoBebidaVO.getBebtip_codigo();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void cadastrarTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "insert into tipobebida (bebtip_nome) values('" + tipoBebidaVO.getBebtip_nome()+ "');";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void editarTipoBebida(TipoBebidaVO tipoBebidaVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update tipobebida "
                + "set bebtip_nome = '" + tipoBebidaVO.getBebtip_nome() + "' "
                + "where bebtip_codigo = " + tipoBebidaVO.getBebtip_codigo();

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}
