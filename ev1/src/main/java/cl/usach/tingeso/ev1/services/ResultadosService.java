package cl.usach.tingeso.ev1.services;

import cl.usach.tingeso.ev1.entities.ResultadosEntity;
import cl.usach.tingeso.ev1.repositories.ResultadosRepository;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
@Service
public class ResultadosService {
    @Autowired
    ResultadosRepository resultadosRepository;

    private final Logger logg = LoggerFactory.getLogger(ResultadosService.class);

    public List<ResultadosEntity> obtenerResultados() { return resultadosRepository.findAll(); }
    public ResultadosEntity guardarDatosResultados(ResultadosEntity resultados) { return resultadosRepository.save(resultados); }


    @Generated
    public String guardarArchivo(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;

        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }

    }


    public void guardarDataDB(String rut, String fecha, String puntaje){
        ResultadosEntity newData = new ResultadosEntity();
        newData.setRutPuntaje(rut);
        newData.setFechaExamen(fecha);
        newData.setPuntaje(puntaje);
        guardarDatosResultados(newData);
    }
}
