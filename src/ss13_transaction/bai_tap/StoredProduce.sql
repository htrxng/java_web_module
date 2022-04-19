use demo;

DELIMITER $$

CREATE PROCEDURE select_all_users()

BEGIN

    SELECT *

    FROM users;

END$$

DELIMITER ;