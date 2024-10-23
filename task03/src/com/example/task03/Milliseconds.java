package com.example.task03;

/**
 * Интервал в миллисекундах
 */
public class Milliseconds implements TimeUnit {

    private final long Milliseconds;

    public Milliseconds(long milliseconds) {
        this.Milliseconds = milliseconds;
    }

    @Override
    public long toMillis() {
        return Milliseconds;
    }

    @Override
    public long toSeconds() {
        return Math.round(Milliseconds / 1000f);
    }

    @Override
    public long toMinutes() {
        return Math.round(Milliseconds / (float)(1000 * 60));
    }

    @Override
    public long toHours() {
        return Math.round(Milliseconds / (float)(1000 * 3600));}
}
