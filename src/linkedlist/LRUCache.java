package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LRUCache {
    public HashMap<String, City> cache;
    public LinkedList<City> cities;
    public static int MAX_CAPACITY = 5;

    public City get(String key) {
        if (cache.containsKey(key)) {
            //Return the value associated with the key
            // Update the linkedList;
            City city = cache.get(key);
            cities.remove(city);
            cities.addFirst(city);
            return city;
        }

        throw new NoSuchElementException();
    }

    public void insert(String key, String value) {
        if (cache.containsKey(key)) {
            City city = cache.get(key);
            city.setCity(value);
            cities.remove(city);
            cities.addFirst(city);
        }

        City city = new City(key, value);
        cache.put(key, city);
        cities.offerFirst(city);

        if (cache.size() > MAX_CAPACITY) {
            cache.remove(cities.getLast().country);
            cities.removeLast();
        }
    }

    public class City {

        //Key
        public String country;
        //Value
        public String city;

        public City(String country, String city) {
            this.country = country;
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }


    public static void main(String[] args) {
        
    }
}
