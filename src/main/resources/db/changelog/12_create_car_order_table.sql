create table tb_car_order
(
    car_id   uuid not null
        constraint fko0me1ags8h4kwh2ohv7xc64vb
            references tb_car,
    order_id uuid not null
        constraint fk6xcjbmlpqnp8ie1b2c5d93iuw
            unique
        constraint fk9bgqh4st10ajbkvwoumlum4k2
            references tb_order
);

alter table tb_car_order
    owner to postgres;