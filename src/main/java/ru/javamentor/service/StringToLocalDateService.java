package ru.javamentor.service;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StringToLocalDateService implements Converter<String, LocalDate> {

    public LocalDate convert(String date){
        return LocalDate.parse(date);
    }
}