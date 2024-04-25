INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code)
VALUES (1, '123 Main St', 'Apt 4', 'New City', '12345'),
       (2, '456 Maple Ave', NULL, 'Old Town', '67890'),
       (3, '789 Oak St', 'Suite 2', 'Lakeside', '54321'),
       (4, '321 Elm St', NULL, 'River City', '98765');

INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, specialization, doctor_number, address_id)
VALUES (1, 'John', 'Doe', '123456789', 'johndoe@example.com', 'CARDIOLOGY', 'D001', '1'),
       (2, 'Jane', 'Smith', '987654321', 'janesmith@example.com', 'DERMATOLOGY', 'D002', '1'),
       (3, 'Emily', 'Johnson', '5647382910', NULL, 'NEUROLOGY', 'D003', '3'),
       (4, 'Mike', 'Brown', '123987456', 'mikebrown@example.com', 'ORTHOPEDICS', 'D004', '2');

INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
VALUES (1, 'Alice', 'Wong', '321654987', 'alicewong@example.com', 'P1001', '1985-07-16'),
       (2, 'Bob', 'Marley', '654321789', NULL, 'P1002', '1990-12-01'),
       (3, 'Charlie', 'Garcia', '987654321', 'charlieg@example.com', 'P1003', '1975-05-21'),
       (4, 'Diana', 'Prince', '123789456', 'dianap@example.com', 'P1004', '1988-11-30');

INSERT INTO VISIT (id, description, time, doctor_id, patient_id)
VALUES (1, 'Annual physical exam', '2023-04-12 14:30:00', 1, 1),
       (2, 'Routine dermatology checkup', '2023-04-13 09:00:00', 2, 2),
       (3, 'Follow-up for neurological assessment', '2023-04-14 16:00:00', 3, 3),
       (4, 'Orthopedic consultation', '2023-04-15 10:00:00', 4, 4);

INSERT INTO MEDICAL_TREATMENT (id, description, visit_id)
VALUES (1, 'Blood test', 1),
       (2, 'Skin biopsy', 2),
       (3, 'MRI scan', 3),
       (4, 'X-ray', 4);


