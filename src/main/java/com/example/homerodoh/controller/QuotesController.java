package com.example.homerodoh.controller;

import com.example.homerodoh.dto.QuoteDTO;
import com.example.homerodoh.service.QuotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuotesController {

    private final QuotesService quotesService;

    public QuotesController(QuotesService quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping("/random")
    public ResponseEntity<QuoteDTO> getRandomQuote() {

        return ResponseEntity.ok(
                quotesService.getRandomQuote()
        );
    }
}