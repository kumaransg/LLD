package lowleveldesign.uber.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    /*
      GET /bookings
      GET /booking/id
      PUT /booking/id/{status}     // REQUESTED, ACCEPTED, CANCELED_BY_DRIVER, CANCELLED_BY_RIDER, ARRIVED, RIDE_START, RIDE_END
      PUT /location/{geocode}
      PUT /availability/{status}   // OFF, ON
      PATCH /

    */

}
