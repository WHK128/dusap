/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bericht;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;

/**
 *
 * @author Werner
 */
public class printPdf {

    @FXML
    private void pdfs() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            Statement stmt = con.createStatement();
            /* Define the SQL query */
            ResultSet query_set = stmt.executeQuery("SELECT *From tablename");
            /* Step-2: Initialize PDF documents - logical objects */
            Document my_pdf_report = new Document();
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
            my_pdf_report.open();
            //we have four columns in our table
            PdfPTable my_report_table = new PdfPTable(4);
            //create a cell object
            PdfPCell table_cell;

            while (query_set.next()) {
                String dept_id = query_set.getString("code");
                table_cell = new PdfPCell(new Phrase(dept_id));
                my_report_table.addCell(table_cell);
                String dept_name = query_set.getString("category");
                table_cell = new PdfPCell(new Phrase(dept_name));
                my_report_table.addCell(table_cell);
                String manager_id = query_set.getString("total");
                table_cell = new PdfPCell(new Phrase(manager_id));
                my_report_table.addCell(table_cell);
                String location_id = query_set.getString("Sum");
                table_cell = new PdfPCell(new Phrase(location_id));
                my_report_table.addCell(table_cell);
            }
            /* Attach report table to PDF */
            my_pdf_report.add(my_report_table);
            my_pdf_report.close();

            /* Close all DB related objects */
            query_set.close();
            stmt.close();
            con.close();

        } catch (FileNotFoundException | DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
