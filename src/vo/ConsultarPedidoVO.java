package vo;

/**
 *
 * @author MAIKON
 */
public class ConsultarPedidoVO {

    private String pedido_codigo;
    private String cliente_telefone;
    private String cliente_nome;

    public String getPedido_codigo() {
        return pedido_codigo;
    }

    public void setPedido_codigo(String pedido_codigo) {
        this.pedido_codigo = pedido_codigo;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }
}
