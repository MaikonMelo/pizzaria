/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.ConsultarClientePR;
import persistencia.RelatorioClientePR;
import vo.ConsultarClienteVO;
import vo.RelatorioVO;
/**
 *
 * @author Leonardo
 */
public class RelatorioClienteRN {
    public File gerarRelatorio(long tel, String caminho)throws HeadlessException, IOException, Exception {
        RelatorioClientePR relatoriopr=new RelatorioClientePR();
        ConsultarClientePR consultarCliente=new ConsultarClientePR();
        ConsultarClienteVO clientevo=consultarCliente.buscarCliente(tel);
        ArrayList <RelatorioVO> pedidos=relatoriopr.gerarRelatorio(tel);
        File file = new File(caminho);
        if (file.exists()){
                int opt=JOptionPane.showConfirmDialog(null, "O Seu Arquivo já existe.\n DesejaSobrescrever esse arquivo? ", "Tela", JOptionPane.YES_NO_OPTION);
                if(opt==0){
                    file.delete();
                    file.createNewFile();
                }
        }else{
            file=new File(caminho);
            file.createNewFile();
        }

        BufferedWriter escrever=new BufferedWriter(new FileWriter(file.getAbsolutePath()));
        
        escrever.write("Nome \t");
        escrever.write("Telefone \t");
        escrever.newLine();
        escrever.write(clientevo.getNome()+"\t");
        escrever.write(clientevo.getTelefone().toString()+"\t");
        escrever.newLine();
        escrever.write("Endereco \t");
        escrever.newLine();
        escrever.write("CEP \t");
        escrever.write("Estado \t");
        escrever.write("Cidade \t");
        escrever.write("Bairro \t");
        escrever.newLine();
        escrever.write(clientevo.getCep()+"\t");
        escrever.write(clientevo.getEstado()+"\t");
        escrever.write(clientevo.getCidade()+"\t");
        escrever.write(clientevo.getBairro()+"\t");
        escrever.newLine();
        escrever.write("Logradouro \t");
        escrever.write("Numero \t");
        escrever.write("Complemento \t");
        escrever.newLine();
        escrever.write(clientevo.getLogradouro()+"\t");
        escrever.write(clientevo.getNumerocasa()+"\t");
        escrever.write(clientevo.getComplemento()+"\t");
        escrever.newLine();
        escrever.write("Pedidos");
        escrever.newLine();
        escrever.write("Codigo \t");
        escrever.write("Data do Pedido \t");
        escrever.write("Quant. \t");
        escrever.write("Tamanho \t");
        escrever.write("Sabores \t");
        escrever.write("Borda \t");
        escrever.write("Bebida \t");
        escrever.write("Valor Unitário \t");
        escrever.write("Total \t");
        escrever.write("Total do Pedido \t");
        escrever.newLine();

        int i;
        for(RelatorioVO relatoriovo : pedidos){
            escrever.write(relatoriovo.getCodigo()+"\t");
            escrever.write(relatoriovo.getData()+"\t");
            escrever.write(relatoriovo.getQuant()+"\t");
            escrever.write(relatoriovo.getTamanho()+"\t");
            escrever.write(relatoriovo.getSabores()+"\t");
            escrever.write(relatoriovo.getBorda()+"\t");
            escrever.write(relatoriovo.getBebida()+"\t");
            escrever.write(relatoriovo.getValor_unit()+"\t");
            escrever.write(relatoriovo.getTotal()+"\t");
            escrever.write(relatoriovo.getValor_total());
            escrever.newLine();
        }
        escrever.close();
        return file;
    }
    
}
