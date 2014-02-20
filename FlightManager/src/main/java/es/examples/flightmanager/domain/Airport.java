package es.examples.flightmanager.domain;

/**
 * An airport which is identified both by a IATA and a ICAO codes.
 * It is placed in a city and has a flight cost.
 * 
 * @author Eugenio Ribeiro
 */
public class Airport extends Airport_Base {
    
	/**
	 * Creates a new airport.
	 * 
	 * @param iata The IATA code of the airport.
	 * @param icao The ICAO code of the airport.
	 * @param city The city where the airport is placed.
	 * @param cost The flight cost.
	 */
    public Airport(String iata, String icao, String city, float cost) {
        this.setIata(iata);
        this.setIcao(icao);
        this.setCity(city);
        this.setCost(cost);
    }
    
}
