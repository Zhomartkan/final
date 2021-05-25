create table users_roles
(
    user_id bigint not null
        constraint fk2o0jvgh89lemvvo17cbqvdxaa
            references users,
    role_id bigint not null
        constraint fkj6m8fwv7oqv74fcehir1a9ffy
            references roles
);

insert into users_roles (user_id, role_id)
values (1,1),(1,2),(1,3),(2,2),(2,3),(3,3);