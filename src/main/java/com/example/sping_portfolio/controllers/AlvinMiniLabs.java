package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.time.Duration;
import java.time.Instant;

import java.util.stream.Stream;

abstract class _Sequence {
    int n;
    int size;
    ArrayList<Integer> result;
    Map<Integer, Boolean> inResult;
    Duration timeElapsed;

    public _Sequence() {
        this(20);
    }

    public _Sequence(int _size) {
        this.size = _size;
        this.result = new ArrayList<>();
        this.inResult = new HashMap<>();

        this.inResult.put(0, true);
        this.result.add(0);
        this.n = 1;
    }

    protected abstract void init();

    public void nextNum() {
        int i = (int)(Math.sqrt((double) this.result.get(this.n - 1))) + 1;

        while(inResult.containsKey((i*i) - this.result.get(this.n - 1))) {
            i++;
        }

        this.result.add((i*i) - this.result.get(this.n - 1));
        this.inResult.put((i*i) - this.result.get(this.n - 1), true);
        n++;
    }

    public void printSequence() {
        for (int i = 1; i < this.result.size(); i++) System.out.println(this.result.get(i));
    }
}

class SequenceFor extends _Sequence {

    public SequenceFor() {
        super();
    }

    public SequenceFor(int _size) {
        super(_size);
    }

    @Override
    protected void init() {
        int limit = this.size;

        Instant start = Instant.now();
        for(int i = 0; i < limit; i++) {
            this.nextNum();
        }
        Instant end = Instant.now();

        this.timeElapsed = Duration.between(start, end);
    }
}

class SequenceWhile extends _Sequence {

    public SequenceWhile() {
        super();
    }

    public SequenceWhile(int _size) {
        super(_size);
    }

    @Override
    protected void init() {
        int limit = this.size;

        Instant start = Instant.now();
        while (limit-- > 0) {
            this.nextNum();
        }
        Instant end = Instant.now();

        this.timeElapsed = Duration.between(start, end);
    }
}

class SequenceRecurse extends _Sequence {

    public SequenceRecurse() {
        super();
    }

    public SequenceRecurse(int _size) {
        super(_size);
    }

    @Override
    protected void init() {
        int limit = this.size;

        Instant start = Instant.now();
        RecurseInit(limit);
        Instant end = Instant.now();

        this.timeElapsed = Duration.between(start, end);
    }

    private void RecurseInit(int limit) {
        if(limit == 0) return;

        this.nextNum();
        RecurseInit(limit-1);
    }
}

class SequenceStream extends _Sequence {

    public SequenceStream() {
        super();
    }

    public SequenceStream(int _size) {
        super(_size);
    }

    @Override
    protected void init() {
        int limit = this.size;

        Instant start = Instant.now();
        Stream.iterate(0, x -> x+1)
                .limit(limit)
                .forEach(x -> this.nextNum() );
        Instant end = Instant.now();

        this.timeElapsed = Duration.between(start, end);
    }
}

@Controller
public class AlvinMiniLabs {

    @GetMapping("/AlvinMiniLabs")
    public String getAlvinMiniLabs() {
        return "AlvinMiniLabs";
    }

    @GetMapping("/AlvinMiniLabs-api")
    @ResponseBody
    public String AlvinMiniLabsAPI(@RequestParam(name="size", required=false, defaultValue="8") int size) {
        SequenceWhile whileSeq = new SequenceWhile(size);
        SequenceFor forSeq = new SequenceFor(size);
        SequenceRecurse recurseSeq = new SequenceRecurse(size);
        SequenceStream streamSeq = new SequenceStream(size);

        whileSeq.init();
        forSeq.init();
        recurseSeq.init();
        streamSeq.init();

        return "While Loop: " + whileSeq.result.toString() + "; Duration: " + whileSeq.timeElapsed.getNano()*(double)1e-9 + "s"
                + "\n\nFor Loop: " + forSeq.result.toString() + "; Duration: " + forSeq.timeElapsed.getNano()*(double)1e-9 + "s"
                + "\n\nRecursion: " + recurseSeq.result.toString() + "; Duration: " + recurseSeq.timeElapsed.getNano()*(double)1e-9 + "s"
                + "\n\nJava 8 Stream: " + streamSeq.result.toString() + "; Duration: " + streamSeq.timeElapsed.getNano()*(double)1e-9 + "s"
                ;
    }
}


