INSERT INTO `criminal_db`.`criminal_detective` (`criminal_detective_id`, `criminal_case_id`, `detective_id`) VALUES ('1', '1', '1');
INSERT INTO `criminal_db`.`criminal_detective` (`criminal_detective_id`, `criminal_case_id`, `detective_id`) VALUES ('2', '1', '2');
INSERT INTO `criminal_db`.`criminal_detective` (`criminal_detective_id`, `criminal_case_id`, `detective_id`) VALUES ('3', '1', '3');
INSERT INTO `criminal_db`.`criminal_detective` (`criminal_detective_id`, `criminal_case_id`, `detective_id`) VALUES ('4', '2', '2');
INSERT INTO `criminal_db`.`criminal_detective` (`criminal_detective_id`, `criminal_case_id`, `detective_id`) VALUES ('5', '2', '3');

INSERT INTO `criminal_db`.`detective` (`detective_id`, `version`, `createdAt`, `modifiedAt`, `username`, `first_name`, `last_name`, `password`, `hiringDate`, `badgeNumber`, `rank`, `armed`, `status`) VALUES ('1', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', 'kien111', 'Nguyễn', 'Kiên', '123', '2022-06-10 12:03:48', '123412', 'SENIOR', '1', 'SUBMITTED');
INSERT INTO `criminal_db`.`detective` (`detective_id`, `version`, `createdAt`, `modifiedAt`, `username`, `first_name`, `last_name`, `password`, `hiringDate`, `badgeNumber`, `rank`, `armed`, `status`) VALUES ('2', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', 'hanh222', 'Đỗ', 'Hạnh', '123', '2022-06-10 12:03:48', '412521', 'SENIOR', '1', 'SUBMITTED');
INSERT INTO `criminal_db`.`detective` (`detective_id`, `version`, `createdAt`, `modifiedAt`, `username`, `first_name`, `last_name`, `password`, `hiringDate`, `badgeNumber`, `rank`, `armed`, `status`) VALUES ('3', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', 'thao333', 'Nguyễn  ', 'Thao', '123', '2022-06-10 12:03:48', '543523', 'SENIOR', '1', 'SUBMITTED');


INSERT INTO `criminal_db`.`storage` (`storage_id`, `version`, `createdAt`, `modifiedAt`, `name`, `location`) VALUES ('1', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', 'kho 1', 'storage 1');
INSERT INTO `criminal_db`.`storage` (`storage_id`, `version`, `createdAt`, `modifiedAt`, `name`, `location`) VALUES ('2', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', 'kho 2', 'storage 2');


INSERT INTO `criminal_db`.`evidence` (`evidence_id`, `version`, `createdAt`, `modifiedAt`, `number`, `item_name`, `notes`, `archived`, `criminal_case_id`, `storage_id`) VALUES ('1', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', '213412', 'evidence 1', 'evidence 11', '1', '1', '1');
INSERT INTO `criminal_db`.`evidence` (`evidence_id`, `version`, `createdAt`, `modifiedAt`, `number`, `item_name`, `notes`, `archived`, `criminal_case_id`, `storage_id`) VALUES ('2', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', '534231', 'evidence 2', 'evidence 22', '1', '2', '2');

INSERT INTO `criminal_db`.`track_entry` (`track_entry_id`, `version`, `createdAt`, `modifiedAt`, `date`, `evidence_id`, `detective_id`, `action`, `resson`) VALUES ('1', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', '2022-06-10 16:25:24', '1', '1', 'SUBMITTED', 'resson');
INSERT INTO `criminal_db`.`track_entry` (`track_entry_id`, `version`, `createdAt`, `modifiedAt`, `date`, `evidence_id`, `detective_id`, `action`, `resson`) VALUES ('2', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', '2022-06-10 16:25:24', '1', '2', 'SUBMITTED', 'resson');
INSERT INTO `criminal_db`.`track_entry` (`track_entry_id`, `version`, `createdAt`, `modifiedAt`, `date`, `evidence_id`, `detective_id`, `action`, `resson`) VALUES ('3', '1', '2022-06-10 12:03:48', '2022-06-10 16:25:24', '2022-06-10 16:25:24', '2', '3', 'SUBMITTED', 'resson');
