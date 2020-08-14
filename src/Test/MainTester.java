package Test;

import DataBase.ConnectionDB;
import DataBase.DaoCliente;
import DataBase.DaoInterface;
import DataBase.DaoPedido;

/**
 * Classe testa funcionalidades do servidor
 * @author Nicolas Vycas Nery
 */

public class MainTester {
    public static void main(String args[]){
        MainTester mt = new MainTester();
        if(args.length != 0){
            for(String arg: args){
                arg = arg.toUpperCase();
                switch (arg){
                    case"TestConnection":
                        mt.testConexao();
                        break;
                    case"TestDao":
                        mt.testDaos();
                        break;
                    default:
                        System.out.println("Argumentos invalidos...");
                    case"CompleteTest":
                        System.out.println("Fazendo teste completo...");
                        mt.testConexao();
                        mt.testDaos();
                        break;
                }
            }
        }else{
            System.out.println("Sem argumentos...");
            System.out.println("Fazendo teste completo...");
            mt.testConexao();
            mt.testDaos();
        }
    }
    ConnectionDB conn;
    private void testConexao(){
        System.out.println("Fazendo teste de conexão...");
        conn = ConnectionDB.getInstancia();
        systemPause();
    }
    private void testDaos(){
        System.out.println("Fazendo teste de Objetos de acesso a dados...");
        conn = ConnectionDB.getInstancia();
        DaoInterface dP,dC;
        //Testando instaciamento
        dP = new DaoPedido();
        dC = new DaoCliente();
        systemPause();
    }
    private void systemPause(){
        System.out.println("Precione qualuer tecla para continuar…");
        new java.util.Scanner(System.in).nextLine();
    }
}
