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
import java.util.Date;
import javax.swing.JOptionPane;
import persistencia.RelatorioPeriodoPR;
import vo.RelatorioVO;

/**
 *
 * @author Leonardo
 */
public class RelatorioPeriodoRN {
    public File gerarRelatorio(Date dtInicial, Date dtFinal, String caminho)throws HeadlessException, IOException, Exception {
        RelatorioPeriodoPR relatoriopr=new RelatorioPeriodoPR();
        ArrayList <RelatorioVO> pedidos=relatoriopr.gerarRelatorio(dtInicial, dtFinal);
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
