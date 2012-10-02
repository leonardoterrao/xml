package avaliacao.importar;

import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import avaliacao.entidade.Biblioteca;

public class ImportarSax {

	public Biblioteca importar(InputStream in) throws Exception {
		final Biblioteca biblioteca = new Biblioteca();
		obterSaxParser().parse(in, new BibliotecaParserHandler(biblioteca));
		return biblioteca;
	}

	private SAXParser obterSaxParser() throws ParserConfigurationException, SAXException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		SAXParser parser = spf.newSAXParser();
		return parser;
	}
}