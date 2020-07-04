create table users_db
(
    user_id int unsigned auto_increment primary key,
    user_name varchar(30),
    user_password varchar(15),
    player_id int unsigned,
    foreign key (player_id) references player_profile_db(player_id),
    group_id int unsigned,
    foreign key (group_id) references groups_db(group_id)
)