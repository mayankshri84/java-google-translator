package translator;


import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFHelper {

	private static void writeUsingIText(String fileName, String text) {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File(fileName)));
			// open
			document.open();

			Paragraph p = new Paragraph();
			p.add(text);
			p.setAlignment(Element.ALIGN_CENTER);

			document.add(p);

			/*
			 * Paragraph p2 = new Paragraph(); p2.add("This is my paragraph 2");
			 * //no alignment
			 * 
			 * document.add(p2);
			 * 
			 * Font f = new Font(); f.setStyle(Font.BOLD); f.setSize(8);
			 * 
			 * document.add(new Paragraph("This is my paragraph 3", f));
			 */
			// close
			document.close();

			System.out.println("Done");

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String pdfReader(String filePath) {
		PdfReader reader;
		StringBuilder str = new StringBuilder();
		try {

			reader = new PdfReader(filePath);

			// pageNumber = 1
			String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

			System.out.println(textFromPage);
			str.append(textFromPage);
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return str.toString();

	}

	public static void main(String[] args) {
		String text = pdfReader("D:/ProgramFiles/Dassault Systemes/B21/intel_a/startup/HumanCatalogs/Anthropometry/Body_Dimension_References.pdf");
		writeUsingIText("E:/test.pdf", text);
	}

}
