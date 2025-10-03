import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;

public class XPathDOM {

    public static void main(String[] args) {

        try {
            // Crear una instancia de DocumentBuilderFactory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Configurar la factoria para que el fichero que se carga está bien validado e
            // ignora espacios en blanco.
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            // se crea un objeto DocumentBuilder por medio de la factoría creada
            // previamente.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Especificar el archivo XML que deseas analizar.
            File file = new File("C:\\Users\\PC218\\Documents\\GitHub\\Acceso-a-Datos\\TEMA3\\fichero.xml");

            // Parsear (analizar) el archivo XML y obtener un objeto Document.
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // Crear un objeto XPath para consultar el documento XML
            XPath xPath = XPathFactory.newInstance().newXPath();

            // Definir la expresión XPath para obtener todas las bibliotecas
            String expresion = "/libraries/library";

            // Evaluar la expresión y obtener una lista de nodos de bibliotecas
            NodeList nodeList = (NodeList) xPath.compile(expresion).evaluate(doc, XPathConstants.NODESET);

            // Iterar a través de la lista de nodos de biblliotecas (recorrer los nodos)
            for (int i = 0; i < nodeList.getLength(); i++) {

                Node nNode = nodeList.item(i);
                System.out.println("\nElemento actual: " + nNode.getNodeName());
                System.out.println("\nElemento padre: " + nNode.getParentNode().getNodeName());
                // Si el tipo coincide que muestre lo siguiente
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) nNode;
                    System.out.println("Nombre: " + elemento.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Ciudad: " + elemento.getAttribute("location"));
                    
                    //Para sacar los datos de los libros
                    String expresion2 = "books/book";
                    //Creamos otra lista con la expresion de libros y en lugar de desde un documento, es desde el nodo (nNode)
                    NodeList nodeList2 = (NodeList) xPath.compile(expresion2).evaluate(nNode, XPathConstants.NODESET); 
                    
                    //Creamos un mismo bucle para sacar los libros
                    for (int j = 0; j < nodeList2.getLength(); j++) {
                        
                        Node nNode2 = nodeList2.item(j);

                        if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

                            Element elemento2 = (Element) nNode2;
                            System.out.println(
                                    "Titulo: " + elemento2.getElementsByTagName("title").item(0).getTextContent());
                            System.out.println(
                                    "Autor: " + elemento2.getElementsByTagName("author").item(0).getTextContent());
                            System.out.println(
                                    "Genero: " + elemento2.getElementsByTagName("genre").item(0).getTextContent());
                            System.out
                                    .println("Año: " + elemento2.getElementsByTagName("year").item(0).getTextContent());

                            System.out.println("==================");

                        }
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
