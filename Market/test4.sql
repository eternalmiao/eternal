---------------------------------------------------
-- Export file for user SCOTT@ORCL               --
-- Created by Administrator on 2016/8/1, 1:37:02 --
---------------------------------------------------

set define off
spool test4.log

prompt
prompt Creating table BRAND
prompt ====================
prompt
create table BRAND
(
  bid   NUMBER not null,
  bname VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BRAND
  add constraint PK_BID primary key (BID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GTYPE
prompt ====================
prompt
create table GTYPE
(
  tid   NUMBER not null,
  tname VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table GTYPE
  add constraint PK_TID primary key (TID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOODS
prompt ====================
prompt
create table GOODS
(
  gid         NUMBER not null,
  gname       VARCHAR2(50) not null,
  new_price   NUMBER(6,2) not null,
  old_price   NUMBER(6,2) not null,
  description VARCHAR2(500) not null,
  imgurl      VARCHAR2(50) not null,
  gtypeid     NUMBER not null,
  gcategories NUMBER not null,
  brandid     NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table GOODS
  add constraint PK_GID primary key (GID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table GOODS
  add constraint FK_BRANDID foreign key (BRANDID)
  references BRAND (BID);
alter table GOODS
  add constraint FK_GTYPEID foreign key (GTYPEID)
  references GTYPE (TID);

prompt
prompt Creating table INVENTORY
prompt ========================
prompt
create table INVENTORY
(
  iid   NUMBER not null,
  gid   NUMBER not null,
  gsize VARCHAR2(4) not null,
  gnum  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table INVENTORY
  add constraint PK_IID primary key (IID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table INVENTORY
  add constraint FK_GID_INVENTORY foreign key (GID)
  references GOODS (GID);

prompt
prompt Creating table SHOPUSER
prompt =======================
prompt
create table SHOPUSER
(
  u_id     NUMBER not null,
  uname    VARCHAR2(20) not null,
  phone    NUMBER not null,
  email    VARCHAR2(20) not null,
  password VARCHAR2(20) not null,
  address  VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SHOPUSER
  add constraint PK_UID primary key (U_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SHOPUSER
  add constraint UN_UNAME unique (UNAME)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CART
prompt ===================
prompt
create table CART
(
  caid  NUMBER not null,
  canum NUMBER not null,
  iid   NUMBER not null,
  suid  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CART
  add constraint PK_CAID primary key (CAID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CART
  add constraint FK_IID_CART foreign key (IID)
  references INVENTORY (IID);
alter table CART
  add constraint FK_SUID foreign key (SUID)
  references SHOPUSER (U_ID);

prompt
prompt Creating table GORDER
prompt =====================
prompt
create table GORDER
(
  oid      NUMBER not null,
  u_id     NUMBER not null,
  iid      NUMBER not null,
  ostatus  NUMBER not null,
  price    NUMBER(5,2) not null,
  otime    DATE not null,
  oaddress VARCHAR2(50) not null,
  receiver VARCHAR2(20) not null,
  rephone  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table GORDER
  add constraint PK_OID primary key (OID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table GORDER
  add constraint FK_IID_ORDER foreign key (IID)
  references INVENTORY (IID);
alter table GORDER
  add constraint FK_UID_ORDER foreign key (U_ID)
  references SHOPUSER (U_ID);

prompt
prompt Creating table COMMAND
prompt ======================
prompt
create table COMMAND
(
  cid     NUMBER not null,
  oid     NUMBER not null,
  u_id    NUMBER not null,
  content VARCHAR2(50) not null,
  ctime   DATE not null,
  cscore  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table COMMAND
  add constraint PK_CID primary key (CID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table COMMAND
  add constraint FK_IID foreign key (OID)
  references GORDER (OID);
alter table COMMAND
  add constraint FK_UID foreign key (U_ID)
  references SHOPUSER (U_ID);

prompt
prompt Creating table MANAGER
prompt ======================
prompt
create table MANAGER
(
  mid      NUMBER not null,
  mname    VARCHAR2(20) not null,
  password VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table MANAGER
  add constraint PK_MID primary key (MID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TREND
prompt ====================
prompt
create table TREND
(
  trid NUMBER not null,
  gid  NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TREND
  add constraint PK_TRID primary key (TRID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TREND
  add constraint UNIQUA_GID unique (GID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TREND
  add constraint FK_GID_TREND foreign key (GID)
  references GOODS (GID);

prompt
prompt Creating table WISHLIST
prompt =======================
prompt
create table WISHLIST
(
  wid  NUMBER not null,
  gid  NUMBER not null,
  u_id NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table WISHLIST
  add constraint PK_WID primary key (WID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table WISHLIST
  add constraint FK_UID_WISHLIST foreign key (U_ID)
  references SHOPUSER (U_ID);
alter table WISHLIST
  add constraint GID foreign key (GID)
  references GOODS (GID);

prompt
prompt Creating sequence SEQ_BRAND
prompt ===========================
prompt
create sequence SEQ_BRAND
minvalue 1
maxvalue 9999999999999999999999999999
start with 23
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_CART
prompt ==========================
prompt
create sequence SEQ_CART
minvalue 1
maxvalue 9999999999999999999999999999
start with 51
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_COMM
prompt ==========================
prompt
create sequence SEQ_COMM
minvalue 1
maxvalue 9999999999999999999999999999
start with 29
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GOODS
prompt ===========================
prompt
create sequence SEQ_GOODS
minvalue 1
maxvalue 9999999999999999999999999999
start with 35
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GORDER
prompt ============================
prompt
create sequence SEQ_GORDER
minvalue 1
maxvalue 9999999999999999999999999999
start with 64
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GTYPE
prompt ===========================
prompt
create sequence SEQ_GTYPE
minvalue 1
maxvalue 9999999999999999999999999999
start with 23
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_INV
prompt =========================
prompt
create sequence SEQ_INV
minvalue 1
maxvalue 9999999999999999999999999999
start with 89
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_MGR
prompt =========================
prompt
create sequence SEQ_MGR
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TREND
prompt ===========================
prompt
create sequence SEQ_TREND
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_USER
prompt ==========================
prompt
create sequence SEQ_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 23
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_WIS
prompt =========================
prompt
create sequence SEQ_WIS
minvalue 1
maxvalue 9999999999999999999999999999
start with 51
increment by 1
cache 20;

prompt
prompt Creating trigger TRIG_BRAND
prompt ===========================
prompt
create or replace trigger trig_brand
  before insert
  on brand 
  for each row
declare
  -- local variables here
begin
  select seq_brand.nextval into :new.bid from dual;
end trig_brand;
/

prompt
prompt Creating trigger TRIG_CART
prompt ==========================
prompt
create or replace trigger trig_cart
  before insert
  on cart 
  for each row
declare
  -- local variables here
begin
    select seq_cart.nextval into :new.caid from dual;
end trig_cart;
/

prompt
prompt Creating trigger TRIG_COMM
prompt ==========================
prompt
create or replace trigger trig_comm
  before insert
  on command 
  for each row
declare
  -- local variables here
begin
    select seq_comm.nextval into :new.cid from dual;
end trig_comm;
/

prompt
prompt Creating trigger TRIG_GOODS
prompt ===========================
prompt
create or replace trigger trig_goods
  before insert
  on goods 
  for each row
declare
  -- local variables here
begin
    select seq_goods.nextval into :new.gid from dual;
end trig_goods;
/

prompt
prompt Creating trigger TRIG_GTYPE
prompt ===========================
prompt
create or replace trigger trig_gtype
  before insert
  on gtype 
  for each row
declare
  -- local variables here
begin
    select seq_gtype.nextval into :new.tid from dual;
end trig_gtype;
/

prompt
prompt Creating trigger TRIG_INV
prompt =========================
prompt
create or replace trigger trig_inv
  before insert
  on inventory 
  for each row
declare
  -- local variables here
begin
    select seq_inv.nextval into :new.iid from dual;
end trig_inv;
/

prompt
prompt Creating trigger TRIG_MGR
prompt =========================
prompt
create or replace trigger trig_mgr
  before insert
  on manager 
  for each row
declare
  -- local variables here
begin
    select seq_mgr.nextval into :new.mid from dual;
end trig_mgr;
/

prompt
prompt Creating trigger TRIG_ORDER
prompt ===========================
prompt
create or replace trigger trig_order
  before insert
  on gorder 
  for each row
declare
  -- local variables here
begin
  select seq_gorder.nextval into :new.oid from dual;
end trig_order;
/

prompt
prompt Creating trigger TRIG_TREND
prompt ===========================
prompt
create or replace trigger trig_trend
  before insert
  on trend 
  for each row
declare
  -- local variables here
begin
  select seq_trend.nextval into :new.trid from dual;
end trig_trend;
/

prompt
prompt Creating trigger TRIG_USER
prompt ==========================
prompt
create or replace trigger trig_user
  before insert
  on shopuser 
  for each row
declare
  -- local variables here
begin
    select seq_user.nextval into :new.u_id from dual;
end trig_user;
/

prompt
prompt Creating trigger TRIG_WIS
prompt =========================
prompt
create or replace trigger trig_wis
  before insert
  on wishlist 
  for each row
declare
  -- local variables here
begin
  select seq_wis.nextval into :new.wid from dual;
end trig_wis;
/


spool off
