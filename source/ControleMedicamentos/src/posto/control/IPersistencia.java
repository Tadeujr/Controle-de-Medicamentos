/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.io.IOException;

/**
 *
 * @author tadeu
 */
public interface IPersistencia {
    
    public void salvarDados(Object nome)throws IOException;
    
    public Object trazerDados(Object dado)throws IOException,ClassNotFoundException;
    
}
