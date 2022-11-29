/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoglobal;

/**
 *
 */
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
public class XMLModel {

    private ArrayList<Incidencia> almaLibros;

    public ArrayList<Incidencia> getAlmaLibros() {
        return almaLibros;
    }

//    @XmlElement(name = "Libro")
    public void setAlmaIncidencias(ArrayList<Incidencia> almaLibros) {
        this.almaLibros = almaLibros;
    }

    public XMLModel() {
    }

    

    public static void actualizarfichero(ArrayList<Incidencia> alma) {

        try {
            //llistaLlibres.add(llibre);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            DOMImplementation imp = dBuilder.getDOMImplementation();

            Document documento = imp.createDocument(null, "incidendias", null);
            documento.setXmlVersion("1.0");

            //crea llibre
            for (Incidencia inci : alma) {
                Element incidencia = documento.createElement("incidencia");
                incidencia.setAttribute("id", String.valueOf(inci.getId()));

                //crea titul
                Element nombre = documento.createElement("nombre");
                Text nombreTXT = documento.createTextNode(inci.getNombre());
                nombre.appendChild(nombreTXT);
                incidencia.appendChild(nombre);

                //crea apellido
                Element apellido = documento.createElement("apellidos");
                Text autorTXT = documento.createTextNode(inci.getApellidos());
                apellido.appendChild(autorTXT);
                incidencia.appendChild(apellido);

                //crea any
                Element inciden = documento.createElement("inci");
                Text añoTXT = documento.createTextNode(String.valueOf(inci.getInci()));
                inciden.appendChild(añoTXT);
                incidencia.appendChild(inciden);

                //crea editorial
               

                documento.getDocumentElement().appendChild(incidencia);
            }

            Source src = new DOMSource(documento);
            Result res = new StreamResult(new File("incidencias2.xml"));

            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(src, res);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static ArrayList<Incidencia> leerFichero() {
        ArrayList<Incidencia> almainci = new ArrayList<>();
        NodeList nodeList;
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document document = dBuilder.parse(new File("incidencias2.xml"));

            nodeList = document.getElementsByTagName("incidencia");
            document.getDocumentElement().normalize();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Incidencia inci = new Incidencia();
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) node;
                    inci.setId(Integer.parseInt(elemento.getAttribute("id")));
                    inci.setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    inci.setApellidos(elemento.getElementsByTagName("apellidos").item(0).getTextContent());           
                    inci.setInci(elemento.getElementsByTagName("inci").item(0).getTextContent());
                    

                    almainci.add(inci);

                }

            }

        } catch (Exception e) {

        }
        return almainci;

    }

}
