package com.example.task03;

public class Hours implements TimeUnit{

    private  final long Hours;

    public Hours(long hours){
        this.Hours = hours;
    }

    @Override
    public long toMillis(){
        return Hours * 1000 * 3600;
    }

    @Override
    public long toSeconds(){
        return Hours * 3600;
    }

    @Override
    public long toMinutes(){
        return Hours * 60;
    }

    @Override
    public long toHours(){
        return Hours;
    }
}