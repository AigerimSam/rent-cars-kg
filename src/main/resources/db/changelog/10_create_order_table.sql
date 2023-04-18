-- auto-generated definition
create table tb_order
(
    id                    uuid not null
        primary key,
    baby_seat             boolean,
    client_email          varchar(255),
    client_name           varchar(255),
    client_phone          varchar(255),
    count_of_days         integer,
    date_time_from        timestamp,
    date_time_to          timestamp,
    discount              double precision,
    price                 double precision,
    price_before_discount double precision,
    price_with_discount   double precision,
    with_driver           boolean,
    car_id                uuid
        constraint fksua6o58o85tbhoa26phke1een
            references tb_car,
    take_address_id        uuid
        constraint fkcq4xdbg5pvjc3g6vu88vbh7ig
            references tb_address,
    return_address_id     uuid
        constraint fkeby8lb8b68ywu9kg6cd4v37ud
            references tb_address
);

alter table tb_order
    owner to postgres;

