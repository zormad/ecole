/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agiitech.ecole.controlers;

//import net.sf.jasperreports.engine.JRException;

import com.agiitech.ecole.utils.JSFUtils;

//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import java.util.Map;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import javax.faces.context.FacesContext;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.List;
//import javax.inject.Inject;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author ZORE
 */
public class AbstractBean {

  
    public AbstractBean() {
    }

    protected void displayInfoMessage(String message) {
        JSFUtils fUtils = new JSFUtils();
        fUtils.sendInfoMessage(message);
    }

    protected void displayErrorMessage(String message) {
        JSFUtils fUtils = new JSFUtils();
        fUtils.sendErrorMessage(message);
    }
       
}
