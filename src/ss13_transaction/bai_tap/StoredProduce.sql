use demo;

DELIMITER $$

CREATE PROCEDURE select_all_users()

BEGIN

    SELECT *

    FROM users;

END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE delete_user(in id int(10))

BEGIN

    Delete from `users` where users.id = id;
    
END$$

DELIMITER ;
