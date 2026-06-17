package allumettes;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Deroulement {

    private Document document;
    private Element racine;

    public Deroulement() {
        try {
            DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
            this.document = fabrique.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
        this.racine = this.document.createElement("deroulement");
        this.document.appendChild(this.racine);
    }

    public void ajouterCoup(int numero, String joueur, int prises) {
        Element coup = this.document.createElement("coup");
        coup.setAttribute("numero", String.valueOf(numero));
        coup.setAttribute("joueur", joueur);
        coup.setAttribute("prises", String.valueOf(prises));
        this.racine.appendChild(coup);
    }

    public void gagnant(String nom) {
        ajouterResultat("gagnant", nom);
    }

    public void tricheur(String nom) {
        ajouterResultat("tricheur", nom);
    }

    private void ajouterResultat(String attribut, String nom) {
        Element resultat = this.document.createElement("resultat");
        resultat.setAttribute(attribut, nom);
        this.racine.appendChild(resultat);
    }

    public void ecrire(String fichier) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "deroulement.dtd");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(this.document),
                    new StreamResult(new File(fichier)));
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }
}
