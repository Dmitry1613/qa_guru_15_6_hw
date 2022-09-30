package com.demoqa.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UtilForData {
    public static String randomMonth() {
        List<String> months = Arrays.asList(
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December");
        return months.get(new Random().nextInt(months.size()));
    }
}
