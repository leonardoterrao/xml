package importador;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entidade.Candidato;
import entidade.Eleicoes;

public class ImportadorDom implements Importador {

    @Override
    public Eleicoes importar(InputStream in) throws Exception {
        Element root = obterElementoRaiz(in);
        NodeList prefeitoNodeList = filtrarPrefeitos(root);
        Eleicoes eleicoes = new Eleicoes();
        for (int i = 0; i < prefeitoNodeList.getLength(); i++) {
            eleicoes.addVotoParaPrefeito(Candidato.newPrefeito(prefeitoNodeList.item(i)));
        }
        NodeList vereadoresNodeList = filtrarVereadores(root);
        for (int i = 0; i < vereadoresNodeList.getLength(); i++) {
            eleicoes.addVotoParaVereador(Candidato.newVereador(vereadoresNodeList.item(i)));
        }
        return eleicoes;
    }

    private NodeList filtrarPrefeitos(Element root) throws DOMException {
        return root.getElementsByTagNameNS("http://www.tre.gov.br/prefeito", "candidato");
    }

    private NodeList filtrarVereadores(Element root) throws DOMException {
        return root.getElementsByTagNameNS("http://www.tre.gov.br/vereador", "candidato");
    }

    private Element obterElementoRaiz(InputStream in) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(in);
        return doc.getDocumentElement();
    }
}
