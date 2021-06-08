package com.example.test.demo.service;

import com.example.test.demo.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class PriceRetrieveServiceImpl implements PriceRetrieveService{

    @Override
    public String getPrice() throws Exception {
        String url = Constants.URL;
        Document document = Jsoup.connect(url).get();
        assert document != null;
        Element price = document.getElementById(Constants.ID);
        return price.text();
    }
}
