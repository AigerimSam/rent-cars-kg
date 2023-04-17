-- auto-generated definition
create table tb_car_car_busy_days
(
    car_id           uuid not null
        constraint fk42jx9ilgy5u370bvj7ywfjm1f
            references tb_car,
    car_busy_days_id uuid not null
        constraint uk_96k78dtga3t5q0twf5puf9wwy
            unique
        constraint fkdf2ao14mfuho9i0rt6iph1wqc
            references tb_cars_busy_days
);

alter table tb_car_car_busy_days
    owner to postgres;

