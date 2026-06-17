package com.example.homerodoh.service;

import com.example.homerodoh.dto.QuoteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
public class QuotesService {

    private final WebClient webClient;

    public QuotesService(WebClient webClient) {
        this.webClient = webClient;
    }

    public QuoteDTO getRandomQuote() {

        log.info("Consumiendo API externa de quotes");

        try {

            QuoteDTO response = webClient
                    .get()
                    .uri("https://dummyjson.com/quotes/random")
                    .retrieve()
                    .bodyToMono(QuoteDTO.class)
                    .timeout(Duration.ofSeconds(5))

                    .doOnError(error ->
                            log.error("Error consumiendo API externa: {}", error.getMessage()))

                    .onErrorResume(error -> {

                        QuoteDTO fallback = new QuoteDTO();

                        fallback.setQuote("No se pudo obtener la frase");
                        fallback.setAuthor("Sistema");

                        return Mono.just(fallback);
                    })

                    .block();

            log.info("Quote obtenida correctamente");

            return response;

        } catch (Exception e) {

            log.error("Error general en QuotesService: {}", e.getMessage());

            throw new RuntimeException("Error consumiendo servicio externo");
        }
    }
}