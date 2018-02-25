/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Korisnik
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/upload"})
public class FileUpload extends HttpServlet {

    private float[] labelProbabilities;
    private String rezultat = "prazan";
    InitialContext ctx;
    RecognitionRemote recognizer;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {

        response.setContentType("text/html;charset=UTF-8");
        
        try {
            ctx = new InitialContext();
            recognizer = (RecognitionRemote) ctx.lookup("com.mycompany.fileupload.RecognitionRemote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> files = sf.parseRequest(request);

        for (FileItem elem : files) {
            elem.write(new File("D:\\javaee\\ejb\\mavenproject1\\fileupload\\slika.jpg"));//System.getProperty("user.dir") + fileupload
        }

        PrintWriter out = response.getWriter();

       if (recognizer == null)out.println("no recognizer");
       else out.println("recognizer");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
        }

//        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
//        List<FileItem> files;
//        try {
//            files = sf.parseRequest(request);
//            for (FileItem elem : files) {
//                try {
//                    elem.write(new File("D:\\javaee\\ejb\\mavenproject1\\fileupload\\" + elem.getName()));
//                } catch (Exception ex) {
//                    Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println("broj fajlova" + files.size());
//            }
//        } catch (FileUploadException ex) {
//            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // System.out.println("broj fajlova" + files.size());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
