/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author tadeu
 */
public class OperarcoesArq implements IPersistencia{
    
    String nomeArq;

    public OperarcoesArq(String nomeArq) {
        this.nomeArq = nomeArq;
    }
    
    
    @Override
    public void salvarDados(Object dado) throws IOException {
        String current = new java.io.File( "." ).getCanonicalPath();        
        
               
        FileOutputStream fileSerializado = new FileOutputStream( 
                current + "\\src\\" + this.nomeArq + ".ser");                
        ObjectOutputStream outputSerializado = new ObjectOutputStream(fileSerializado);        
        outputSerializado.writeObject(dado);
        outputSerializado.close();
        
        System.out.println("Dados Salvo");        

    }

    @Override
    public Object trazerDados(Object dado) throws IOException, ClassNotFoundException {
        //Object user = null; vou receber o tipo na função para ser generica
        String current = new java.io.File(".").getCanonicalPath();
        FileInputStream fileIn = new FileInputStream(current + "\\src\\" + this.nomeArq + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        dado = in.readObject();
        in.close();
        
        return dado;

    }




    
}
