package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private GeoServiceImpl geoService = new GeoServiceImpl();
    @Test
    void byIpRU() {

        String ipTest = "172.";
        String expected = "Moscow";

        Assertions.assertEquals(expected, geoService.byIp(ipTest).getCity());
    }

    @Test
    void byIpUS() {

        String ipTest = "96.";
        String expected = "New York";

        Assertions.assertEquals(expected, geoService.byIp(ipTest).getCity());
    }
}