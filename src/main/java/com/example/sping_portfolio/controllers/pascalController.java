package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.minilabs.samiMiniLabs._pascal;
import com.example.sping_portfolio.minilabs.samiMiniLabs.pascalFor;
import com.example.sping_portfolio.minilabs.samiMiniLabs.pascalRecurse;
import com.example.sping_portfolio.minilabs.samiMiniLabs.pascalWhile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller

public class pascalController {

    // HTTP requests are handled as a controller, using the @Controller annotation

        public List<_pascal> pascalInit(int nth) {
            //Fibonacci objects created with different initializers
            List<_pascal> pascalList = new ArrayList<>();
            pascalList.add(new pascalFor(nth));
            pascalList.add(new pascalFor(nth));
            pascalList.add(new pascalWhile(nth));
            pascalList.add(new pascalRecurse(nth));


            return pascalList;
        }

        // GET request,, parameters are passed within the URI
        @GetMapping("/samiMiniLab")
        public String fib(@RequestParam(name="pascalseq", required=false,  defaultValue="2") String pascalseq, Model model) {
            //nth is fibonacci request
            int nth = Integer.parseInt(pascalseq);

            //MODEL attributes are passed back html
            model.addAttribute("pascalList", pascalInit(nth));

            return "samiMiniLab"; //HTML render fibonacci results

        }

        // Console UI is run out of the same Controller
        public void main(String[] args) {
            int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

            List<_pascal> pascalList = new pascalController().pascalInit(nth);
            for (_pascal pascal : pascalList)
                pascal.print();  //Console output fibonacci results
        }

    public static class samiMiniLab {
        @GetMapping("/samiMiniLab")
        public String samiMiniLab() {

            return "samiMiniLab";
        }
    }
}

