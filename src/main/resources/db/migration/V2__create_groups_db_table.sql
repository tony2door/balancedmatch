USE balanced_match;
create table groups_db
(
    group_id int unsigned auto_increment primary key,
    group_name varchar(20) not null unique
);