package avaliacao.exportar;

import avaliacao.entidade.Biblioteca;
import avaliacao.entidade.Livro;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportarDom {
    
    public void exportar(Biblioteca biblioteca, OutputStream os) throws Exception{
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation domImplementation = builder.getDOMImplementation();
        Document doc = domImplementation.createDocument(null, "biblioteca", null);

        Element root = doc.getDocumentElement();

        for (Livro livro : biblioteca.getLivros()) {
            Element livroElement = doc.createElement("livro");
            livroElement.setAttribute("isbn", livro.getIsbn());
            root.appendChild(livroElement);

            Element livroTitulo = doc.createElementNS("http://www.biblioteca.com.br/livro", "titulo");
            livroTitulo.setTextContent(livro.getTitulo());
            livroElement.appendChild(livroTitulo);

            Element autorElement = doc.createElement("autor");
            livroElement.appendChild(autorElement);
            
            Element autorTitulo = doc.createElementNS("http://www.biblioteca.com.br/autor", "titulo");
            autorTitulo.setTextContent(livro.getAutor().getTitulo());
            autorElement.appendChild(autorTitulo);
            
            Element autorNome = doc.createElement("nome");
            autorNome.setTextContent(livro.getAutor().getNome());
            autorElement.appendChild(autorNome);
        }
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(os));
        
    }

}