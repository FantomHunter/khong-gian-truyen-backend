INSERT INTO author
(name)
VALUES('author');

INSERT INTO product
(description, image_url, name, publish_date, status, total_chapter, `type`, author_id)
VALUES('description', 'http://placehold.it/32x32', 'product name 1', '2020-10-19 16:00:00.0', 'PUBLISHING', 100, 'TRANSLATED', 1);
INSERT INTO product
(description, image_url, name, publish_date, status, total_chapter, `type`, author_id)
VALUES('description', 'http://placehold.it/32x32', 'product name 2', '2020-10-17 16:00:00.0', 'PUBLISHING', 200, 'TRANSLATED', 1);
INSERT INTO product
(description, image_url, name, publish_date, status, total_chapter, `type`, author_id)
VALUES('description', 'http://placehold.it/32x32', 'product name 3', '2020-10-18 16:00:00.0', 'PUBLISHING', 300, 'TRANSLATED', 1);

INSERT INTO `user`
(id, name)
VALUES('user-1', 'user1');
INSERT INTO `user`
(id, name)
VALUES('user-2', 'user2');
INSERT INTO `user`
(id, name)
VALUES('user-3', 'user3');

INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 3 comment', 1, 'user-3');
INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 3 comment', 2, 'user-3');
INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 3 comment', 3, 'user-3');
INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 2 comment', 2, 'user-2');
INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 2 comment', 2, 'user-2');
INSERT INTO comment
(commented_at, content, product_id, user_id)
VALUES('2020-10-18 16:00:00.0', 'user 1 comment', 3, 'user-1');

INSERT INTO category
(name)
VALUES('category 1');
INSERT INTO category
(name)
VALUES('category 2');
