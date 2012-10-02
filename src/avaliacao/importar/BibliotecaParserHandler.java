package avaliacao.importar;

import java.util.EnumSet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import avaliacao.entidade.Autor;
import avaliacao.entidade.Biblioteca;
import avaliacao.entidade.Livro;

public class BibliotecaParserHandler extends DefaultHandler {

	private Elemento elemento = Elemento.NENHUM;
	private String tituloAutor;
	private String tituloLivro;
	private String isbn;
	private String nome;
	private final Biblioteca biblioteca;

	public BibliotecaParserHandler(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if ("livro".equals(localName)) {
			isbn = attributes.getValue("isbn");

		} else if ("titulo".equals(localName)) {
			elemento = Elemento.fromString(uri);

		} else if ("nome".equals(localName)) {
			elemento = Elemento.fromString(localName);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (EnumSet.of(Elemento.LIVRO).contains(elemento)) {
			tituloLivro = new String(ch, start, length);

		} else if (EnumSet.of(Elemento.AUTOR).contains(elemento)) {
			tituloAutor = new String(ch, start, length);

		} else if (EnumSet.of(Elemento.NOME).contains(elemento)) {
			nome = new String(ch, start, length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (elemento.equals(Elemento.NOME)) {
			Livro livro = new Livro(tituloLivro, isbn, new Autor(tituloAutor, nome));
			elemento.adicionarLivro(biblioteca, livro);
		}
		elemento = Elemento.NENHUM;
	}
}
