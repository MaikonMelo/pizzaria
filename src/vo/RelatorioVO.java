/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class RelatorioVO {
    private String codigo;
    private String quant;
    private String telefone;
    private String data;
    private String valor_total;
    private String valor_unit;
    private String total;
    private String sabores;
    private String borda;
    private String bebida;
    private String tamanho;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the quant
     */
    public String getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(String quant) {
        this.quant = quant;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valor_total
     */
    public String getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the valor_unit
     */
    public String getValor_unit() {
        return valor_unit;
    }

    /**
     * @param valor_unit the valor_unit to set
     */
    public void setValor_unit(String valor_unit) {
        this.valor_unit = valor_unit;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the sabores
     */
    public String getSabores() {
        return sabores;
    }

    /**
     * @param sabores the sabores to set
     */
    public void setSabores(String sabores) {
        this.sabores = sabores;
    }

    /**
     * @return the borda
     */
    public String getBorda() {
        return borda;
    }

    /**
     * @param borda the borda to set
     */
    public void setBorda(String borda) {
        this.borda = borda;
    }

    /**
     * @return the bebida
     */
    public String getBebida() {
        return bebida;
    }

    /**
     * @param bebida the bebida to set
     */
    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}