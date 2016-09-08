package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import vo.LogradouroVO;

/**
 *
 * @author MAIKON
 */
public class LogradouroPR {

    Conexao conexao;

    public LogradouroPR() {
        this.conexao = new Conexao();
    }

    public ArrayList<LogradouroVO> buscarCEP() throws SQLException, Exception {

        ArrayList<LogradouroVO> cep = new ArrayList();

        try {

            Connection con;
            Statement stm;
            ResultSet consulta;

            con = conexao.conectar();
            stm = con.createStatement();
            consulta = stm.executeQuery("select * from logradouro");

            while (consulta.next()) {

                LogradouroVO logradouroVO = new LogradouroVO();

                logradouroVO.setLog_bairro(consulta.getString("log_bairro"));
                logradouroVO.setLog_cep(consulta.getString("log_cep"));
                logradouroVO.setLog_cidade(consulta.getString("log_cidade"));
                logradouroVO.setLog_estado(consulta.getInt("log_estado"));
                logradouroVO.setLog_logradouro(consulta.getString("log_logradouro"));

                cep.add(logradouroVO);
            }

        } finally {

            conexao.desconectar();
            return cep;
        }
    }

    public void cadastrarCep(LogradouroVO logradouroVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "insert into logradouro (log_cep, log_estado, log_cidade, log_logradouro, log_bairro) "
                    + "values('" + logradouroVO.getLog_cep() + "', "
                    + logradouroVO.getLog_estado() + ", "
                    + "'" + logradouroVO.getLog_cidade() + "', "
                    + "'" + logradouroVO.getLog_logradouro() + "', "
                    + "'" + logradouroVO.getLog_bairro() + "');";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }

    }

    public void atualizarCep(LogradouroVO logradouroVO) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "update logradouro "
                    + "set log_estado = '" + logradouroVO.getLog_estado() + "', "
                    + "log_cidade = '" + logradouroVO.getLog_cidade() + "', "
                    + "log_logradouro = '" + logradouroVO.getLog_logradouro() + "', "
                    + "log_bairro = '" + logradouroVO.getLog_bairro() + "' "
                    + "where log_cep = '" + logradouroVO.getLog_cep() + "'";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
    
    public void excluirCEP(String codigo) throws SQLException, Exception {

        try {

            Connection con;
            Statement stm;
            String sql;

            con = conexao.conectar();

            stm = con.createStatement();
            sql = "delete from logradouro where log_cep = '" + codigo + "'";

            stm.executeUpdate(sql);

        } finally {

            conexao.desconectar();
        }
    }
}
