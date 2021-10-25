package com.example.sping_portfolio.minilabs.LoopMinilabs.NolanMiniLabs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.database.*;

@Controller
public class NolanMiniLabs {
    FileInputStream serviceAccount = new FileInputStream("serviceAccount.json");
    FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://nolan-4b453.firebaseio.com/")
            .build();

    String result = "";

    public NolanMiniLabs() throws IOException {
        FirebaseApp.initializeApp(options);

    }

    @GetMapping("/fetchFromFirebase")
    @ResponseBody
    public String fetchFromFirebase(@RequestParam(name = "reference", required = false, defaultValue = "dnhs") String reference) throws IOException, InterruptedException {
        String[] referenceSplit = reference.split(",");


        DatabaseReference ref = FirebaseDatabase.getInstance()
                .getReference(reference);

        System.out.println("ref:" + reference);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 result+= dataSnapshot.getValue(String.class);
                System.out.println("Value: " + result);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Failed to read value: " + error.toException());
            }
        });
        Thread.sleep(1500);
        return result;
    }

    @GetMapping("/create2DArray")
    @ResponseBody
    public String create2DArray(@RequestParam(name = "dimension", required = false, defaultValue = "null") String dimension,@RequestParam(name = "data", required = false, defaultValue = "null") String data ) throws IOException {
        String[] dataSplit = data.split(",");
        String[] dimensionSplit = dimension.split(",");



        String[][]Arr = new String[Integer.parseInt(dimensionSplit[0])][Integer.parseInt(dimensionSplit[1])];

        for (int i = 0; i < dataSplit.length; i++) {
            Arr[i][i] = dataSplit[i];
        }

        String matrix = "";
        for (int j = 0 ; j < Arr.length; j++)
        {
            System.out.println(Arrays.toString(Arr[j]));
            matrix += (Arrays.toString(Arr[j]));
        }

        return matrix;
    }

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
