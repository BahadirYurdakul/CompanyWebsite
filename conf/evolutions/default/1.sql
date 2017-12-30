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

drop table if exists user;

