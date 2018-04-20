package XmlmMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author enzo
 */
public class FiltraArquivo {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        Scanner ler = new Scanner(System.in);

        List<String[]> listaCaes = new ArrayList<String[]>();

        System.out.println("Informe o Local/Caminho do arquivo e o nome (Exemplo pasta/pasta/nome_arquivo.xml) :");
        String nome = ler.nextLine();
        int numlinhas = 0;

        System.out.println("\nConteúdo do arquivo: \n");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(nome);                                           //Declarando Caminho do Arquivo XML

        NodeList ListaDePessoas = doc.getElementsByTagName("pessoa");                 //Criando Lista para receber arquivos de "PESSOA"

        int TamanhoLista = ListaDePessoas.getLength();                                //Criando Variável TamanhoLista pra receber o tamanho da lista

        for (int i = 0; i < TamanhoLista; i++) {                                      //Criando um FOR p/ percorrer todos os dados de "PESSOA"

            Node noPessoa = ListaDePessoas.item(i);

            if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {                        //Se NóPessoa for Igual a um Elemento Nó, então Printa os dados declarado

                Element elementoPessoa = (Element) noPessoa;

                String id = elementoPessoa.getAttribute("id");                        //Declarando String ID p/ receber ID do arquivo XML

                System.out.println("ID: " + elementoPessoa.getAttribute("id"));       //Printando ID do Documento

                NodeList listaDeDados = elementoPessoa.getChildNodes();               //Criando lista de Dados dos elementos

                int tamanholistaDeDados = listaDeDados.getLength();                   //Criando Lista pra receber Tamanho da Lista de Dados dentro de "PESSOAS"

                for (int j = 0; j < tamanholistaDeDados; j++) {                       //Criando um FOR p/ percorrer todos os dados nós de "PESSOA"

                    Node noDados = listaDeDados.item(j);                              //Novo NÓ para pegar os DadosFilhos de "PESSOA"

                    if (noDados.getNodeType() == Node.ELEMENT_NODE) {

                        Element elementoDados = (Element) noDados;

                        switch (elementoDados.getTagName()) {

                            case "name":
                                System.out.println("Nome: " + elementoDados.getTextContent());          //Pega o dado do tipo <NAME> e printa na tela
                                break;

                            case "phone":
                                System.out.println("Telefone: " + elementoDados.getTextContent());      //Pega o dado do tipo <PHONE> e printa na tela
                                break;

                            case "fax":
                                System.out.println("Fax: " + elementoDados.getTextContent());           //Pega o dado do tipo <FAX> e printa na tela
                                break;

                            case "website":
                                System.out.println("WebSite: " + elementoDados.getTextContent());       //Pega o dado do tipo <WEBSITE> e printa na tela
                                break;

                            case "address":
                                System.out.println("Endereço: " + elementoDados.getTextContent());      //Pega o dado do tipo <ADDRESS> e printa na tela
                                break;

                            case "email":
                                System.out.println("Email: " + elementoDados.getTextContent());         //Pega o dado do tipo <EMAIL> e printa na tela
                                System.out.println("\n");                                               //Pega o dado do tipo <EMAIL> e printa na tela
                                break;

                        }

                    }

                }
            }

        }

    }

}
