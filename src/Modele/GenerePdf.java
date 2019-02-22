package Modele;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerePdf {
	
	Document document;
	
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
	
	public void populate(Document doc) throws DocumentException{
		doc.add(new Paragraph("Hello iText"));
	}

}
