create table tb_car_price
(
    car_id    uuid not null
        constraint fko0me1ags8h4kwh2ohv7xc24va
            references tb_car,
    prices_id uuid not null
        constraint uk_o6llckto5w380fl33d8899ae6
            unique
        constraint fk9bgqh4st10ajbkvwoumlum4k1
            references tb_price
);

alter table tb_car_price
    owner to postgres;