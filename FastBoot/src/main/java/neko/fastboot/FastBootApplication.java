package neko.fastboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("neko.fastboot.dao")
public class FastBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(FastBootApplication.class, args);
	}
}
