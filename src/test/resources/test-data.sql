INSERT INTO hotel (id, name, email, tel_number, mobile_number, fax_number, address, rating, doe, uoe, dlu, ulu)
VALUES (1, 'Grand Hotel', 'grandhotel@example.com', '123-456-7890', '987-654-3210', '012-345-6789', '123 Main Street', 5, CURRENT_TIMESTAMP, 'testuser', CURRENT_TIMESTAMP, 'testuser');

INSERT INTO guest (id, name, surname, email, mobile_number, address, doe, uoe, dlu, ulu)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', '555-123-4567', '789 Elm Street', CURRENT_TIMESTAMP, 'testsystem', CURRENT_TIMESTAMP, 'testsystem');

INSERT INTO booking (id, hotel_id, guest_id, room_type, rooms, adults, children, arrival, departure, doe, uoe, dlu, ulu)
VALUES (1, 1, 1, 'Standard', 2, 3, 1, '2023-12-20 14:00:00', '2023-12-25 11:00:00', CURRENT_TIMESTAMP, 'testuser', CURRENT_TIMESTAMP, 'testuser');
