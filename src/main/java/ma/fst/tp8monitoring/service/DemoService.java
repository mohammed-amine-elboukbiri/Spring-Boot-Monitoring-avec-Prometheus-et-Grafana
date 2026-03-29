package ma.fst.tp8monitoring.service;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public String processData() {
        Metrics.counter("custom.requests.count").increment();

        logger.info("Requête enregistrée dans Prometheus");
        logger.info("Démarrage du traitement des données");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Erreur dans le traitement", e);
            Thread.currentThread().interrupt();
        }

        logger.info("Traitement terminé avec succès");
        return "Traitement terminé";
    }
}