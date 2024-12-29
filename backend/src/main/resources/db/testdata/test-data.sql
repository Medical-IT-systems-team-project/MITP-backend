-- 1 WYPELNIJ DANE LEKARZY
INSERT INTO projekt_med.medical_doctor (email, first_name, last_name, login, password, phone_number)
VALUES ('anna.smith@hospital.com', 'Anna', 'Smith', 'asmith',
        '$2a$10$of0IzLwqYwXE0cRkz27G2eB19uoAfnCbIvB5i1q.29FmZJvjeuPMO', '987654321'),
       ('james.brown@clinic.com', 'James', 'Brown', 'jbrown',
        '$2a$10$of0IzLwqYwXE0cRkz27G2eB19uoAfnCbIvB5i1q.29FmZJvjeuPMO', '564738291'),
       ('emma.white@care.com', 'Emma', 'White', 'ewhite',
        '$2a$10$of0IzLwqYwXE0cRkz27G2eB19uoAfnCbIvB5i1q.29FmZJvjeuPMO', '1123581321'),
       ('oliver.miller@health.com', 'Oliver', 'Miller', 'omiller',
        '$2a$10$of0IzLwqYwXE0cRkz27G2eB19uoAfnCbIvB5i1q.29FmZJvjeuPMO', '9988776655');

-- 2 WYPELNIJ DANE PACJENTÓW
INSERT INTO projekt_med.patient (access_id, address, age, birth_date, email, first_name, gender, last_name,
                                 phone_number, social_security_number, status)
VALUES ('A123451234', '123 Main St, Springfield', 35, '1989-05-15 00:00:00', 'john.doe@gmail.com', 'John', 'Male',
        'Doe',
        '555-234-567', '98716514321', 'IN_HOSPITAL'),
       ('B678901234', '456 Elm St, Metropolis', 28, '1995-08-23 00:00:00', 'jane.smith@yahoo.com', 'Jane', 'Female',
        'Smith', '555-987-654', '12314516789', 'IN_HOSPITAL'),
       ('C112231234', '789 Oak St, Gotham', 42, '1981-03-12 00:00:00', 'peter.parker@marvel.com', 'Peter', 'Male',
        'Parker',
        '555-456-789', '11112213333', 'IN_HOSPITAL'),
       ('D445561234', '321 Pine St, Smallville', 30, '1993-10-30 00:00:00', 'clark.kent@dailyplanet.com', 'Clark',
        'Male',
        'Kent', '555-321-654', '22213314444', 'DISCHARGED'),
       ('E778891234', '654 Maple St, Star City', 55, '1968-01-25 00:00:00', 'diana.prince@amazon.com', 'Diana',
        'Female',
        'Prince', '555-654-321', '33314415555', 'DISCHARGED');


INSERT INTO projekt_med.medical_case (admission_date, admission_reason, description, status,
                                      attending_doctor_id, created_by_doctor_id, patient_id)
VALUES ('2025-12-08 14:30:00.000000', 'Broken leg',
        'Patient admitted with a compound fracture of the left femur after a bicycle accident.', 'ONGOING', 1, 1, 1),
       ('2025-12-09 10:00:00.000000', 'Flu symptoms',
        'Patient presented with fever, chills, and body aches. Diagnosed with influenza.', 'COMPLETED', 2, 2, 2),
       ('2025-12-10 16:15:00.000000', 'Chest pain', 'Patient admitted with acute chest pain, suspected cardiac issue.',
        'ONGOING', 3, 2, 3),
       ('2025-12-11 09:45:00.000000', 'Routine check-up', 'Patient attended for a routine medical examination.',
        'COMPLETED', 4, 4, 4);
-- 4 WYPELNIJ DANE WIZYT
-- Treatments for Patient 1 (medical_case_id = 1, medical_doctor_id = 1)
INSERT INTO projekt_med.treatment (details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES ('Physical therapy for broken leg', '2025-12-10 00:00:00.000000', 'Physiotherapy', '2025-12-01 00:00:00.000000',
        'PLANNED', 1, 1),
       ('Surgical repair of the femur', '2025-12-15 00:00:00.000000', 'Surgery', '2025-12-05 00:00:00.000000',
        'ONGOING', 1, 1),
       ('Pain management post-surgery', '2025-12-20 00:00:00.000000', 'Pain Management', '2025-12-10 00:00:00.000000',
        'COMPLETED', 1, 1),
       ('Post-operative wound care', '2025-12-25 00:00:00.000000', 'Wound Care', '2025-12-15 00:00:00.000000',
        'ONGOING', 1, 1),
       ('Rehabilitation after surgery', '2026-01-01 00:00:00.000000', 'Rehabilitation', '2025-12-20 00:00:00.000000',
        'PLANNED', 1, 1);

-- Treatments for Patient 2 (medical_case_id = 2, medical_doctor_id = 2)
INSERT INTO projekt_med.treatment (details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES ('Surgical extraction of wisdom teeth', '2025-12-10 00:00:00.000000', 'Tooth Extraction',
        '2025-12-01 00:00:00.000000', 'PLANNED', 2, 2),
       ('Post-extraction care and pain management', '2025-12-15 00:00:00.000000', 'Pain Management',
        '2025-12-05 00:00:00.000000', 'ONGOING', 2, 2),
       ('Antibiotic therapy', '2025-12-20 00:00:00.000000', 'Antibiotic Treatment', '2025-12-10 00:00:00.000000',
        'COMPLETED', 2, 2),
       ('Follow-up check-up after surgery', '2025-12-25 00:00:00.000000', 'Check-Up', '2025-12-15 00:00:00.000000',
        'ONGOING', 2, 2),
       ('Rehabilitation of jaw function', '2026-01-01 00:00:00.000000', 'Rehabilitation', '2025-12-20 00:00:00.000000',
        'PLANNED', 2, 2);

-- Treatments for Patient 3 (medical_case_id = 3, medical_doctor_id = 3)
INSERT INTO projekt_med.treatment (details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES ('Chemotherapy for cancer treatment', '2025-12-10 00:00:00.000000', 'Chemotherapy', '2025-12-01 00:00:00.000000',
        'PLANNED', 3, 3),
       ('Radiation therapy', '2025-12-15 00:00:00.000000', 'Radiation Therapy', '2025-12-05 00:00:00.000000', 'ONGOING',
        3, 3),
       ('Post-chemotherapy recovery', '2025-12-20 00:00:00.000000', 'Recovery Treatment', '2025-12-10 00:00:00.000000',
        'COMPLETED', 3, 3),
       ('Supportive care and pain management', '2025-12-25 00:00:00.000000', 'Pain Management',
        '2025-12-15 00:00:00.000000', 'ONGOING', 3, 3),
       ('Psychological support during treatment', '2026-01-01 00:00:00.000000', 'Psychological Support',
        '2025-12-20 00:00:00.000000', 'PLANNED', 3, 3);

-- Treatments for Patient 4 (medical_case_id = 4, medical_doctor_id = 4)
INSERT INTO projekt_med.treatment (details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES ('Hip replacement surgery', '2025-12-10 00:00:00.000000', 'Hip Surgery', '2025-12-01 00:00:00.000000', 'PLANNED',
        4, 4),
       ('Post-operative recovery', '2025-12-15 00:00:00.000000', 'Recovery Care', '2025-12-05 00:00:00.000000',
        'ONGOING', 4, 4),
       ('Physical therapy for hip recovery', '2025-12-20 00:00:00.000000', 'Physiotherapy',
        '2025-12-10 00:00:00.000000', 'COMPLETED', 4, 4),
       ('Follow-up check-up for hip surgery', '2025-12-25 00:00:00.000000', 'Check-Up', '2025-12-15 00:00:00.000000',
        'ONGOING', 4, 4),
       ('Long-term rehabilitation for mobility', '2026-01-01 00:00:00.000000', 'Rehabilitation',
        '2025-12-20 00:00:00.000000', 'PLANNED', 4, 4);

-- 5 WYPELNIJ DANE LEKÓW
-- Medications for Patient 1 (medical_case_id = 1, medical_doctor_id = 1)
INSERT INTO projekt_med.medication (dosage_form, end_date, name, start_date, status, strength, unit,
                                    medical_case_id, medical_doctor_id)
VALUES ('Tablet', '2025-12-10 00:00:00.000000', 'Paracetamol', '2025-12-01 00:00:00.000000', 'PLANNED', '500', 'mg', 1,
        1),
       ('Capsule', '2025-12-15 00:00:00.000000', 'Ibuprofen', '2025-12-05 00:00:00.000000', 'ONGOING', '200', 'mg', 1,
        1),
       ('Injection', '2025-12-20 00:00:00.000000', 'Ceftriaxone', '2025-12-10 00:00:00.000000', 'COMPLETED', '1', 'g',
        1, 1),
       ('Liquid', '2025-12-25 00:00:00.000000', 'Cough Syrup', '2025-12-15 00:00:00.000000', 'ONGOING', '15', 'ml', 1,
        1),
       ('Tablet', '2026-01-01 00:00:00.000000', 'Metformin', '2025-12-20 00:00:00.000000', 'PLANNED', '500', 'mg', 1,
        1);

-- Medications for Patient 2 (medical_case_id = 2, medical_doctor_id = 2)
INSERT INTO projekt_med.medication (dosage_form, end_date, name, start_date, status, strength, unit,
                                    medical_case_id, medical_doctor_id)
VALUES ('Tablet', '2025-12-10 00:00:00.000000', 'Aspirin', '2025-12-01 00:00:00.000000', 'PLANNED', '300', 'mg', 2, 2),
       ('Capsule', '2025-12-15 00:00:00.000000', 'Amoxicillin', '2025-12-05 00:00:00.000000', 'ONGOING', '250', 'mg', 2,
        2),
       ('Injection', '2025-12-20 00:00:00.000000', 'Heparin', '2025-12-10 00:00:00.000000', 'COMPLETED', '5000', 'IU',
        2, 2),
       ('Liquid', '2025-12-25 00:00:00.000000', 'Antacid', '2025-12-15 00:00:00.000000', 'ONGOING', '20', 'ml', 2, 2),
       ('Tablet', '2026-01-01 00:00:00.000000', 'Levothyroxine', '2025-12-20 00:00:00.000000', 'PLANNED', '75', 'mcg',
        2, 2);

-- Medications for Patient 3 (medical_case_id = 3, medical_doctor_id = 3)
INSERT INTO projekt_med.medication (dosage_form, end_date, name, start_date, status, strength, unit,
                                    medical_case_id, medical_doctor_id)
VALUES ('Tablet', '2025-12-10 00:00:00.000000', 'Simvastatin', '2025-12-01 00:00:00.000000', 'PLANNED', '20', 'mg', 3,
        3),
       ('Capsule', '2025-12-15 00:00:00.000000', 'Omeprazole', '2025-12-05 00:00:00.000000', 'ONGOING', '40', 'mg', 3,
        3),
       ('Injection', '2025-12-20 00:00:00.000000', 'Insulin', '2025-12-10 00:00:00.000000', 'COMPLETED', '10', 'IU', 3,
        3),
       ('Liquid', '2025-12-25 00:00:00.000000', 'Iron Supplement', '2025-12-15 00:00:00.000000', 'ONGOING', '5', 'ml',
        3, 3),
       ('Tablet', '2026-01-01 00:00:00.000000', 'Losartan', '2025-12-20 00:00:00.000000', 'PLANNED', '50', 'mg', 3, 3);

-- Medications for Patient 4 (medical_case_id = 4, medical_doctor_id = 4)
INSERT INTO projekt_med.medication (dosage_form, end_date, name, start_date, status, strength, unit,
                                    medical_case_id, medical_doctor_id)
VALUES ('Tablet', '2025-12-10 00:00:00.000000', 'Amlodipine', '2025-12-01 00:00:00.000000', 'PLANNED', '10', 'mg', 4,
        4),
       ('Capsule', '2025-12-15 00:00:00.000000', 'Vitamin D', '2025-12-05 00:00:00.000000', 'ONGOING', '1000', 'IU', 4,
        4),
       ('Injection', '2025-12-20 00:00:00.000000', 'B12 Injection', '2025-12-10 00:00:00.000000', 'COMPLETED', '1',
        'mg', 4, 4),
       ('Liquid', '2025-12-25 00:00:00.000000', 'Cough Syrup', '2025-12-15 00:00:00.000000', 'ONGOING', '10', 'ml', 4,
        4),
       ('Tablet', '2026-01-01 00:00:00.000000', 'Warfarin', '2025-12-20 00:00:00.000000', 'PLANNED', '5', 'mg', 4, 4);
