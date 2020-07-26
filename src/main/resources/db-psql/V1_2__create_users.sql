INSERT INTO users (username,
                   password,
                   account_non_expired,
                   account_non_locked,
                   credentials_non_expired,
                   enabled)
VALUES ('admin', '$2y$12$9HnJ061S/p6MC3DwzI/bAeq2/Nmp1FgcbtAyhitabXeCxbHwJ2GO2',
        true, true, true, true);
-- password for user 1 => password

INSERT INTO users (username,
                   password,
                   account_non_expired,
                   account_non_locked,
                   credentials_non_expired,
                   enabled)
VALUES ('testuser', '$2y$12$9HnJ061S/p6MC3DwzI/bAeq2/Nmp1FgcbtAyhitabXeCxbHwJ2GO2',
        true, true, true, true);
-- password for user 2 => password
