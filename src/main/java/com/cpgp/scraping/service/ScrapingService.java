package com.cpgp.scraping.service;

import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@AllArgsConstructor
public class ScrapingService {

    public String getScrapedWeb() {
        final String url = "https://bscscan.com/token/generic-tokentxns2?m=normal&contractAddress=0x1c6bc8e962427deb4106ae06a7fa2d715687395c&a=0xb73b4eeb4c4912c1d1869219a22660eb478b57ea&sid=d1fe2807895aa1b92b135238351d0bc1&p=1";
        // web
        // https://bscscan.com/token/0x1c6bc8e962427deb4106ae06a7fa2d715687395c?a=0xb73b4eeb4c4912c1d1869219a22660eb478b57ea
        // frame
        // https://bscscan.com/token/generic-tokentxns2?m=normal&contractAddress=0x1c6bc8e962427deb4106ae06a7fa2d715687395c&a=0xb73b4eeb4c4912c1d1869219a22660eb478b57ea&sid=d1fe2807895aa1b92b135238351d0bc1&p=1
        // cookie
        // aualzequh3zktedmm03bejwf

        try{
            Map<String, String> cooks = new HashMap<>();
            cooks.put("ASP.NET_SessionId", "aualzequh3zktedmm03bejwf");
            Document document = Jsoup
                    .connect(url)
                    .cookies(cooks)
                    .get();
            System.out.println(document.outerHtml());

            for (Element body : document.select(
                    "table.table.table-md-text-normal.table-hover.mb-4 tbody"
            ))
            {
                for(Element row : body.select(
                        "tr"))
                {
                    final String value = row.select(
                            "td"
                    ).text();
                    System.out.println(value);
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "done";
    }
}
