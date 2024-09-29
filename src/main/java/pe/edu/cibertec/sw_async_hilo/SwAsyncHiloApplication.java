package pe.edu.cibertec.sw_async_hilo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SwAsyncHiloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwAsyncHiloApplication.class, args);
	}

}
