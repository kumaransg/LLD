Requirement

- Air traffic control system between pilot and controller


Primary Use Case

- Pilot can send/receive request for landing, sending current flight status, take off to ATC
- ATC receives/send LANDING, TAKE OFF, CURRENT STATUS signals from Airplane    

Identify Objects (Actor and non-actors)

- Airplane
 - Pilot
 - Air Traffic Control Unit

- Flight
    - Flight Id
    - Source
    - Destination
    - Take off ts
    - Expected landing time
    - Plane number
    - Passenger Details
    - Flying crew Details
    - Flying attendant Details  
- Signal
    - Signal Type (LANDING, TAKE_OFF, LOCATION_UPDATE)
    - Content
    - UUID
    - TS

- ATC 

Responsibility of objects
 - Signal Service --> Communication between Airplane's ATU and ground ATC
 - Notification Service
   - Notify between one flight to other flights within x kms vicinity
   - Notify ATC about flight status
 - TimeSeries Service
   - Act as scheduler to decide time of send/receive signal between pilot and ATC
 - Navigation Service     

Interaction between objects
 - Start writing some above classes




