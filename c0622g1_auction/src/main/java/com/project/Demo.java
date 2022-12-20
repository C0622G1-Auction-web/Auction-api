package com.project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo {

    public static void main(String[] args) {

        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
    }
}
