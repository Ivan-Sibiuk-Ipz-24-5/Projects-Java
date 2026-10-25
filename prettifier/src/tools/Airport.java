package tools;

public class Airport {
    public String name;
    public String isoCountry;
    public String city;
    public String icao;
    public String iata;

    public Airport(String name, String isoCountry, String city, String icao, String iata) {
        this.name = name;
        this.isoCountry = isoCountry;
        this.city = city;
        this.icao = icao;
        this.iata = iata;
    }
}
