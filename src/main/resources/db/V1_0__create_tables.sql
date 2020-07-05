create sequence hibernate_sequence start with 1 increment by 1;

create table article_ratings
(
    id                 bigint not null auto_increment,
    completion_rating  bigint,
    objectivity_rating bigint,
    article_id         bigint,
    user_id            bigint,
    primary key (id)
);

create table articles
(
    id  bigint not null auto_increment,
    url varchar(255),
    primary key (id)
);

create table roles
(
    id   bigint not null auto_increment,
    role varchar(255),
    primary key (id)
);

create table users
(
    id                      bigint  not null auto_increment,
    account_non_expired     boolean not null,
    account_non_locked      boolean not null,
    credentials_non_expired boolean not null,
    enabled                 boolean not null,
    password                varchar(255),
    username                varchar(255),
    primary key (id)
);

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null
);
