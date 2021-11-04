package com.example.sping_portfolio.minilabs.LoopMinilabs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sping_portfolio.controllers.ArithmeticFor;
import com.example.sping_portfolio.controllers.ArithmeticWhile;
import com.example.sping_portfolio.controllers.ArithmeticRecursion;

@Controller
public class PrishaMiniLabs {

    @GetMapping("/PrishaMiniLabs")
    public String getPrishaMiniLabs() {
        return "PrishaMiniLabs";
    }

    @GetMapping("/PrishaMiniLabs-api")
    @ResponseBody
    public String PrishaMiniLabsAPI(@RequestParam(name="seq_size", required=false, defaultValue="8") int size,
                                    @RequestParam(name="seq_first", required=false, defaultValue="1") int first,
                                    @RequestParam(name="seq_diff", required=false, defaultValue="2") int diff,
                                    @RequestParam(name="seq_type", required=true) String type) {
        if(type.equals("ForLoop")) {
            ArithmeticFor seq = new ArithmeticFor(size, first, diff);
            return seq.genSeq();
        } else if(type.equals("WhileLoop")) {
            return "WhileLoop";
        } else if(type.equals("Recursion")) {
            return "Recursion";
        } else {
            return "Error: Unknown sequence type requested!";
        }

    }
}


