package com.example.sping_portfolio.controllers.nolanMiniLabs;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NolanMiniLabs {

    @GetMapping("/lucasSeriesCalcSeriesUpToIndex")
    @ResponseBody
    public String lucasSeriesCalcSeriesUpToIndex(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasForLoop loopMethod = new lucasForLoop(lucasNumWanted);
        ArrayList<Long> resultList = loopMethod.getList();
        String resultListLoopMethod = "";

        for (Long temp : resultList) {
            resultListLoopMethod += temp + ",";
        }
        System.out.println(resultListLoopMethod);
        return resultListLoopMethod;
    }
    @GetMapping("/lucasSeriesFindSumOfSeries")
    @ResponseBody
    public Long lucasSeriesFindSumOfSeries(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasForLoop loopMethod = new lucasForLoop(lucasNumWanted);
        ArrayList<Long> resultList = loopMethod.getList();

        long longSum = resultList.stream()
                .mapToLong(Long::longValue)
                .sum();

        return longSum;
    }

    @GetMapping("/lucasSeriesGetForTime")
    @ResponseBody
    public String lucasSeriesGetForTime(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasForLoop loopMethod = new lucasForLoop(lucasNumWanted);
        String forTimeTaken = String.valueOf(loopMethod.getElapsedTime());

        return forTimeTaken;


    }

    @GetMapping("/lucasSeriesGetRecurseTime")
    @ResponseBody
    public String lucasSeriesGetRecurseTime(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasRecurse recurseMethod = new lucasRecurse(lucasNumWanted);
        String recurseTimeTaken = String.valueOf(recurseMethod.getElapsedTime());
        return recurseTimeTaken;
    }

    @GetMapping("/lucasSeriesGetStreamTime")
    @ResponseBody
    public String lucasSeriesGetStreamTime(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasStream streamMethod = new lucasStream(lucasNumWanted);
        String streamTimeTaken = String.valueOf(streamMethod.getElapsedTime());
        return streamTimeTaken;
    }

    @GetMapping("/lucasSeriesGetWhileTime")
    @ResponseBody
    public String lucasSeriesGetWhileTime(@RequestParam(name = "lucasNumWanted", required = false, defaultValue = "2") int lucasNumWanted) {
        lucasWhile whileMethod = new lucasWhile(lucasNumWanted);
        String whileTimeTaken = String.valueOf(whileMethod.getElapsedTime());
        return whileTimeTaken;
    }

    @GetMapping("/NolanMiniLabs")
    public String NolanMiniLabs() {
        return "NolanMiniLabs";
    }


}
