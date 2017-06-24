
/*
Conexao.java é a classe resposável por gerenciar a abertura e fechamento da
conexão com a base de dados MySQL.
*/
package utilitarios;

//Importa todas as classe do Connectio do pacote sql essa classe é resposável
//abri e fechar a conexão.
import java.sql.Connection;

//Importa a classe DriverManagerque é reposável pela realização da comunicação
//entre a aplicação JAVA e a base de dados MySQL. É essa classe que gerencia
//a API JDBC
import java.sql.DriverManager;

//Importa a classe SQLException que trata os possíveis erros relacionados a
//base de dados.
import java.sql.SQLException;

//Declaração da classe resposável pelo gerenciamento da conexão.
public class Conexao {

    /*
    Declaração de um metodo estático para a abertura da conexão, observe que o
    método retorna um objeto da classe Connection. Sua declaração é estática pois
    assim não há necessidade de instaciar um objeto da classe Conexao para acessar
    o método, isso é válido pois existe a necessaidade de conexão com a base de 
    dados em quase toda a aplicação.
    */
    public static Connection abrirConexao() {
    
        //Cria uma variável que vai armazenar um objeto da classe Connertion.
        Connection con = null;
        
        /*Estrutura "try...catch" que tenta abrir a concexão (try) e caso ocorra
        algum erro trata a exceção (catch).
        */
        try{
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /*Variável do tipo string que vai armazenar a string de conexão com
            as infromações da localização do servidor de dados o nome da base de
            dados seu usuário e senha.
            */
            String url = "";
            
            /*Configuração na váriavel dos valores necessários para abrir uma
            conexão com a base de dados.
            */
            url += "jdbc:mysql://127.0.0.1/bd_urna?user=root&password=";
            
            /*
            Abre a conexão através do método "getConnection" da classe 
            DriverManager, esse método requer um parametro que nada mais é do
            que as infromações a respeito da localização do servidor de dados, 
            nome da base de dado, usuário e senha do banco de dados, isso é feito
            aqui informando a variavel "url" que armazena tais dados. Observe que
            o metodo "getConnection" retirna um objeto da "Connection" que é
            armazenado na variavel de mesmo tipo "con".
            */
            con = (Connection) DriverManager.getConnection(url);
            
            /*Apenas um controle de debug para exibir uma mensagem caso a conexão
            tenha sido aberta com sucesso. Essa linha pode ser comentada após o
            teste.
            */
            //System.out.println("Conexão aberta.");
        
        //Estrutra catch que trata as exceções de SQL vindas da base de dados.
        }catch (SQLException e) {
            
            /*
            Apenas exibe uma mensagem para debug.
            */
            System.out.println("ERRO AO CONECTAR COM O BANCO DE DADOS. ERRO: "
            + e.getMessage());
        
        //Estrutra catch que trata as exceções gerais.
        }catch (Exception e) {
            
            /*
            Apenas exibe uma mensagem para debug.
            */            
            System.out.println("ERRO: " + e.getMessage());
        
        }
        
        //Retorna um objeto de conexão.
        return con;
    
    
    }
    
    //Método estática para fechar a conexão com a base de dados.
    public static void fecharConexao(Connection con) {
    
        //Estrtura (try...catch)
        try{
        
            /*Fecha a conexão através do metodo "close()" da classe "Connection
            que é acessado pela varável "con" que armazena o objeto da classe em
            questão.
            */
            con.close();
            
            /*Apenas um controle de debug para exibir uma mensagem caso a conexão
            tenha sido fechada com sucesso. Essa linha pode ser comentada após o
            teste.
            */
            System.out.println("Conexão fechada.");
        
        //Estrutra catch que trata as exceções de SQL vindas da base de dados.
        }catch(SQLException e){
        
            /*
            Apenas exibe uma mensagem para debug.
            */
            System.out.println("ERRO AO DESCONECTAR COM O BANCO DE DADOS. ERRO:"
             + " " + e.getMessage());
         
        //Estrutra catch que trata as exceções gerais.
        }catch (Exception e) {
            
            /*
            Apenas exibe uma mensagem para debug.
            */            
             System.out.println("ERRO: " + e.getMessage());
            
        }
    
    }
    
}