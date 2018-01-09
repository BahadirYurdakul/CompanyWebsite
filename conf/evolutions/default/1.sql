# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table article (
  articleid                     integer auto_increment not null,
  title                         varchar(255),
  photolink                     varchar(255),
  content                       varchar(255),
  author                        varchar(255),
  date                          varchar(255),
  constraint pk_article primary key (articleid)
);

create table order (
  orderno                       integer auto_increment not null,
  username                      varchar(255),
  numberoforder                 integer,
  status                        integer,
  productname                   varchar(255),
  desiredproperties             varchar(255),
  constraint pk_order primary key (orderno)
);

create table product (
  productname                   varchar(255) not null,
  info                          varchar(255),
  photolink                     varchar(255),
  estimatedarrivaltime          integer,
  difficultylevel               integer,
  constraint pk_product primary key (productname)
);

create table user (
  username                      varchar(255) not null,
  password                      varchar(255),
  email                         varchar(255),
  telephone                     varchar(255),
  companyname                   varchar(255),
  companyaddress                varchar(255),
  title                         varchar(255),
  namesurname                   varchar(255),
  constraint pk_user primary key (username)
);


# --- !Downs

drop table if exists article;

drop table if exists order;

drop table if exists product;

drop table if exists user;

