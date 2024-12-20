-- Treatments for Patient 1 (medical_case_id = 1, medical_doctor_id = 1)
INSERT INTO treatment (id, details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES
    (1, 'Physical therapy for broken leg', '2025-12-10 00:00:00.000000', 'Physiotherapy', '2025-12-01 00:00:00.000000', 'PLANNED', 1, 1),
    (2, 'Surgical repair of the femur', '2025-12-15 00:00:00.000000', 'Surgery', '2025-12-05 00:00:00.000000', 'ONGOING', 1, 1),
    (3, 'Pain management post-surgery', '2025-12-20 00:00:00.000000', 'Pain Management', '2025-12-10 00:00:00.000000', 'COMPLETED', 1, 1),
    (4, 'Post-operative wound care', '2025-12-25 00:00:00.000000', 'Wound Care', '2025-12-15 00:00:00.000000', 'ONGOING', 1, 1),
    (5, 'Rehabilitation after surgery', '2026-01-01 00:00:00.000000', 'Rehabilitation', '2025-12-20 00:00:00.000000', 'PLANNED', 1, 1);

-- Treatments for Patient 2 (medical_case_id = 2, medical_doctor_id = 2)
INSERT INTO treatment (id, details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES
    (6, 'Surgical extraction of wisdom teeth', '2025-12-10 00:00:00.000000', 'Tooth Extraction', '2025-12-01 00:00:00.000000', 'PLANNED', 2, 2),
    (7, 'Post-extraction care and pain management', '2025-12-15 00:00:00.000000', 'Pain Management', '2025-12-05 00:00:00.000000', 'ONGOING', 2, 2),
    (8, 'Antibiotic therapy', '2025-12-20 00:00:00.000000', 'Antibiotic Treatment', '2025-12-10 00:00:00.000000', 'COMPLETED', 2, 2),
    (9, 'Follow-up check-up after surgery', '2025-12-25 00:00:00.000000', 'Check-Up', '2025-12-15 00:00:00.000000', 'ONGOING', 2, 2),
    (10, 'Rehabilitation of jaw function', '2026-01-01 00:00:00.000000', 'Rehabilitation', '2025-12-20 00:00:00.000000', 'PLANNED', 2, 2);

-- Treatments for Patient 3 (medical_case_id = 3, medical_doctor_id = 3)
INSERT INTO treatment (id, details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES
    (11, 'Chemotherapy for cancer treatment', '2025-12-10 00:00:00.000000', 'Chemotherapy', '2025-12-01 00:00:00.000000', 'PLANNED', 3, 3),
    (12, 'Radiation therapy', '2025-12-15 00:00:00.000000', 'Radiation Therapy', '2025-12-05 00:00:00.000000', 'ONGOING', 3, 3),
    (13, 'Post-chemotherapy recovery', '2025-12-20 00:00:00.000000', 'Recovery Treatment', '2025-12-10 00:00:00.000000', 'COMPLETED', 3, 3),
    (14, 'Supportive care and pain management', '2025-12-25 00:00:00.000000', 'Pain Management', '2025-12-15 00:00:00.000000', 'ONGOING', 3, 3),
    (15, 'Psychological support during treatment', '2026-01-01 00:00:00.000000', 'Psychological Support', '2025-12-20 00:00:00.000000', 'PLANNED', 3, 3);

-- Treatments for Patient 4 (medical_case_id = 4, medical_doctor_id = 4)
INSERT INTO treatment (id, details, end_date, name, start_date, status, medical_case_id, medical_doctor_id)
VALUES
    (16, 'Hip replacement surgery', '2025-12-10 00:00:00.000000', 'Hip Surgery', '2025-12-01 00:00:00.000000', 'PLANNED', 4, 4),
    (17, 'Post-operative recovery', '2025-12-15 00:00:00.000000', 'Recovery Care', '2025-12-05 00:00:00.000000', 'ONGOING', 4, 4),
    (18, 'Physical therapy for hip recovery', '2025-12-20 00:00:00.000000', 'Physiotherapy', '2025-12-10 00:00:00.000000', 'COMPLETED', 4, 4),
    (19, 'Follow-up check-up for hip surgery', '2025-12-25 00:00:00.000000', 'Check-Up', '2025-12-15 00:00:00.000000', 'ONGOING', 4, 4),
    (20, 'Long-term rehabilitation for mobility', '2026-01-01 00:00:00.000000', 'Rehabilitation', '2025-12-20 00:00:00.000000', 'PLANNED', 4, 4);

