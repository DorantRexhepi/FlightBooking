package com.example.flightbooking.Controllers;

import com.example.flightbooking.model.Passenger;
import com.example.flightbooking.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private final CountryService countryService;

    public MainController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/passengerForm")
    public ModelAndView goToForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BookingFlightForm");
        Passenger passenger = new Passenger();
        modelAndView.addObject("passenger", passenger);
        modelAndView.addObject("countries", countryService.getCountries());
        return modelAndView;
    }

    @PostMapping("/postPassenger")
    public String postPassengerResult(Passenger passenger, Model model) {
        model.addAttribute("passenger", passenger);
        return "ResultsPages";
    }
}
