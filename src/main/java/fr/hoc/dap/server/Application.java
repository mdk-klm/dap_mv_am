/**
 *
 */
package fr.hoc.dap.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author house
 *
 */
@SpringBootApplication
public class Application {
    /**
     * constante log pour de futur debugage.
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * @param args .
     */
    public static void main(final String[] args) {

        SpringApplication.run(Application.class, args);

    }

    /**
     *
     * @return configuration personnalisée
     */
    @Bean
    public Config createConf() {
        Config configuration = new Config();

        configuration.setApplicationName("Dap");

        return configuration;

    }

    /**
     * @param ctx I don't understand .
     * @param userKey .
     * @return les parametre du programme.
     */
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx, final String userKey) {
        return args -> {

            LOG.info("pensez aux générations futures le monde");
        };
    }
}
