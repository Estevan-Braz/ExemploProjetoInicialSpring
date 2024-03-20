create table usuario(
	id bigint auto_increment primary key,
	nome text,
	email text,
	senha text,
	data_nascimento date,
	ultimo_login timestamp,
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp on update current_timestamp
);

create table produto(
	id bigint auto_increment primary key,
	nome text,
	descricao text,
	quantidade_estoque int,
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp on update current_timestamp
);