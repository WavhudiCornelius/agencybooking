## Booking Agency API

This REST API provides endpoints for managing bookings, guests, and hotels within a booking agency system.

**Prerequisites**

* A running instance of the Spring Boot application exposing the API (typically on http://localhost:8080)

**Base URL**

All API endpoints are located under the base URL: `http://localhost:8080/api`

**Data Format**

The API uses JSON for request and response data. Specify the `Content-Type: application/json` header in your requests.

### **Bookings**

* **Get all bookings**
  `GET /bookings`
  Returns a list of booking objects. 

* **Get a booking by ID**
  `GET /bookings/{bookingId}`
  Retrieves a specific booking based on its ID.

* **Add a booking** 
  `POST /bookings` 
  * **Request Body:** JSON object representing the booking (see example below). 
  * **Returns:** The created booking object.

* **Update a booking**
  `PUT /bookings/{bookingId}`
  * **Request Body:** JSON object with the updated booking fields.
  * **Returns:** The updated booking object.

* **Delete a booking**
  `DELETE /bookings/{bookingId}`
  Deletes a booking based on its ID.

**Booking Request Example:**
```json
{
  "guestEmail": "mulaudzi@gmail.com",
  "hotelEmail": "hotel@sky.com",
  "roomType": "King",
  "rooms": 1,
  "adults": 2,
  "children": 0,
  "arrival": "2023-12-20T14:00:00",
  "departure": "2023-12-25T11:00:00",
  "userOfEntryAndUpdate": "wavhudi"
}
