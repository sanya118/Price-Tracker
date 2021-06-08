package com.example.test.demo.service;

import com.example.test.demo.Constants;
import org.springframework.stereotype.Service;

@Service
public class PriceComparisonServiceImpl implements PriceComparisonService {


    @Override
    public String comparePrice(String price) {
        double startingPrice = Constants.STARTING_PRICE;
        double currentPrice = 0.0;
        String message;
        char c;
        try {
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < price.length(); i++) {
                c = price.charAt(i);
                if (((c >= 48) && (c <= 57)) || (c == '.')) {
                    temp.append(c);
                }
            }
            currentPrice = Double.parseDouble(temp.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (currentPrice < startingPrice) {
            message = "Alert!Price decrease by Rs." + (startingPrice - currentPrice);
        } else if (currentPrice > startingPrice) {
            message = "Alert!Price increase by Rs." + (currentPrice - startingPrice);
        } else
            message = "Price hasn't changed!";
        return message;
    }
}
