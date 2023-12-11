INSERT IGNORE INTO category_table (name, image_path)
VALUES
('Cosmetic', '/image/cosmetic_cat.jpeg'),
('Electronic', '/image/electronic_cat.jpeg'),
('Grocery', '/image/groceries_cat.jpeg'),
('Toys', '/image/toys_cat.jpg'),
('Watch', '/image/watch_cat.jpeg'),
('Home Gadgets', '/image/home_cat.jpeg'),
('Mens Fashion', '/image/mensfashion_cat.jpeg'),
('Womens Fashion', '/image/womensfashion_cat.jpeg');

INSERT IGNORE INTO user_table (NAME, EMAIL, GENDER, PASSWORD, PHONE_NUMBER, DATE_OF_BIRTH, ROLE)
VALUES
('Freeman Urban Store', 'freemanurbanstore@gmail.com','Male','Freeman@123', '9823000000', '2000-01-01', 'ADMIN'),
('Utsab Sapkota', 'utsabsapkota4231@gmail.com','Male', 'Utsab@123', '9869664161', '2001-12-29', 'USER'),
('Sushant Neupane', 'nsushant09@gmail.com','Male', 'Sushant@123', '9823579122', '2003-02-12', 'USER'),
('Suprit Gautam', 'suprit@gmail.com','Male', 'Suprit@123', '9869664161', '2001-08-29', 'USER');