create table article_ratings
(
    id                 bigint generated always as identity primary key,
    completion_rating  bigint,
    objectivity_rating bigint,
    article_id         bigint,
    user_id            bigint
);

create table articles
(
    id  bigint generated always as identity primary key,
    url varchar(255)
);

create table roles
(
    id   bigint generated always as identity primary key,
    role varchar(255)
);

create table users
(
    id                      bigint generated always as identity primary key,
    account_non_expired     boolean not null,
    account_non_locked      boolean not null,
    credentials_non_expired boolean not null,
    enabled                 boolean not null,
    password                varchar(255),
    username                varchar(255)
);

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null
);
