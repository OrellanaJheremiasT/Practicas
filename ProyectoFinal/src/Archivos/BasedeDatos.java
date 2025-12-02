package Archivos;

import Modelo.Estudiante;

import java.io.*;
import java.nio.file.*;

public class BasedeDatos {

    private final Path filePath;

    public BasedeDatos(String path) {
        this.filePath = Paths.get(path);
    }

    public Estudiante[] loadEstudiantes() throws IOException {

        if (!Files.exists(filePath)) {
            return new Estudiante[0];
        }

        long lineCount = Files.lines(filePath).count();


        int size = (int)lineCount - 1;

        if (size <= 0) return new Estudiante[0];

        Estudiante[] arreglo = new Estudiante[size];

        try (BufferedReader br = Files.newBufferedReader(filePath)) {


            String line = br.readLine();

            int index = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");


                if (parts.length < 6) continue;

                String programa  = parts[1].trim(); 
                String paterno   = parts[2].trim();
                String materno   = parts[3].trim();
                String nombres   = parts[4].trim();
                String genero    = parts[5].trim();

                arreglo[index] = new Estudiante(nombres, paterno, materno, genero, programa);
                index++;

                if (index >= size) break; 
            }
        }
        return arreglo;
    }

    public void appendAudit(String auditPath, String message) {
        try {
            Files.write(
                Paths.get(auditPath),
                (new java.util.Date() + " - " + message + System.lineSeparator()).getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("No se pudo escribir auditoría: " + e.getMessage());
        }
    }
}
