package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * Test for Deletion.
     */
    @Test
    public void testdelete() {
        CityList cityList = new CityList();
        City city = new City("Comilla", "Kandirpar");
        cityList.add(city);
        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * test for checking exception
     */
    @Test
    public void testdeleteexception() {
        CityList cityList = new CityList();
        City city = new City("Comilla", "Kandirpar");
        cityList.add(city);
        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Test for counting the no. of cities in the city list.
     */
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Comilla", "Kandirpar");
        City city1 = new City("Dhaka",   "Shantinagar");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2,cityList.count());
        cityList.delete(city);
        assertEquals(1,cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    /**
     * Checking whether it is Sorted by city or Province;
     */

    @Test
    public void testSort(){
        CityList cityList = new CityList();
        City city=new City("Khulna","Shibbari");
        cityList.add(city);
        assertEquals(0,city.compareTo(cityList.getCities(1).get(0)));
        City city1 = new City("Dhaka","Mirpur");
        cityList.add(city1);

        assertEquals(0,city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0,city1.compareTo(cityList.getCities(2).get(0)));
    }
}