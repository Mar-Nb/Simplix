package Modele;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerePdf {
	
	private Document document;
	
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
	
	public GenerePdf(Historique histo, String nomFichier) {
		
		document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("PDF"+File.separator+nomFichier+".pdf"));
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
	
	public void populate(Document doc) throws DocumentException{
		doc.add(new Paragraph("Hello iText"));
	}
	
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
