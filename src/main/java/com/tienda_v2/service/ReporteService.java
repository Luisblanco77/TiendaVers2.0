/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_v2.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


public interface ReporteService {
    
    //Se define la firma del método que genera los reportes, con los siguientes parámetros
    //1. reporte: es el nombre del archivo de reporte (.jasper)
    //2. parámetros: un Map quie contiene lso prámetros del reporte... si los ocupa
    //3. tipo: es el tipo de reporte: vPdf, Pdf, Xls, Csv
    public ResponseEntity<Resource> generaReporte(
            String reporte,
            Map<String, Object> parametros,
            String tipo) throws IOException;
    
     
    
}