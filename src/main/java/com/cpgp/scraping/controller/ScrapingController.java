package com.cpgp.scraping.controller;

import com.cpgp.scraping.service.ScrapingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ScrapingController {

    private final ScrapingService scrapingService;

    @GetMapping("/scraping")
    public String scraping(){
        return scrapingService.getScrapedWeb();
    }
}
