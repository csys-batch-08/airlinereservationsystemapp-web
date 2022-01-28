Create Table Register (
NAMES           NOT NULL VARCHAR2(100) 
EMAIL_ID        NOT NULL VARCHAR2(100) 
USER_NAME       NOT NULL VARCHAR2(50)  
PASSWORD        NOT NULL VARCHAR2(100) 
GENDER                   VARCHAR2(20)  
PHONE_NUMBER    NOT NULL NUMBER(20)    
REGISTERED_DATE          DATE          
IS_ADMIN                 VARCHAR2(10)  )


Create Table Flight_Details (
FLIGHT_ID             NOT NULL NUMBER                            
FLIGHT_NAME                    VARCHAR2(100)                     
SOURCE                         VARCHAR2(100)                     
DESTINATION                    VARCHAR2(100)                     
ECONOMY_CLASS                  NUMBER(38)                        
PREMIUM_ECONOMY_CLASS          NUMBER(38)                        
BUSSINESS_CLASS                NUMBER(38)                        
ARRIVAL_DATE                   DATE                              
DEPARTURE_DATE                 DATE                              
ARRIVALTIME                    TIMESTAMP(6) WITH LOCAL TIME ZONE )


Create Table Flight_seats_availabilty(
SOURCE                      VARCHAR2(100) 
DESTINATION                 VARCHAR2(100) 
ECOMOMY_SEATS               NUMBER(38)    
BUSINESS_SEATS              NUMBER(38)    
PREMIUM_ECONOMY_SEATS       NUMBER(38)    
FLIGHT_DEPARTURE_DATE       DATE          
FLIGHT_ID                   NUMBER(20)    
)


Create Table Passenger_Details (
PASSENGER_NAME NOT NULL VARCHAR2(100) 
CLASS                   VARCHAR2(50)  
MOBILE_NUMBER  NOT NULL NUMBER(20)    
SOURCE         NOT NULL VARCHAR2(100) 
DESTINATION    NOT NULL VARCHAR2(100) 
BOOKING_DATE            DATE          
FLIGHT_ID               NUMBER(38)    
SEAT_NO        NOT NULL NUMBER        
TICKET_NO               NUMBER(38)    
STATUS                  VARCHAR2(100) 
USER_NAME               VARCHAR2(100) 
)


Create Table Wallet_Details (
USER_NAME           VARCHAR2(100) 
WALLET_AMOUNT       NUMBER        
)

Create Table PaymentDetails (
FLIGHTID                NUMBER(38)   
TICKETNO                NUMBER(38)   
TOTALAMOUNT             NUMBER(10)   
MODEOFTRANSACTION       VARCHAR2(10) 
USERNAME                VARCHAR2(10) 
)