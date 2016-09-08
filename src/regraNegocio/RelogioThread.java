/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regraNegocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import visao.Principal;

/**
 *
 * @author Leonardo
 */
public class RelogioThread extends Thread{
    Principal telaPrincipal;

    public RelogioThread(Principal principal){
        super();
        this.telaPrincipal=principal;
    }
    
    @Override
    public void run(){
        try {
            DateFormat dateformat;
            Date date;
            
            while(true){
                dateformat=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                date=new Date();
                String dataFormatada = dateformat.format(date);
                
                telaPrincipal.getData().setText(dataFormatada);
                this.sleep(1000);
                }
        } catch (Exception e) {
        }
    }
    
    
    
}
