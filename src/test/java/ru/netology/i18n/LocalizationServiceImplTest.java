package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void localeRU() {
        String expected = "Добро пожаловать";
        Country countryTest = Country.RUSSIA;

        assertEquals(expected, localizationService.locale(countryTest));
    }

    @Test
    void localeUS() {
        String expected = "Welcome";
        Country countryTest = Country.USA;

        assertEquals(expected, localizationService.locale(countryTest));
    }
}