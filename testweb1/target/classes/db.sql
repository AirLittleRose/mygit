create database favorite;

use favorite;

create table users(
	uid int primary key auto_increment,
	uname varchar(100),
	upass varchar(100)
);

insert into users(uname,upass) values('a','a');

select * from users where uname='a' and upass='a';

create table tag(
	tid int primary key auto_increment,
	tname varchar(100),
	tcount int
);

create table favorite(
	fid int primary key auto_increment,
	flable varchar(500),
	furl varchar(500),
	fdesc varchar(500),
	ftags varchar(500)
);

create table tagfavorite(
	tid int,
	fid int,
	primary key(tid,fid)
);

select * from tag;
select * from favorite;
select * from tagfavorite;

alter table tagfavorite 
	add constraint fk_tagfavorite_tid 
		foreign key(tid) references tag(tid);
		
alter table tagfavorite 
	add constraint fk_tagfavorite_fid 
		foreign key(fid) references favorite(fid);
		
insert into teacher(tname) values('ayay');
insert into teacher(tname) values('jony');

insert into classes(cname,tid) values('class_1',1);
insert into classes(cname,tid) values('class_2',1);
insert into classes(cname,tid) values('class_3',2);

insert into student(sname,cid) values('a1',1);
insert into student(sname,cid) values('a2',1);
insert into student(sname,cid) values('a3',1);

insert into student(sname,cid) values('b1',2);
insert into student(sname,cid) values('b2',2);
insert into student(sname,cid) values('b3',2);

insert into student(sname,cid) values('c1',3);
insert into student(sname,cid) values('c2',3);
insert into student(sname,cid) values('c3',3);

select cid,cname,classes.tid as tid,tname
		from classes
		left join teacher
		on classes.tid=teacher.tid
		where cname='class_3';

select teacher.tid as tid,tname,cid,cname
		from teacher
		left join classes
		on teacher.tid=classes.tid
		where 1=1 and tname=?

		
select a.cid as cid,cname,a.tid as tid,tname,sid,sname 
from 
(select classes.cid as cid,cname,classes.tid as tid,sid,sname 
		from classes
		left join student
		on classes.cid=student.cid
) a
left join teacher
on a.tid=teacher.tid
where tname='ayay'
;

create table renthouse(
	id int primary key auto_increment,
	title text,
	housetype int,
	price int,
	district text
);

select * from renthouse;


insert into renthouse(title,housetype,price,district) 
	values('家庭大床房带厨卫',2,1800,'长沙');
insert into renthouse(title,housetype,price,district) 
	values('豪华双人房带厨卫一室一厅',3,2400,'长沙');
insert into renthouse(title,housetype,price,district) 
	values('普通单间',1,1000,'深圳');
insert into renthouse(title,housetype,price,district) 
	values('普通合租间带厨卫二室一厅',1,2800,'深圳');

