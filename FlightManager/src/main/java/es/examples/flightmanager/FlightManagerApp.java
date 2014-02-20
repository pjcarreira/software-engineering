package es.examples.flightmanager;

import es.examples.flightmanager.domain.Airline;
import es.examples.flightmanager.domain.Flight;
import es.examples.flightmanager.domain.FlightManager;
import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.fenixframework.pstm.Transaction;

/**
 * The main class for the flight manager application. 
 * 
 * @author Eugenio Ribeiro
 */
public final class FlightManagerApp {

	/**
	 * A dummy private constructor to override the default one.
	 */
	private FlightManagerApp() {
		// Never used
	}
	
	/**
	 * The main method.
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
		
		System.out.println("Welcome to the Flight Manager!");
		System.out.println("Current flights:");

    	boolean committed = false;

    	try {
    		Transaction.begin();

    		FlightManager man = FenixFramework.getRoot();
		
			for(Airline al : man.getAirlineSet()) {
				for(Flight f : al.getFlight()) {
					System.out.println(al.getIata() + " " + String.format("%04d", f.getId()) + ": "
						+ f.getOrigin().getCity() + "(" + f.getOrigin().getIata() + "), "
						+ f.getDestination().getCity() + "(" + f.getDestination().getIata()
						+ "), " + String.format("%02d", f.getTime().getHourOfDay())
						+ ":" + String.format("%02d", f.getTime().getMinuteOfHour()));
				}
			}
    		
    		Transaction.commit();
    		committed = true;
    	} finally {
    		if (!committed)
    			Transaction.abort();
    	}
		
	}

}
