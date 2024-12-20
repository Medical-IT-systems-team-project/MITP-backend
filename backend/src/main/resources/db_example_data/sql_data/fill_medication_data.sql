-- Medications for Patient 1 (medical_case_data_id = 1, medical_doctor_id = 1)
INSERT INTO medication (id, dosage_form, end_date, name, start_date, status, strength, unit, medical_case_data_id, medical_doctor_id)
VALUES
    (1, 'Tablet', '2025-12-10 00:00:00.000000', 'Paracetamol', '2025-12-01 00:00:00.000000', 'PLANNED', '500', 'mg', 1, 1),
    (2, 'Capsule', '2025-12-15 00:00:00.000000', 'Ibuprofen', '2025-12-05 00:00:00.000000', 'ONGOING', '200', 'mg', 1, 1),
    (3, 'Injection', '2025-12-20 00:00:00.000000', 'Ceftriaxone', '2025-12-10 00:00:00.000000', 'COMPLETED', '1', 'g', 1, 1),
    (4, 'Liquid', '2025-12-25 00:00:00.000000', 'Cough Syrup', '2025-12-15 00:00:00.000000', 'ONGOING', '15', 'ml', 1, 1),
    (5, 'Tablet', '2026-01-01 00:00:00.000000', 'Metformin', '2025-12-20 00:00:00.000000', 'PLANNED', '500', 'mg', 1, 1);

-- Medications for Patient 2 (medical_case_data_id = 2, medical_doctor_id = 2)
INSERT INTO medication (id, dosage_form, end_date, name, start_date, status, strength, unit, medical_case_data_id, medical_doctor_id)
VALUES
    (6, 'Tablet', '2025-12-10 00:00:00.000000', 'Aspirin', '2025-12-01 00:00:00.000000', 'PLANNED', '300', 'mg', 2, 2),
    (7, 'Capsule', '2025-12-15 00:00:00.000000', 'Amoxicillin', '2025-12-05 00:00:00.000000', 'ONGOING', '250', 'mg', 2, 2),
    (8, 'Injection', '2025-12-20 00:00:00.000000', 'Heparin', '2025-12-10 00:00:00.000000', 'COMPLETED', '5000', 'IU', 2, 2),
    (9, 'Liquid', '2025-12-25 00:00:00.000000', 'Antacid', '2025-12-15 00:00:00.000000', 'ONGOING', '20', 'ml', 2, 2),
    (10, 'Tablet', '2026-01-01 00:00:00.000000', 'Levothyroxine', '2025-12-20 00:00:00.000000', 'PLANNED', '75', 'mcg', 2, 2);

-- Medications for Patient 3 (medical_case_data_id = 3, medical_doctor_id = 3)
INSERT INTO medication (id, dosage_form, end_date, name, start_date, status, strength, unit, medical_case_data_id, medical_doctor_id)
VALUES
    (11, 'Tablet', '2025-12-10 00:00:00.000000', 'Simvastatin', '2025-12-01 00:00:00.000000', 'PLANNED', '20', 'mg', 3, 3),
    (12, 'Capsule', '2025-12-15 00:00:00.000000', 'Omeprazole', '2025-12-05 00:00:00.000000', 'ONGOING', '40', 'mg', 3, 3),
    (13, 'Injection', '2025-12-20 00:00:00.000000', 'Insulin', '2025-12-10 00:00:00.000000', 'COMPLETED', '10', 'IU', 3, 3),
    (14, 'Liquid', '2025-12-25 00:00:00.000000', 'Iron Supplement', '2025-12-15 00:00:00.000000', 'ONGOING', '5', 'ml', 3, 3),
    (15, 'Tablet', '2026-01-01 00:00:00.000000', 'Losartan', '2025-12-20 00:00:00.000000', 'PLANNED', '50', 'mg', 3, 3);

-- Medications for Patient 4 (medical_case_data_id = 4, medical_doctor_id = 4)
INSERT INTO medication (id, dosage_form, end_date, name, start_date, status, strength, unit, medical_case_data_id, medical_doctor_id)
VALUES
    (16, 'Tablet', '2025-12-10 00:00:00.000000', 'Amlodipine', '2025-12-01 00:00:00.000000', 'PLANNED', '10', 'mg', 4, 4),
    (17, 'Capsule', '2025-12-15 00:00:00.000000', 'Vitamin D', '2025-12-05 00:00:00.000000', 'ONGOING', '1000', 'IU', 4, 4),
    (18, 'Injection', '2025-12-20 00:00:00.000000', 'B12 Injection', '2025-12-10 00:00:00.000000', 'COMPLETED', '1', 'mg', 4, 4),
    (19, 'Liquid', '2025-12-25 00:00:00.000000', 'Cough Syrup', '2025-12-15 00:00:00.000000', 'ONGOING', '10', 'ml', 4, 4),
    (20, 'Tablet', '2026-01-01 00:00:00.000000', 'Warfarin', '2025-12-20 00:00:00.000000', 'PLANNED', '5', 'mg', 4, 4);
