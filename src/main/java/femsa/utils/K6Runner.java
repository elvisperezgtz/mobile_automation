package femsa.utils;

import java.io.*;

public class K6Runner {
    public static void runScripts(String scriptPath) {

    //Comprobamos si el fichero existe
    File scriptFile = new File(scriptPath);
    if (!scriptFile.exists()) {
        System.out.println("El archivo especificado no existe");
        return;
    }

    //Creamos un proceso con la ruta del script
    ProcessBuilder builder = new ProcessBuilder("k6", "run", scriptPath);
    builder.redirectErrorStream(true);

    try {
        //Iniciamos el proceso
        Process process = builder.start();
        //Imprimimos la salida del proceso
        InputStream outputStream = process.getInputStream();
        InputStreamReader reader = new InputStreamReader(outputStream);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        //Esperamos a que el proceso termine
        process.waitFor();
    } catch (IOException | InterruptedException e) {
        System.out.println("Error al ejecutar el script: " + e.getMessage());
    }

}

    public static void main(String[] args) {
        runScripts("/Users/elvisperez/Documents/repo/femsa/qa-automation-back/graphQL/src/test/Runners/runnerLogin.js");
    }
}