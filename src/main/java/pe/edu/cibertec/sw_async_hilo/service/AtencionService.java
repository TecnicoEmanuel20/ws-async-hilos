package pe.edu.cibertec.sw_async_hilo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_async_hilo.remote.service.asyncTaskService;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AtencionService {
    private final asyncTaskService asyncTaskService;

    public CompletableFuture<String> ejecutarTareasAsincronas(){
        CompletableFuture<String> tarea1 = asyncTaskService.operacionPagoOnline();
        CompletableFuture<String> tarea2 = asyncTaskService.operacionRegistroVentas();
        CompletableFuture<String> tarea3 = asyncTaskService.OperacionActualizarCompra();

        return CompletableFuture.allOf(tarea1,tarea2,tarea3).thenApply(result -> {
           try {
               String valorTarea1 = tarea1.join();
               String valorTarea2 = tarea2.join();
               String valorTarea3 = tarea3.join();
               return "Resultado final = "+valorTarea1+ "-" +valorTarea2+"-" +valorTarea3;
           }catch (Exception ex){
               return  "Error al combinar los datos";
           }
        }).exceptionally(ex -> "Error al ejecutar las tareas");
    }

}
