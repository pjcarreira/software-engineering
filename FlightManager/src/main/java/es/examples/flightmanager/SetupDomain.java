package es.examples.flightmanager;

import org.joda.time.LocalTime;

import es.examples.flightmanager.domain.Airport;
import es.examples.flightmanager.domain.Airline;
import es.examples.flightmanager.domain.Flight;
import es.examples.flightmanager.domain.FlightManager;
import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import jvstm.Atomic;

/**
 * This class populates the database with the requested airlines, airports and flights.
 */
public final class SetupDomain {

	/**
	 * A dummy private constructor.
	 */
	private SetupDomain() {
		// Never used
	}
	
    /**
     * Populates the database.
     */
    @Atomic
    private static void populateDomain() {
    	FlightManager man = FenixFramework.getRoot();
    	
    	System.out.print("Creating the airports... ");	
    	Airport oporto = new Airport("OPO", "LPPR", "Oporto", 0);
    	Airport lisbon = new Airport("LIS", "LPPT", "Lisbon", 0);
    	Airport amsterdam = new Airport("AMS", "EHAM", "Amsterdam", 0);
    	System.out.println("OK");
    	
    	System.out.println("Adding the airports... ");
    	man.addAirport(oporto);
    	man.addAirport(lisbon);
    	man.addAirport(amsterdam);
    	System.out.println("OK");
    	
    	System.out.print("Creating the airlines... ");
    	Airline tap = new Airline("TAP", "TP");
    	System.out.println("OK");
    	
    	System.out.print("Adding the airlines... ");
    	man.addAirline(tap);
    	System.out.println("OK");
    	
    	System.out.print("Creating the flights... ");
    	Flight porLis = new Flight(1951, oporto, lisbon, new LocalTime(6, 50));
    	Flight lisPor = new Flight(1988, lisbon, oporto, new LocalTime(21, 55));
    	Flight amsPor = new Flight(651, amsterdam, oporto, new LocalTime(14, 20));
    	Flight lisAms = new Flight(660, lisbon, amsterdam, new LocalTime(14, 5));
    	System.out.println("OK");
    	
    	System.out.println("Adding the flights... ");
    	man.addFlight(tap, porLis);
    	man.addFlight(tap, lisPor);
    	man.addFlight(tap, amsPor);
    	man.addFlight(tap, lisAms);
    	System.out.println("OK");
    	
    }

	/**
	 * The main method. It performs the initialization and populates the database. 
	 * 
	 * @param args Not used in this case.
	 */
    public static void main(String[] args) {
    	FenixFramework.initialize(new Config() {{
            dbAlias = "//localhost:3306/hellodb";  // Create this database in MySQL
            dbUsername = "hello";				   // OR
            dbPassword = "world";				   // Replace the fields according to your DB config
    		domainModelPath="src/main/dml/flightmanager.dml"; // The path to the dml file
    		rootClass=FlightManager.class; // The root class of the domain 
    	}});
    	
		populateDomain();
    }
   
}
