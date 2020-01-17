ALTER TABLE users
ADD CONSTRAINT unique_usernames
UNIQUE (username);

ALTER TABLE article_ratings
ADD CONSTRAINT unique_rating_per_user_and_article
UNIQUE (user_id, article_id)
