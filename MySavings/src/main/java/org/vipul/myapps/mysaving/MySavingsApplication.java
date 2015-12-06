package org.vipul.myapps.mysaving;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.vipul.myapps.mysaving.model.FixedDeposite;
import org.vipul.myapps.mysaving.repository.FixedDepositeRepository;

@SpringBootApplication
public class MySavingsApplication extends SpringBootServletInitializer {

	private static Logger logger = Logger.getLogger(MySavingsApplication.class);

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(MySavingsApplication.class); }
	 */
	@Bean
	CommandLineRunner runner(FixedDepositeRepository fdr) {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {

				fdr.save(new FixedDeposite("1", 9.5, 1000.00, new Date(), new Date(), 15000.00));
				fdr.save(new FixedDeposite("2", 9.5, 1000.00, new Date(), new Date(), 15000.00));
				fdr.save(new FixedDeposite("3", 9.5, 1000.00, new Date(), new Date(), 15000.00));
				fdr.save(new FixedDeposite("4", 9.5, 1000.00, new Date(), new Date(), 15000.00));
				fdr.save(new FixedDeposite("5", 9.5, 1000.00, new Date(), new Date(), 15000.00));
				fdr.save(new FixedDeposite("6", 9.5, 1000.00, new Date(), new Date(), 15000.00));

				logger.info(fdr.findAll().toArray().toString());
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/mySavings/fixedDeposites").allowedOrigins("http://localhost:8081");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MySavingsApplication.class, args);
	}

}
