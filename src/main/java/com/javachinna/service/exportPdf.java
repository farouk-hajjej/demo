package com.javachinna.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.javachinna.model.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Service
public class exportPdf {

    public static ByteArrayInputStream UserPDFReport(List<User> userList)  {
        Document document=new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,out);
            document.open();
            //add text to pdf file
            com.itextpdf.text.Font font= FontFactory.getFont(FontFactory.COURIER,12, BaseColor.LIGHT_GRAY);
            Paragraph para = new Paragraph("Liste Des Utilisateurs ",font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table=new PdfPTable(6);
            //make the columns
            Stream.of("Id User","Nom & Prénom","Email","Activé","Date De Creation","Date De Modification").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headfont= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                header.setBackgroundColor(BaseColor.YELLOW);
                header.setBorderWidth(12);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle,headfont));
                table.addCell(header);


            });

            for (User u : userList){


                PdfPCell idCell = new PdfPCell(new Phrase((u.getId().toString())));
                idCell.setPaddingLeft(1);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(idCell);

                PdfPCell nameCell = new PdfPCell(new Phrase(u.getDisplayName()));
                nameCell.setPaddingLeft(1);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(nameCell);

                PdfPCell emailCell = new PdfPCell(new Phrase(u.getEmail()));
                emailCell.setPaddingLeft(1);
                emailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                emailCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(emailCell);

                PdfPCell activeCell = new PdfPCell(new Phrase(String.valueOf(u.isEnabled())));
                activeCell.setPaddingLeft(1);
                activeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                activeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(activeCell);

                PdfPCell DateCCell = new PdfPCell(new Phrase(u.getCreatedDate().toString()));
                DateCCell.setPaddingLeft(1);
                DateCCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                DateCCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(DateCCell);
              //  dataRow.createCell(5).setCellValue(String.valueOf(userList.get(i).getModifiedDate()));

                PdfPCell DateMCell = new PdfPCell(new Phrase((String.valueOf(u.getModifiedDate()))));
                DateMCell.setPaddingLeft(1);
                DateMCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                DateMCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(DateMCell);

            }
            // Creating an ImageData object
            // String url = "./src/main/resources/static/img/QRCode.png";
            // Image image = Image.getInstance(url);
            // document.add(image);


            document.add(table);
            document.close();

        } catch ( DocumentException  e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
