-- encrypted passwords are pass

INSERT INTO system_user(username, password, roles, enabled)
VALUES('user1', '$2a$04$07X8/.GeXqaJeQhvUvg1yecyUOBbxDzFk3ZevSTt.q5WT8BTNtlmu', 'ROLE_USER', 1);

INSERT INTO system_user(username, password, roles, enabled)
VALUES('user2', '$2a$04$07X8/.GeXqaJeQhvUvg1yecyUOBbxDzFk3ZevSTt.q5WT8BTNtlmu', 'ROLE_USER', 1);

INSERT INTO system_user(username, password, roles, enabled)
VALUES('admin', '$2a$04$07X8/.GeXqaJeQhvUvg1yecyUOBbxDzFk3ZevSTt.q5WT8BTNtlmu', 'ROLE_ADMIN', 1);