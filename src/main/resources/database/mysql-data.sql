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
INSERT INTO up_views.transaction_type(ID, TRANSACTION_TYPE)
VALUES
(1, 'ADD'),
(2, 'SUBSTRACT');


#CATEGORY TABLE----------------------------------------------------------------------------
INSERT INTO up_views.category (ID, CATEGORY)
VALUES
(1, 'YOUTUBE'),
(2, 'FACEBOOK'),
(3, 'TWITTER'),
(4, 'INSTAGRAM'),
(5, 'SOUNDCLOUD'),
(6, 'TIKTOK');



#PRODUCT TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO up_views.product (ID, NAME, PRICE, AMOUNT, DISCOUNT, CATEGORY_ID, DESCRIPTION) VALUES
(1, 'Youtube_views', 2.99, 500, 0, 1, 'Buy youtube views 2.99/500 views'),
(2, 'Youtube_subscribers', 3.99, 50, 0, 1, 'Buy youtube subscribers 3.99/50 subscribers'),
(3, 'Youtube_likes', 3.99, 50, 0, 1, 'Buy youtube likes 3.99/50 likes'),
(4, 'Youtube_shares', 2.49, 500, 0, 1, 'Buy youtube shares 2.49/50 shares'),
(5, 'Youtube_comments', 3.99, 10, 0, 1, 'Buy youtube comments 3.99/500 comments'),

(6, 'TikTok_views', 1.39, 1000, 0, 6, 'Buy tiktok views 2.99/1000 views'),
(7, 'TikTok_followers', 2.99, 50, 0, 6, 'Buy tiktok views 2.99/1000 views'),
(8, 'TikTok_likes', 2.99, 50, 0, 6, 'Buy tiktok views 2.99/1000 views'),

(9, 'Instagram_likes', 2.99, 100, 0, 4, 'Buy instagram likes 2.99/100 likes'),
(10, 'Instagram_comments', 2.39, 10, 0, 4, 'Buy instagram comments 2.39/10 comments'),

(11, 'Facebook_comments', 3.99, 10, 0, 2, 'Buy facebook comments 3.99/10 comments'),

(12, 'Twitter_comments', 2.99, 10, 0, 3, 'Buy twitter comments 2.99/10 comments'),

(13, 'Soundcloud_plays', 1.99, 1000, 0, 5, 'Buy soundcloud plays 1.99/1000 plays'),
(14, 'Soundcloud_followers', 3.59, 100, 0, 5, 'Buy soundcloud followers 3.59/100 followers'),
(15, 'Soundcloud_likes', 2.99, 100, 0, 5, 'Buy soundcloud likes 2.99/100 likes'),
(16, 'Soundcloud_reposts', 1.99, 100, 0, 5, 'Buy soundcloud reposts 1.99/100 reposts'),
(17, 'Soundcloud_downloads', 1.99, 1000, 0, 5, 'Buy soundcloud downloads 1.99/1000 downloads'),
(18, 'Soundcloud_comments', 3.99, 10, 0, 5, 'Buy soundcloud comments 3.99/10 comments');



#ACCOUNT TABLE----------------------------------------------------------------------------
INSERT INTO up_views.account (ID, FIRST_NAME, LAST_NAME, EMAIL, RANK_ID) VALUES
(1, 'Catalin', 'Lungu', 'lunguucatalin@gmail.com', 7),
(2, 'Cosmina', 'Iacob', 'tansanu@fortech.ro', 6),
(3, 'Mihai', 'Scutaru', 'scutaru@gmail.com', 1),
(4, 'Gabriel', 'Pasaniuc', 'gabriel@gmail.com', 1),
(5, 'Alex', 'Traistaru', 'twister@gmail.com', 2);


#USER TABLE----------------------------------------------------------------------------
INSERT INTO up_views.user (ID, USER_NAME, PASSWORD, ROLE_ID, ACCOUNT_ID) VALUES
(1, 'gizet', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 1, 1),
(2, 'cosmina', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2, 2),
(3, 'misu', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2, 3),
(4, 'gabitu', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2, 4),
(5, 'twister', '$2a$10$Ej3wkupBtxoM..0/PgSVOu9173oETSJJOpQ/tdYqJFwh5fentNumK', 2, 5);








#ORDER TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO up_views.order_ (ID, ORDER_DATE, PRODUCT_ID, PAYMENT_ID, STATUS_ID) VALUES
(1,'2019-01-01  09:34:21', 1, 1, 3),
(2,'2019-01-01  09:35:21', 3, 1, 3),
(3,'2019-03-01  09:25:21', 4, 1, 3);



#CART TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO up_views.cart (ID, TYPE, CART_ORDER_DATE, ORDER_ID) VALUES
(1, 'LOGGED', '2019-01-01  09:34:21', 1),
(2, 'ANONYM', '2019-02-03  09:34:21', null);


#WALLET TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO up_views.wallet (ID, NAME, CURRENCY, BALANCE, ACCOUNT_ID) VALUES
(1, 'GIZET_WALLET', '$', 997.01, 1);

#WALLET_TRANSACTION TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO up_views.wallet_transaction (ID, AMOUNT, TRANSACTION_DATE, PAYMENT_ID, TRANSACTION_TYPE_ID) VALUES
(1, 1000, '2018-12-12  11:25:21', 1, 1),
(2, 2.99, '2019-02-03  09:34:21', 1, 2);




