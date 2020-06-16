#ROLE TABLE----------------------------------------------------------------------------
INSERT INTO up_views.role (ID, ROLE)
VALUES
(1, 'ADMIN'),
(2, 'USER');


#ROLE TABLE----------------------------------------------------------------------------
INSERT INTO up_views.rank_ (ID, RANK_TYPE)
VALUES
(1, 'TESTER'),
(2, 'MEMBER'),
(3, 'RIDER'),
(4, 'CHAMP'),
(5, 'VIP'),
(6, 'STAR'),
(7, 'KING');


#STATUS TABLE----------------------------------------------------------------------------
INSERT INTO up_views.status (ID, STATUS)
VALUES
(1, 'STARTED'),
(2, 'IN_PROGRESS'),
(3, 'FINISHED');


#PAYMENT TABLE----------------------------------------------------------------------------
INSERT INTO up_views.payment (ID, PAYMENT_TYPE)
VALUES
(1, 'PAYPAL'),
(2, 'CARD'),
(3, 'CRYPTO');


#CATEGORY TABLE----------------------------------------------------------------------------
INSERT INTO up_views.category (ID, CATEGORY)
VALUES
(1, 'YOUTUBE'),
(2, 'FACEBOOK'),
(3, 'TWITTER'),
(4, 'INSTAGRAM'),
(5, 'SOUNDCLOUD'),
(6, 'TIKTOK');


#USER TABLE----------------------------------------------------------------------------
INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID)
VALUES (1, 'gizet', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 1);

INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID)
VALUES (2, 'cosmina', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2);

INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID)
VALUES (5, 'misu', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2);

INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID)
VALUES (6, 'gabitu', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2);

INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID)
VALUES (7, 'twister', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2);



#ACCOUNT TABLE----------------------------------------------------------------------------
INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, USER_ID, RANK_ID, CART_ID)
VALUES (1, 'Gheorghe', 'Manzat', 'ghmanzat@fortech.ro', 'Nothing to say...');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (2, 'Florin', 'Tansanu', 'tansanu@fortech.ro', 'Me neither....');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (3, 'Constantin', 'Lungu', 'lungu@fortech.ro', 'Mi-e foame...');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (4, 'Madalina', 'Magdalena', 'magdalena@fortech.ro', 'I like IT.!');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (5, 'Cristina', 'Manolache', 'manolache@gmail.com', 'HR is my life.');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (6, 'Ionica', 'Vanzatoru', 'vanzatoru@gmail.com', 'Cumperi un pix?');

INSERT INTO up_views.user_info (ID, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES (7, 'Beatrice', 'Toma', 'beatrice@gmail.com', 'Ma duc la yoga :))');




#ORDER TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO upview.order_ (ID, ORDER_DATE, PRODUCT_ID, PAYMENT_ID, STATUS_ID)
VALUES
(1,'2019-01-01  09:34:21' 1, 1, 3);
(2,'2019-01-01  09:35:21' 3, 1, 3);
(3,'2019-03-01  09:25:21' 4, 1, 3);



#CART TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO upview.cart (ID, TYPE, CART_ORDER_DATE, ORDER_ID)
VALUES
(1, 'LOGGED', '2019-01-01  09:34:21', 1);
(2, 'ANONYM', '2019-02-03  09:34:21', 3);



#PRODUCT TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO upview.product (ID, NAME, PRICE, AMOUNT, DISCOUNT, CATEGORY_ID, DESCRIPTION)
VALUES
(1, Youtube_views, 2.99, 500, 0, 1, 'Buy youtube views 2.99/500 views'),
(2, Youtube_subscribers, 3.99, 50, 0, 1, 'Buy youtube subscribers 3.99/50 subscribers'),
(3, Youtube_likes, 3.99, 50, 0, 1, 'Buy youtube likes 3.99/50 likes'),
(4, Youtube_shares, 2.49, 500, 0, 1, 'Buy youtube shares 2.49/50 shares'),
(5, Youtube_comments, 3.99, 10, 0, 1, 'Buy youtube comments 3.99/500 comments'),

(6, TikTok_views, 1.39, 0, 6, 'Buy tiktok views 2.99/1000 views'),

(7, Instagram_views, 2.99, 0, 4, 'Buy instagram likes 2.99/100 likes'),
(8, Instagram_comments, 2.39, 0, 4, 'Buy instagram comments 2.39/10 comments'),

(9, Facebook_comments, 3.99, 0, 2, 'Buy facebook comments 3.99/10 comments'),

(10, Twitter_comments, 2.99, 0, 3, 'Buy twitter comments 2.99/10 comments'),

(11, Soundcloud_plays, 1.99, 0, 5, 'Buy soundcloud plays 1.99/1000 plays'),
(12, Soundcloud_followers, 3.59, 0, 5, 'Buy soundcloud followers 3.59/100 followers'),
(13, Soundcloud_likes, 2.99, 0, 5, 'Buy soundcloud likes 2.99/100 likes'),
(14, Soundcloud_reposts, 1.99, 0, 5, 'Buy soundcloud reposts 1.99/100 reposts'),
(15, Soundcloud_downloads, 1.99, 0, 5, 'Buy soundcloud downloads 1.99/1000 downloads'),
(16, Soundcloud_comments, 3.99, 0, 5, 'Buy soundcloud comments 3.99/10 comments');


#WALLET_TRANSACTION TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO upview.wallet_transaction (ID, AMOUNT, TRANSACTION_DATE, PAYMENT_ID, TRANSACTION_TYPE_ID)
VALUES
(1, '1000', '2018-12-121  11:25:21', 1, 1),
(2, '2.99', '2019-02-03  09:34:21', 1, 1);


#WALLET TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO upview.wallet (ID, NAME, CURRENCY, BALANCE, ACCOUNT_ID)
VALUES
(1, 997.01, 1);



