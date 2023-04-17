create table tb_discount
(
    id        integer generated by default as identity
        primary key,
    days       integer,
    discount   double precision,
    end_date   date,
    start_date date,
    car_id     uuid not null
        constraint fkm1k7ot4g1idcpbh2a6sqeg28i
            references tb_car
            on delete cascade
);

alter table tb_discount
    owner to postgres;
