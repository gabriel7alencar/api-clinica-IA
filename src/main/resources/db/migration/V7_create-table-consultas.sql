create table consultas(
    id bigint not null auto_increment primary key,
    medico_id bigint not null,
    paciente_id bigint not null,
    data_consulta datetime not null,

    foreign key (medico_id) references medicos(id),
    foreign key (paciente_id) references pacientes(id)
)