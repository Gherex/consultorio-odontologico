package com.gherex.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static int calcularEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null) return 0;

        LocalDate nacimiento = fechaNacimiento.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
}
