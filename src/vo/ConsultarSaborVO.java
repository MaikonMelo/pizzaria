package vo;

/**
 *
 * @author MAIKON
 */
public class ConsultarSaborVO {

    private int sab_codigo;
    private String sab_nome;
    private float sab_preco;
    private String sab_ingredientes;
    private String sab_tipo;
    private boolean sab_status;

    public ConsultarSaborVO() {

    }

    public int getSab_codigo() {
        return sab_codigo;
    }

    public void setSab_codigo(int sab_codigo) {
        this.sab_codigo = sab_codigo;
    }

    public String getSab_nome() {
        return sab_nome;
    }

    public void setSab_nome(String sab_nome) {
        this.sab_nome = sab_nome;
    }

    public float getSab_preco() {
        return sab_preco;
    }

    public void setSab_preco(float sab_preco) {
        this.sab_preco = sab_preco;
    }

    public String getSab_ingredientes() {
        return sab_ingredientes;
    }

    public void setSab_ingredientes(String sab_ingredientes) {
        this.sab_ingredientes = sab_ingredientes;
    }

    public String getSab_tipo() {
        return sab_tipo;
    }

    public void setSab_tipo(String sab_tipo) {
        this.sab_tipo = sab_tipo;
    }

    public boolean isSab_status() {
        return sab_status;
    }

    public void setSab_status(boolean sab_status) {
        this.sab_status = sab_status;
    }
}
