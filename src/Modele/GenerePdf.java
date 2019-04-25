package Modele;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 * <h1><i>GenerePdf</i></h1>
 * <h2><code>public class GenerePdf</code></h2>
 * <p>Cette classe s'appuie sur <b><span class='name'>iText</span></b>, qui possède des classes pour gérer tout ce qui concerne l'écriture
 * dans un fichier pdf. Très pratique d'ailleurs, il permet aussi de faire des tableaux, d'afficher, des images, ...</p>
 */
public class GenerePdf {
	
	private Document document;
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public GenerePdf()</code></h2>
	 * <p>Constructeur vide de la classe GenerePdf.<br>Génère un <b>.pdf</b> avec pour seul contenu "HelloiText.pdf".</p>
	 */
	public GenerePdf() {
		
		document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("HelloiText.pdf"));
			document.open();
			populate(document);
		}
		catch(Exception e) {
			System.err.println(e);
		}
		finally {
			document.close();
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>Constructeur</i></h1>
 	 * <h2><code>public GenerePdf(<span class='name'>Historique</span> histo, <span class='name'>File</span> file)</code></h2>
	 * <p>Génère un <b>.pdf</b> à partir de l'historique et du nom de fichier donnés en paramètre.</p> 
	 * 
	 * @param histo : (Historique) Historique du simplexe en cours
	 * @param file : (File)
	 * 
	 * @see Historique
	 */
	public GenerePdf(Historique histo, File file) {
		
		document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			populate(document, histo);
		}
		catch(Exception e) {
			System.err.println(e);
		}
		finally {
			document.close();
		}
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>populate</i></h1>
 	 * <h2><code>public void populate(<span class='name'>Document</span> doc)</code></h2>
	 * <p>Ajoute un paragrapĥe "Hello iText" au document <b>.pdf</b>.</p>
	 * @param doc : (Document)
	 *
	 * @throws DocumentException : Exception concernant une erreur lors de la génération du pdf
	 *
	 * @see Document
	 */
	public void populate(Document doc) throws DocumentException{
		doc.add(new Paragraph("Hello iText"));
	}
	
	/**
	 * <style> body{ margin-left: 15px; margin-right: 15px; } code{ font-family: Consolas; } h1{ text-decoration: underline; } .name{ color: #4286f4; }</style>
 	 * <h1><i>populate</i></h1>
 	 * <h2><code>public populate(<span class='name'>Document</span> doc, <span class='name'>Historique</span> histo)</code></h2>
	 * <p>Ajoute des paragraphes correspondant à chaque <code class='name'>Simplexe</code> composant l'historique donné en paramètre au document <b>.pdf</b>.</p>
	 * 
	 * @param doc : (Document)
	 * @param histo : (Historique)
	 *
	 * @throws DocumentException : Exception concernant les erreurs de génération du pdf
	 * 
	 * @see Historique
	 * @see Document
	 */
	public void populate(Document doc, Historique histo) throws DocumentException {
		Font f = new Font(FontFamily.COURIER);
		int i = 0;
		doc.add(new Paragraph("Listes des dictionnaires",new Font(FontFamily.TIMES_ROMAN,20,Font.BOLD | Font.UNDERLINE)));
		for(Simplexe s : histo.getListeSimplexe()) {
			doc.add(new Paragraph("\n\nDictionnaire n°"+Integer.toString(i)+"\n"+s.toString2(),f));
			i++;
		}
		
		if(histo.getListeSimplexe().getLast().echangeJudicieux().contains("bénéfice")) {
			doc.add(new Paragraph("\nBénéfice maximum : "+histo.getListeSimplexe().getLast().getFonctionEco().getMonomes().get(" "),f));
		}
	}

}
