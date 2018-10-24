/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.view;

import java.io.IOException;
import javax.swing.JOptionPane;
import posto.control.cadastrarFuncionario;
import posto.control.cadastrarMedicamento;
import posto.control.exibirDados;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;

/**
 *
 * @author tadeu
 */
public class MenuApresentacao {
    
    public void Menu() throws IOException, ClassNotFoundException{
         String menu = JOptionPane.showInputDialog("Cadastra Fucionário: 1 "
                 + "\nCadastrar Medicamento: 2"
                 + "\nMostrar Medicamentos: 3"
                 + "\nMostrar Funcionário: 4"
                 + "\nSair: 0");
         int opcao = Integer.parseInt(menu);
         
         while(opcao != 0){
            cadastrarMedicamento cad = new cadastrarMedicamento();
            cadastrarFuncionario cadF = new cadastrarFuncionario();
             
                //Opções Menu
            if(opcao == 1){
                 String nome = JOptionPane.showInputDialog("Nome");
                 String rg = JOptionPane.showInputDialog("Rg");
                 String senha = JOptionPane.showInputDialog("Senha");
                 Funcionario nFuncionario = new Funcionario(nome ,rg); // pesquisa metodo de crptografia
                 cadF.cadastrarFuncionario(nFuncionario);
             
            }
             
            if(opcao == 2){
                 String medicamento = JOptionPane.showInputDialog("Medicamento");
                 String validade = JOptionPane.showInputDialog("validade");
                 String lote = JOptionPane.showInputDialog("lote");
                 String qtdDisponivel = JOptionPane.showInputDialog("Quantidade");
                 String descricao = JOptionPane.showInputDialog("Descricao");
                 int qtd = Integer.parseInt(qtdDisponivel);
                 
                 /*CRIAÇÃO MEDICAMENTO -> SALVAnDO EM ARQUIVO E ABRINDO*/
                
                 Medicamento nMedicamento = new Medicamento(descricao,medicamento,validade ,lote ,qtd);
                 
                                        /*enviando objeto para cadastrar*/
                //cad.cadastrarMedicamento(nMedicamento);
                 
            }           
            
            if(opcao == 3){

                exibirDados saida1 = new exibirDados();
                Medicamento aMedicamento = null;
                        /*Abrindo  arquivo*/
                //aMedicamento = (Medicamento)cad.buscarMedicamento(aMedicamento, "dadosfarmacia");        
                /*Mostrando na tela*/
                saida1.exibirMedicamentos(aMedicamento);
            } 
            
            if(opcao == 4){
                Funcionario mFuncionario = null;
                exibirDados saida = new exibirDados();
                //mFuncionario = (Funcionario)cadF.buscarFuncionario(mFuncionario,"funcionario");
                //saida.exibirFuncionario(mFuncionario);
            }
            menu = JOptionPane.showInputDialog("Cadastra Fucionário: 1 "
                             + "\nCadastrar Medicamento: 2"
                             + "\nMostrar Medicamentos: 3"
                             + "\nMostrar Funcionário: 4"
                             + "\nSair: 0");
            
            opcao = Integer.parseInt(menu);
         }
    
    }
    
}
