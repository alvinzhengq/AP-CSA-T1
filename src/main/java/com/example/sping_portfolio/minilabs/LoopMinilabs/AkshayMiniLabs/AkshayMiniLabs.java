package com.example.sping_portfolio.minilabs.LoopMinilabs.AkshayMiniLabs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AkshayMiniLabs {

    @GetMapping("/AkshayMiniLabs")
    public String getAkshayMiniLabs() {
        return "AkshayMiniLabs";
    }

    @GetMapping("/akshay-abstraction-minilab-api")
    @ResponseBody
    public String AkshayAbstractionAPI(@RequestParam(name="a", required=false, defaultValue="1") int a,
                                       @RequestParam(name="b", required=false, defaultValue="1") int b,
                                       @RequestParam(name="c", required=false, defaultValue="1") int c) {

        ImplementationOne io1 = new ImplementationOne(a, b, c);
        double io1Num = io1.GeoSeq();
        ImplementationTwo io2 = new ImplementationTwo(a, b, c);
        double io2Num = io2.GeoSeq();
        ImplementationThree io3 = new ImplementationThree(a, b, c);
        double io3Num = io3.GeoSeq();
        ImplementationFour io4 = new ImplementationFour(a, b, c);
        double io4Num = io4.GeoSeq();

        String result = "Implementation 1 result: " + io1Num + "; Implementation 2 result: " + io2Num +
                "; Implementation 3 result: " + io3Num + "; Implementation 4 result: " + io4Num;

        return result;
    }
}


