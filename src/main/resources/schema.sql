insert into user_table
(id, name, email, password, is_admin)
values(default, 'pedro', 'pedro@pedro.com', '$2a$10$UQ/jc34qDT6Xo4nhpHJyBuKNPhsrUvMJ4QNTTKcD4GCnKruXZ0QKK', false);
insert into user_table
(id, name, email, password, is_admin)
values(default, 'luiz', 'luiz@luiz.com', '$2a$10$wUqTe2/ALRHi2kDNG7npwuEJZZietCgwYffTWJXYT3ra4X91VSOae', true);

insert into vehicle_table
(id, name, brand, model, image_path)
values(default, 'onix', 'gm', 'sport', 'some-path');

insert into vehicle_table
(id, name, brand, model, image_path)
values(default, '320i', 'bmw', 'sport', 'some-path');

insert into vehicle_table
(id, name, brand, model, image_path)
values(default, 'renegade', 'jeep', 'sport', 'some-path');