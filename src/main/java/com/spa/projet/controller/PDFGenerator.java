package com.spa.projet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.spa.projet.model.Rendezvous;

public class PDFGenerator {

	// List to hold all Students
	private List<Rendezvous> rendezvousList;

	public List<Rendezvous> getRendezvousList() {
		return rendezvousList;
	}

	public void setRendezvousList(List<Rendezvous> rendezvousList) {
		this.rendezvousList = rendezvousList;
	}

	public void generate(HttpServletResponse response) throws DocumentException, IOException {

		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Reservation", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(5);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 6, 5, 5,5,5 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		// Adding Cell to table
		cell.setPhrase(new Phrase("ID_RDV", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("date rdv", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Date Demande", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("salon id", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("client id", font));
		table.addCell(cell);

		// Iterating over the list of students
		for (Rendezvous rendezvous : rendezvousList) {
			// Adding student id
			table.addCell(String.valueOf(rendezvous.getIdrendezvous()));
			// Adding student name
			table.addCell(rendezvous.getDate_rdv().toString());
			// Adding student section
			table.addCell(rendezvous.getDate_demande().toString());
			table.addCell(String.valueOf(rendezvous.getSalon_id()));
			// Adding student name
			table.addCell(String.valueOf(rendezvous.getClient_id()));
	
		}
		// Adding the created table to document
		document.add(table);

		// Closing the document
		document.close();

	}
}
