USE balanced_match;
CREATE TABLE player_profile_db
(
    player_id int unsigned auto_increment primary key,
    player_name varchar(30) not null,
    player_stamina int,
    player_pace int,
    player_dribbling int,
    player_vision int,
    player_first_touch int,
    player_pass int,
    player_defence int,
    player_middle int,
    player_attack int,
    player_role varchar(3),


    constraint stamina CHECK ( player_stamina BETWEEN 1 AND 100),
    constraint pace CHECK ( player_pace BETWEEN 1 AND 100),
    constraint dribbling CHECK ( player_dribbling BETWEEN 1 AND 100),
    constraint vision CHECK ( player_vision BETWEEN 1 AND 100),
    constraint first_touch CHECK ( player_first_touch BETWEEN 1 AND 100),
    constraint pass CHECK ( player_pass BETWEEN 1 AND 100),
    constraint defence CHECK ( player_defence BETWEEN 1 AND 100),
    constraint middle CHECK ( player_middle BETWEEN 1 AND 100),
    constraint attack CHECK ( player_attack BETWEEN 1 AND 100)
)