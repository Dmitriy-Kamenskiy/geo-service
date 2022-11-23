package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @Test
    void sendRU() {
        String ipTest = "172.";
        String expected = "Добро пожаловать";
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ipTest)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipTest);

        assertEquals(expected, messageSender.send(headers));
    }

    @Test
    void sendUS() {
        String ipTest = "96.";
        String expected = "Добро пожаловать";
        Location location = new Location("New York", Country.USA, null, 0);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ipTest)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipTest);

        assertEquals(expected, messageSender.send(headers));
    }

}