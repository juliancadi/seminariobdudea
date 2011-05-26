create or replace type ty_tipo as object(
  codigo varchar2(5),
  multiplo number
);
/

create table tb_tipo of ty_tipo;
alter table tb_tipo add constraint tb_tipo_pk primary key (codigo);
insert into tb_tipo values('01', 4);
insert into tb_tipo values('02', 7);
insert into tb_tipo values('03', 16);
insert into tb_tipo values('05', 5);
insert into tb_tipo values('06', 8);
insert into tb_tipo values('08', 25);


create or replace type ty_producto as object(
  referencia varchar2(30),
  identificador varchar2(20),
  tipo ref ty_tipo,
  descripcion varchar2(2000),
  cant_stock number,
  precio_unitario number,
  valor_min number,
  valor_optimo number
);
/


create table tb_producto of ty_producto;
alter table tb_producto add constraint tb_producto_pk primary key (referencia);
insert into tb_producto values ('abc-01','abc',(select ref(t) from tb_tipo t where t.codigo='01'), 'Camiseta masculina color azul talla XL', 10, 30000, 30, 50);
insert into tb_producto values ('bcd-01','bcd',(select ref(t) from tb_tipo t where t.codigo='01'), 'Jean para dama color rojo talla M', 60, 4000, 40, 90);
insert into tb_producto values ('cde-02','cde',(select ref(t) from tb_tipo t where t.codigo='02'), 'Correas militares con chapa de plata', 100, 120000, 50, 90);
insert into tb_producto values ('def-02','def',(select ref(t) from tb_tipo t where t.codigo='02'), 'Blusa de dama estampada', 10, 40000, 60, 65);
insert into tb_producto values ('efg-03','efg',(select ref(t) from tb_tipo t where t.codigo='03'), 'Falda larga verde', 200, 15000, 50, 60);
insert into tb_producto values ('fgh-03','fgh',(select ref(t) from tb_tipo t where t.codigo='03'), 'Minifalda rosada', 0, 25000, 40, 55);
insert into tb_producto values ('ghi-05','ghi',(select ref(t) from tb_tipo t where t.codigo='05'), 'Camisa de rayas talla L', 10, 30000, 30, 50);
insert into tb_producto values ('hij-05','hij',(select ref(t) from tb_tipo t where t.codigo='05'), 'Blusa escotada con perlas estampadas', 60, 4000, 40, 90);
insert into tb_producto values ('ijk-06','ijk',(select ref(t) from tb_tipo t where t.codigo='06'), 'Sandalias de playa', 100, 120000, 50, 90);
insert into tb_producto values ('jkl-06','jkl',(select ref(t) from tb_tipo t where t.codigo='06'), 'Medias color blanco', 10, 40000, 60, 65);
insert into tb_producto values ('klm-08','klm',(select ref(t) from tb_tipo t where t.codigo='08'), 'Blue-jean desteñido', 200, 15000, 50, 60);
insert into tb_producto values ('lmn-08','lmn',(select ref(t) from tb_tipo t where t.codigo='08'), 'Tennis azules fosforecentes', 0, 25000, 40, 55);
insert into tb_producto values ('mno-01','mno',(select ref(t) from tb_tipo t where t.codigo='01'), 'Camiseta masculina color azul talla XL', 10, 30000, 30, 50);
insert into tb_producto values ('mop-01','nop',(select ref(t) from tb_tipo t where t.codigo='01'), 'Jean para dama color rojo talla M', 60, 4000, 40, 90);
insert into tb_producto values ('opq-02','opq',(select ref(t) from tb_tipo t where t.codigo='02'), 'Correas militares con chapa de plata', 100, 120000, 50, 90);
insert into tb_producto values ('pqr-02','pqr',(select ref(t) from tb_tipo t where t.codigo='02'), 'Blusa de dama estampada', 10, 40000, 60, 65);
insert into tb_producto values ('qrs-03','qrs',(select ref(t) from tb_tipo t where t.codigo='03'), 'Falda larga verde', 200, 15000, 50, 60);
insert into tb_producto values ('rst-03','rst',(select ref(t) from tb_tipo t where t.codigo='03'), 'Minifalda rosada', 0, 25000, 40, 55);
insert into tb_producto values ('stu-05','stu',(select ref(t) from tb_tipo t where t.codigo='05'), 'Camisa de rayas talla L', 10, 30000, 30, 50);
insert into tb_producto values ('tuv-05','tuv',(select ref(t) from tb_tipo t where t.codigo='05'), 'Blusa escotada con perlas estampadas', 60, 4000, 40, 90);
insert into tb_producto values ('uvw-06','uvw',(select ref(t) from tb_tipo t where t.codigo='06'), 'Sandalias de playa', 100, 120000, 50, 90);
insert into tb_producto values ('vwx-06','vwx',(select ref(t) from tb_tipo t where t.codigo='06'), 'Medias color blanco', 10, 40000, 60, 65);
insert into tb_producto values ('wxy-08','wxy',(select ref(t) from tb_tipo t where t.codigo='08'), 'Blue-jean desteñido', 200, 15000, 50, 60);
insert into tb_producto values ('xyz-08','xyz',(select ref(t) from tb_tipo t where t.codigo='08'), 'Tennis azules fosforecentes', 0, 25000, 40, 55);
insert into tb_producto values ('yza-01','yza',(select ref(t) from tb_tipo t where t.codigo='01'), 'Camiseta masculina color azul talla XL', 10, 30000, 30, 50);
insert into tb_producto values ('zab-01','zab',(select ref(t) from tb_tipo t where t.codigo='01'), 'Jean para dama color rojo talla M', 60, 4000, 40, 90);
insert into tb_producto values ('zyx-02','zyx',(select ref(t) from tb_tipo t where t.codigo='02'), 'Correas militares con chapa de plata', 100, 120000, 50, 90);
insert into tb_producto values ('yxw-02','yxw',(select ref(t) from tb_tipo t where t.codigo='02'), 'Blusa de dama estampada', 10, 40000, 60, 65);
insert into tb_producto values ('xwv-03','xwv',(select ref(t) from tb_tipo t where t.codigo='03'), 'Falda larga verde', 200, 15000, 50, 60);
insert into tb_producto values ('wvu-03','wvu',(select ref(t) from tb_tipo t where t.codigo='03'), 'Minifalda rosada', 0, 25000, 40, 55);
insert into tb_producto values ('vut-05','vut',(select ref(t) from tb_tipo t where t.codigo='05'), 'Camisa de rayas talla L', 10, 30000, 30, 50);
insert into tb_producto values ('uts-05','uts',(select ref(t) from tb_tipo t where t.codigo='05'), 'Blusa escotada con perlas estampadas', 60, 4000, 40, 90);
insert into tb_producto values ('tsr-06','tsr',(select ref(t) from tb_tipo t where t.codigo='06'), 'Sandalias de playa', 100, 120000, 50, 90);
insert into tb_producto values ('srq-06','srq',(select ref(t) from tb_tipo t where t.codigo='06'), 'Medias color blanco', 10, 40000, 60, 65);
insert into tb_producto values ('rqp-08','rqp',(select ref(t) from tb_tipo t where t.codigo='08'), 'Blue-jean desteñido', 200, 15000, 50, 60);
insert into tb_producto values ('qpo-08','qpo',(select ref(t) from tb_tipo t where t.codigo='08'), 'Tennis azules fosforecentes', 0, 25000, 40, 55);
insert into tb_producto values ('pon-01','pon',(select ref(t) from tb_tipo t where t.codigo='01'), 'Camiseta masculina color azul talla XL', 10, 30000, 30, 50);
insert into tb_producto values ('onm-01','onm',(select ref(t) from tb_tipo t where t.codigo='01'), 'Jean para dama color rojo talla M', 60, 4000, 40, 90);
insert into tb_producto values ('nml-02','nml',(select ref(t) from tb_tipo t where t.codigo='02'), 'Correas militares con chapa de plata', 100, 120000, 50, 90);
insert into tb_producto values ('mlk-02','mlk',(select ref(t) from tb_tipo t where t.codigo='02'), 'Blusa de dama estampada', 10, 40000, 60, 65);
insert into tb_producto values ('lkj-03','lkj',(select ref(t) from tb_tipo t where t.codigo='03'), 'Falda larga verde', 200, 15000, 50, 60);
insert into tb_producto values ('kji-03','kji',(select ref(t) from tb_tipo t where t.codigo='03'), 'Minifalda rosada', 0, 25000, 40, 55);
insert into tb_producto values ('jih-05','jih',(select ref(t) from tb_tipo t where t.codigo='05'), 'Camisa de rayas talla L', 10, 30000, 30, 50);
insert into tb_producto values ('ihg-05','ihg',(select ref(t) from tb_tipo t where t.codigo='05'), 'Blusa escotada con perlas estampadas', 60, 4000, 40, 90);
insert into tb_producto values ('hgf-06','hgf',(select ref(t) from tb_tipo t where t.codigo='06'), 'Sandalias de playa', 100, 120000, 50, 90);
insert into tb_producto values ('gfe-06','gfe',(select ref(t) from tb_tipo t where t.codigo='06'), 'Medias color blanco', 10, 40000, 60, 65);
insert into tb_producto values ('fed-08','fed',(select ref(t) from tb_tipo t where t.codigo='08'), 'Blue-jean desteñido', 200, 15000, 50, 60);
insert into tb_producto values ('edc-08','edc',(select ref(t) from tb_tipo t where t.codigo='08'), 'Tennis azules fosforecentes', 0, 25000, 40, 55);


create or replace type ty_pedido as object(
  codigo varchar2(30),
  fecha_pedido date,
  fecha_entrega date,
  cantidad number,
  referencia ref ty_producto,
  estado varchar2(30)
);
/

create table tb_pedido of ty_pedido;
alter table tb_pedido add constraint tb_pedido_pk primary key (codigo);


create or replace type ty_entrega as object(
  codigo varchar2(30),
  pedido ref ty_pedido,
  fecha date,
  cantidad number
);
/

create table tb_entrega of ty_entrega;
alter table tb_entrega add constraint tb_entrega_pk primary key (codigo);
/


create or replace type ty_factura as object(
  codigo varchar2(30),
  fecha date,
  base number,
  iva number,
  total number,
  pedido ref ty_pedido
);
/

create table tb_factura of ty_factura;
alter table tb_factura add constraint tb_factura_pk primary key (codigo);
/

insert into tb_pedido (codigo,referencia) values ('PC-001',(select ref(p) from tb_producto p where identificador='bcd'));
/