create table tipo_documento
(
    id     serial
        constraint tipo_documento_pk
            primary key,
    codigo varchar,
    nombre varchar
);

INSERT INTO tipo_documento (id, codigo, nombre) VALUES (1, 'CC', 'Cedula de ciudadania');

create table mecanicos
(
    id               serial
        constraint mecanicos_pk
            primary key,
    tipo_documento   integer not null
        constraint mecanicos_tipo_documento_id_fk
            references tipo_documento,
    documento        integer not null,
    primer_nombre    varchar not null,
    segundo_nombre   varchar,
    primer_apellido  varchar not null,
    segundo_apellido varchar,
    celular          varchar not null,
    direccion        varchar not null,
    email            varchar not null,
    estado           char    not null
);