INSERT INTO users (id,
                   username,
                   password,
                   is_account_non_expired,
                   is_account_non_locked,
                   is_credentials_non_expired,
                   is_enabled)
VALUES (1, 'admin', '$2y$12$9HnJ061S/p6MC3DwzI/bAeq2/Nmp1FgcbtAyhitabXeCxbHwJ2GO2',
        true, true, true, true);
-- password for user 1 => password

INSERT INTO users (id,
                   username,
                   password,
                   is_account_non_expired,
                   is_account_non_locked,
                   is_credentials_non_expired,
                   is_enabled)
VALUES (2, 'testuser', '$2y$12$9HnJ061S/p6MC3DwzI/bAeq2/Nmp1FgcbtAyhitabXeCxbHwJ2GO2',
        true, true, true, true);
-- password for user 2 => password
