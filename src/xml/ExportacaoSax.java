package xml;

import static com.google.common.base.Preconditions.*;
import java.io.OutputStream;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import entidade.Pais;
import entidade.QuadroDeMedalhas;

public class ExportacaoSax {

	public void exportar(QuadroDeMedalhas quadroDeMedalhas, OutputStream out)
			throws Exception {
		checkNotNull(quadroDeMedalhas);
		checkNotNull(out);
		TransformerHandler handler = createHandler();
		handler.setResult(new StreamResult(out));
		handler.startDocument();

		AttributesImpl atts = new AttributesImpl();
		handler.startElement("", "", "quadroDeMedalhas", atts);
		for (Pais pais : quadroDeMedalhas.getPaises()) {
			atts.clear();
			atts.addAttribute("", "", "nome", "PCDATA", pais.getNome());
			atts.addAttribute("", "", "delegacao", "PCDATA",
					Integer.toString(pais.getDelegacao()));
			handler.startElement("", "", "pais", atts);
			atts.clear();
			exportarOuro(handler, pais);
			exportarPrata(handler, pais);
			exportarBronze(handler, pais);
			handler.endElement("", "", "pais");
		}
		handler.endElement("", "", "quadroDeMedalhas");
		handler.endDocument();
	}

	private void exportarBronze(TransformerHandler handler, Pais pais)
			throws SAXException {
		handler.startElement("", "", "bronze", new AttributesImpl());
		char[] bronzes = Integer.toString(pais.getBronzes()).toCharArray();
		handler.characters(bronzes, 0, bronzes.length);
		handler.endElement("", "", "bronze");
	}

	private void exportarPrata(TransformerHandler handler, Pais pais)
			throws SAXException {
		handler.startElement("", "", "prata", new AttributesImpl());
		char[] pratas = Integer.toString(pais.getPratas()).toCharArray();
		handler.characters(pratas, 0, pratas.length);
		handler.endElement("", "", "prata");
	}

	private void exportarOuro(TransformerHandler handler, Pais pais)
			throws SAXException {
		handler.startElement("", "", "ouro", new AttributesImpl());
		char[] ouros = Integer.toString(pais.getOuros()).toCharArray();
		handler.characters(ouros, 0, ouros.length);
		handler.endElement("", "", "ouro");
	}

	private TransformerHandler createHandler()
			throws TransformerConfigurationException,
			TransformerFactoryConfigurationError, IllegalArgumentException {
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();
		Transformer transformer = handler.getTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		return handler;
	}

}