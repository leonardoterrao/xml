package xml;

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

import entidade.Pais;
import entidade.QuadroDeMedalhas;

public class ExportacaoDom {

	public void exportar(QuadroDeMedalhas quadroDeMedalhas, OutputStream out)
			throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation domImplementation = builder.getDOMImplementation();
		Document doc = domImplementation.createDocument(null,
				"quadroDeMedalhas", null);
		Element root = doc.getDocumentElement();

		for (Pais pais : quadroDeMedalhas.getPaises()) {
			Element paisElement = doc.createElement("pais");
			paisElement.setAttribute("nome", pais.getNome());
			paisElement.setAttribute("delegacao",
					Integer.toString(pais.getDelegacao()));
			root.appendChild(paisElement);

			Element ouroElement = doc.createElement("ouro");
			ouroElement.setTextContent(Integer.toString(pais.getOuros()));
			paisElement.appendChild(ouroElement);

			Element prataElement = doc.createElement("prata");
			prataElement.setTextContent(Integer.toString(pais.getPratas()));
			paisElement.appendChild(prataElement);

			Element bronzeElement = doc.createElement("bronze");
			bronzeElement.setTextContent(Integer.toString(pais.getBronzes()));
			paisElement.appendChild(bronzeElement);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(doc), new StreamResult(out));
	}
}