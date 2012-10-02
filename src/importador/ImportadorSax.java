package importador;

import java.io.InputStream;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entidade.Candidato;
import entidade.Eleicoes;

public class ImportadorSax implements Importador {

    @Override
    public Eleicoes importar(InputStream in) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser parser = spf.newSAXParser();
        final Eleicoes eleicoes = new Eleicoes();
        parser.parse(in, new DefaultHandler() {

            private Elemento elemento = Elemento.NENHUM;
            private String partido;
            private String nome;
            private int votos;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("candidato".equals(localName)) {
                    elemento = Elemento.fromString(uri);
                }
                partido = attributes.getValue("partido");
                nome = attributes.getValue("nome");
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (EnumSet.of(Elemento.PREFEITO, Elemento.VEREADOR).contains(elemento)) {
                    votos = Integer.parseInt(new String(ch, start, length));
                }
            }
 
            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                elemento.adicionarNasEleicoes(eleicoes, partido, nome, votos);
                elemento = Elemento.NENHUM;
            }
        });
        return eleicoes;
    }

    private static enum Elemento {

        PREFEITO("http://www.tre.gov.br/prefeito") {

            @Override
            public void adicionarNasEleicoes(Eleicoes eleicoes, String partido, String nome, int votos) {
                eleicoes.addVotoParaPrefeito(Candidato.newPrefeito(partido, nome, votos));
            }
        }, //
        VEREADOR("http://www.tre.gov.br/vereador") {

            @Override
            public void adicionarNasEleicoes(Eleicoes eleicoes, String partido, String nome, int votos) {
                eleicoes.addVotoParaVereador(Candidato.newVereador(partido, nome, votos));
            }
        }, //
        NENHUM(null) {

            @Override
            public void adicionarNasEleicoes(Eleicoes eleicoes, String partido, String nome, int votos) {
            }
        };
        
        private static final Map<String, Elemento> values = new HashMap<String, Elemento>();

        static {
            for (Elemento elemento : values()) {
                values.put(elemento.uri, elemento);
            }
        }

        public static Elemento fromString(String uri) {
            return values.get(uri);
        }
        private final String uri;

        private Elemento(String uri) {
            this.uri = uri;
        }

        public abstract void adicionarNasEleicoes(Eleicoes eleicoes, String partido, String nome, int votos);
    }
}
