create table tb_car_discount
(
    car_id    uuid not null
        constraint fko0me1ags8h4kwh2ohv7xc64va
            references tb_car,
    discount_id uuid not null
        constraint uk_o6llckto5w380fl33d8889ae6
            unique
        constraint fk9bgqh4st10ajbkvwoumlum4k2
            references tb_discount
);

alter table tb_car_discount
    owner to postgres;