package de.tjjf.Domain;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import de.tjjf.Domain.models.MAddress;
import de.tjjf.Domain.models.MAirline;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

public class InvoicePDF {

    public static String createPDF(MTicket ticket){
        MPerson person = ticket.getPerson();
        MAirline airline =ticket.getFlight().getAirplane().getBelongingAirline();
        MAddress adress = airline.getAddress();
        String informations = adress.street+" "+adress.number+", "+adress.zipcode+" "
                +adress.city+"\nTel: "+ airline.getPhoneNumber()+"\n"+airline.getEmail();
        String fileName = "Rechnung_" + ticket.getTicketId() + ".pdf";
        String filePath = "src/main/resources/" + fileName;

        try{
            PdfWriter pdfWriter = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            //TODO: Evtl Adresse einfügen
            String companyName = ticket.getFlight().getAirplane().getBelongingAirline().getName();
            String companyDetails = informations;
            Paragraph header = new Paragraph(companyName)
                    .setBold()
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(header);
            Paragraph companyInfo = new Paragraph(companyDetails)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(companyInfo);
            document.add(new Paragraph("\n"));
            Paragraph title = new Paragraph("Rechnung "+ticket.getTicketId())
                    .setBold()
                    .setFontSize(16)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(title);

            document.add(new Paragraph("\n"+person.getFirstName()+" "+person.getLastName())
                    .setFontSize(12));

            document.add(new Paragraph("\n"));

            Table table = new Table(UnitValue.createPercentArray(new float[]{50, 20, 30}));
            table.setWidth(UnitValue.createPercentValue(100));
            table.addHeaderCell(new Cell().add(new Paragraph("Flug").setBold()).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("Sitzklasse").setBold()).setTextAlignment(TextAlignment.CENTER));
            table.addHeaderCell(new Cell().add(new Paragraph("Betrag (EUR)").setBold()).setTextAlignment(TextAlignment.CENTER));

            // Datenzeile
            String flight = Long.toString(ticket.getFlight().getFlightNum());
            String seatingclass = ticket.getSeatingClass().toString();
            String price = Integer.toString(ticket.getTotalPrice());
            table.addCell(new Cell().add(new Paragraph(flight)).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(seatingclass)).setTextAlignment(TextAlignment.CENTER));
            table.addCell(new Cell().add(new Paragraph(price)).setTextAlignment(TextAlignment.CENTER));

            document.add(table);

            document.add(new Paragraph("\n"));

            Paragraph total = new Paragraph("Gesamtbetrag: "+price)
                    .setBold()
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(total);
            document.close();

            System.out.println("PDF wurde erstellt");
            return filePath;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
