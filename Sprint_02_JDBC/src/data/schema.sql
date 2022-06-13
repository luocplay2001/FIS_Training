CREATE TABLE `criminal_db`.`criminal_case`
(
    `criminal_case_id`    INT NOT NULL,
    `version`             INT NULL,
    `createdAt`           DATETIME NULL,
    `modifiedAt`          DATETIME NULL,
    `number`              VARCHAR(45) NULL,
    `type`                VARCHAR(45) NULL,
    `short_description`   VARCHAR(45) NULL,
    `detailed_escription` VARCHAR(45) NULL,
    `status`              VARCHAR(45) NULL,
    `notes`               VARCHAR(45) NULL,
    `lead_investigator`   INT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `criminal_db`.`detective`
(
    `detective_id` INT NOT NULL,
    `version`      INT NULL,
    `createdAt`    DATETIME NULL,
    `modifiedAt`   DATETIME NULL,
    `username`     VARCHAR(45) NULL,
    `first_name`   VARCHAR(45) NULL,
    `last_name`    VARCHAR(45) NULL,
    `password`     VARCHAR(45) NULL,
    `hiringDate`   DATETIME NULL,
    `badgeNumber`  VARCHAR(45) NULL,
    `rank`         VARCHAR(45) NULL,
    `armed`        TINYINT NULL,
    `status`       VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE
);

CREATE TABLE `criminal_db`.`evidence`
(
    `evidence_id`      INT NOT NULL,
    `version`          INT NULL,
    `createdAt`        DATETIME NULL,
    `modifiedAt`       INT NULL,
    `number`           VARCHAR(45) NULL,
    `item_name`        VARCHAR(45) NULL,
    `notes`            VARCHAR(45) NULL,
    `archived`         TINYINT NULL,
    `criminal_case_id` INT NULL,
    `storage_id`       INT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `criminal_db`.`storage`
(
    `storage_id` INT NOT NULL,
    `version`    INT NULL,
    `createdAt`  DATETIME NULL,
    `modifiedAt` DATETIME NULL,
    `name`       VARCHAR(45) NULL,
    `location`   VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `criminal_db`.`track_entry`
(
    `track_entry_id` INT NOT NULL,
    `version`        INT NULL,
    `createdAt`      DATETIME NULL,
    `modifiedAt`     DATETIME NULL,
    `date`           DATETIME NULL,
    `evidence_id`    INT NULL,
    `detective_id`   INT NULL,
    `action`         VARCHAR(45) NULL,
    `resson`         VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);

SELECT criminal_detective.*
FROM criminal_detective
         INNER JOIN criminal_case
                    ON criminal_case.criminal_case_id = criminal_detective.criminal_case_id;


CREATE TABLE `criminal_db`.`criminal_detective`
(
    `criminal_detective_id` INT NOT NULL,
    `criminal_case_id`      INT NULL,
    `detective_id`          INT NULL,
    PRIMARY KEY (`id`)
);