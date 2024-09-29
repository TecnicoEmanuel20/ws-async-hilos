package pe.edu.cibertec.sw_async_hilo.remote.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
//enviar mensaje de consola
@Slf4j
public class asyncTaskService {


    //llamar a este metodo para que sea asincrono
    @Async
    public CompletableFuture <String> operacionPagoOnline(){
        try{
            log.info("Iniciando proceso de pago");
            TimeUnit.SECONDS.sleep(4);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        return CompletableFuture.completedFuture("Pago Exitoso");

    }

    public CompletableFuture<String> operacionRegistroVentas (){
        try{
            log.info("Iniciando Registro Ventas");
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Registro Exitoso");
    }

    public CompletableFuture<String> OperacionActualizarCompra(){
        try{
            log.info("Actualización de compras");
            TimeUnit.SECONDS.sleep(7);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return CompletableFuture.completedFuture("Actualizacion Exitosa");
    }
}
