package ru.netology.Radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RadioTest {
    Radio radio = new Radio();
    @ParameterizedTest
    @CsvSource({
            "-1,0",
            "0,0",
            "1,1",
            "8,8",
            "9,9",
            "10,0"
    })
    public void setCurrentRadioStation(int newCurrentStation, int expected) {

        radio.setCurrentRadioStation(newCurrentStation);
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0",
            "0,0",
            "1,1",
            "99,99",
            "100,100",
            "101,0"
    })

    public void setCurrentVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);
        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "0,9",
            "1,0",
            "9,8"
    })
    public void pushPrev(int newCurrentStation, int expected) {

        radio.setCurrentRadioStation(newCurrentStation);
        radio.prev();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "0,1",
            "8,9",
            "9,0"
    })
    public void pushNext(int newCurrentStation, int expected) {

        radio.setCurrentRadioStation(newCurrentStation);
        radio.next();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "0,0",
            "100,99"
    })
    public void reduceVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);
        radio.reduceVolume();

        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "100,100"
    })
    public void increaseVolume(int newCurrentVolume, int expected) {

        radio.setCurrentVolume(newCurrentVolume);
        radio.increaseVolume();

        int actual = radio.getVolume();

        Assertions.assertEquals(expected, actual);
    }


    int newQuantityStation = 70;


    @Test
    public void setQuantityStation() {
        Radio radio = new Radio(newQuantityStation);

        Assertions.assertEquals(70, radio.getQuantityRadioStation());
        Assertions.assertEquals(69, radio.getMaxRadioStation());
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0",
            "0,0",
            "1,1",
            "68,68",
            "69,69",
            "70,0"
    })
    public void setCurrentRadioStationWhenQuantityStationIsChanged(int newCurrentStation, int expected) {

        Radio radio = new Radio(newQuantityStation);

        radio.setCurrentRadioStation(newCurrentStation);
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0,69",
            "1,0",
            "69,68"
    })
    public void pushPrevWhenQuantityStationIsChanged(int newCurrentStation, int expected) {

        Radio radio = new Radio(newQuantityStation);

        radio.setCurrentRadioStation(newCurrentStation);
        radio.prev();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "0,1",
            "68,69",
            "69,0"
    })
    public void pushNextWhenQuantityStationIsChanged(int newCurrentStation, int expected) {

        Radio radio = new Radio(newQuantityStation);

        radio.setCurrentRadioStation(newCurrentStation);
        radio.next();

        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }









}


