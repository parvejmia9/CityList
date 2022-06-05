package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     *
     * @param city This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities or provinces.
     * @param a
     *
     * @return
     * if a=1, returns sorted list of cities;
     * if a=2, returns sorted list of provinces;
     */
    public List<City> getCities(int a) {
        List<City> cityList = cities;
        if(a==1)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * To delete city if exist or throw Exception if it does not exist;
     * @param city

     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * For counting the size of list.
     * @return Returns Size of CityList
     */
    public int count() {
        return cities.size();
    }
}