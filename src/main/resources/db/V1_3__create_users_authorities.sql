create unique index ix_auth_username on users_roles (user_id, role_id);

INSERT INTO users_roles
VALUES (1, 1);
