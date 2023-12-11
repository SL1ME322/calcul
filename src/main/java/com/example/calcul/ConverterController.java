package com.example.calcul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class ConverterController {
    @PostMapping
    public String convertCurrency(@RequestParam("amount") double amount,
                                  @RequestParam("sourceCurrency") String sourceCurrency,
                                  @RequestParam("targetCurrency") String targetCurrency,
                                  Model model) {
        double result = 0;
        double usdToEurRate = 0.93;
        double usdToRubRate = 90.80;

        double eurToUsdRate = 1 / usdToEurRate;
        double eurToRubRate = 97.79;

        switch (sourceCurrency + targetCurrency) {
            case "USDEUR":
                result = amount * usdToEurRate;
                break;
            case "EURUSD":
                result = amount * eurToUsdRate;
                break;
            case "USDRUB":
                result = amount * usdToRubRate;
                break;
            case "RUBUSD":
                result = amount / usdToRubRate;
                break;
            case "EURRUB":
                result = amount * eurToRubRate;
                break;
            case "RUBEUR":
                result = amount / eurToRubRate;
                break;
            case "USDUSD":
                result = amount;
                break;
            case "EUREUR":
                result = amount;
                break;
            case "RUBRUB":
                result = amount;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);
        return "converter";
    }
}