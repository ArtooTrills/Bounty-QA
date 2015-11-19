package org.cleartrip.testmethods;
import java.io.IOException;

import org.cleartrip.maincontroller.MainController;
import org.cleartrip.pageobjects.ClearTripFlightPageObjects;
import org.testng.annotations.Test;

public class ClearTripBookingTest extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */
  
  @Test
  public void Artoo_ClearTrip_FlightBooking_OneWay_001() throws IOException, InterruptedException{ 
	  ClearTripFlightPageObjects flightPage = new ClearTripFlightPageObjects(driver);
	  flightPage.bookFlightTicket();
  }
  
  @Test
  public void Artoo_ClearTrip_FlightBooking_ErrorScenario_002() throws IOException, InterruptedException {
	  ClearTripFlightPageObjects flightPage = new ClearTripFlightPageObjects(driver);
	  flightPage.checkErrorMsgInFlightPage();
  }
}