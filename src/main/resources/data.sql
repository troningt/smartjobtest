INSERT INTO _user (username, password, email, name, role, created_at, updated_at) VALUES ('rtheran', '$2a$10$FFNkQMTKIx0eZyW3msUmE.B/n7EcO7x.kLz63LYzgECEh3ntFkgU6', 'rteran@gmail.com', 'Ronny Therán', 'ADMINISTRATOR', '2024-03-23 10:10:16.0', '2024-03-23 10:10:16.0');
INSERT INTO _user (username, password, email, name, role, created_at, updated_at) VALUES ('dtheran', '$2a$10$gBJbxOEslhH/R4g5w0PCnuYLJGWdDEmDexekJ1J0wAg5c77a3H99i', 'dtheran@gmail.com', 'Danny Therán', 'CUSTOMER', '2024-03-23 10:10:16.0', '2024-03-23 10:10:16.0');

INSERT INTO phone (number, city_code, country_code, user_id) VALUES ('3006665625', 2, 3, (SELECT _user.user_id FROM _user WHERE email = 'dtheran@gmail.com'));
