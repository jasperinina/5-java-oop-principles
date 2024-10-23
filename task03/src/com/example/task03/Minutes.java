package com.example.task03;

public class Minutes implements TimeUnit {

    private final long Minutes;

    public Minutes(long minutes) {
        this.Minutes = minutes;
    }

    @Override
    public long toMillis() {
            return Minutes * 60 * 1000;
    }

    @Override
    public long toSeconds() {
            return Minutes * 60;
    }

    @Override
    public long toMinutes() {
            return Minutes;
    }

    @Override
        public long toHours(){
        return Math.round(Minutes / 60f);
    }
}