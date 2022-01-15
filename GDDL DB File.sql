drop table if EXISTS notify_tb;
drop table if EXISTS chatlist_tb;
drop table if EXISTS chatting_tb;
drop table if EXISTS customercare_tb;
drop table if EXISTS orders_tb;
drop table if EXISTS user_data;

create table user_data(
    user_id varchar(20) not null,
    pass varchar(100) not null,
    name char(10) not null,
    major char(30) not null,
    school_number char(20) not null,
    gender char(10),
    primary key(user_id)
);

create table orders_tb( #게시되는 게시글
    o_number int not null auto_increment, #주문게시글 넘버
    o_time varchar(20), #주문 생성시간 H:M:S
    orders varchar(20) not null, #주문자
    errand varchar(20), #수락하는 심부름꾼
    title char(40) not null, #제목
    content varchar(100), #내용
    latitude double, #위도
    longitude double, #경도
    detail_address char(70), #세부주소
    price int, #가격
    progress varchar(20) default "@@Waiting", #진행상황
    foreign key(orders) references user_data(user_id), # 주문자 
    primary key(o_number)
    
);

create table customercare_tb ( #신고내용 테이블
    c_number int not null auto_increment, #신고 게시글 넘버
    c_title varchar(30), #주문 게시글 숫자
    check_content text, #체크박스에 체크되서 넘어온 신고내용
    content text, #신고내용
    reporter varchar(20), #신고자
    defendant varchar(20), #피고
    foreign key(reporter) references user_data(user_id), #신고자 아디이 참조
    foreign key(defendant) references user_data(user_id), #피고 아이디 참조
    primary key(c_number)
);

create table chatting_tb ( 
    increase_num int not null auto_increment,
    c_time varchar(20), #채팅시간
    sender_id varchar(20) not null, #발신자 이름
    chatting text, # 채팅내용
    alive int default 1,

    primary key(increase_num)
);


create table chatlist_tb(
   increase_num int not null auto_increment,
   order_id varchar(20) not null,
    errand_id varchar(20) not null,
    
    primary key(increase_num)
);

create table notify_tb (
   notify_num int not null auto_increment,
    notify_title varchar(20) not null,
   notify_content text not null,
    notify_time varchar(20) not null,
    
    primary key(notify_num)
);

insert into user_data values ("hi","03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4","김준혁","tec","201721151","male");
insert into user_data values ("hello","03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4","김형진","so","201721999","female");
insert into user_data values ("Gwoo","03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4","마건우","tec","201721163","male");
insert into user_data values ("Oks","03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4","옥석우","smart","201721777","female");
insert into user_data values ("MisterCha","03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4","차형석","music","201721666","male");

insert into orders_tb values (null,"20210413122730","hello","hi","물 사다주실분 구합니다!","물 한누리관 6층으로 빠르게 사다주실분 구해요",22.2,22.4,"한누리관 6층",1000,"@@Completed");
insert into orders_tb values (null,"20210416172257","Oks","MisterCha","커피 부탁합니다","한누리관 1층카페 아이스 아메리카노 따뜻하게 가져다주세요! 한누리관 4층 휴게실에있습니다",22.2,22.4,"한누리관 4층",500,"@@Completed");
insert into orders_tb values (null,"20210416210406","hi","hello","물 사다주실분 구합니다!","물 한누리관 6층으로 빠르게 사다주실분 구해요",22.2,22.4,"한누리관 6층",1000,"@@Ongoing");
-- insert into orders_tb values (null,"20210416042257","hi","hello","한누리관 7층 가방","한누리관 7층에 가방두고왔는데 가져다주실분 구합니다",22.2,22.4,"한누리관 7층",2000,"@@Ongoing");
-- insert into orders_tb values (null,"20210416042257","hi",null,"택배 가져다주실분","자취방 앞에있는 택배좀 한누리관으로 가져다주세요.",22.2,22.4,"한누리관",800,"@@Waiting");
-- insert into orders_tb values (null,"20210416210516","hi",null,"기숙사 도시락","기숙사로 한솥도시락 가져다주실분구해여 오시면 주문넣어놓겠습니다",22.2,22.4,"기숙사",1000,"@@Waiting");
-- insert into orders_tb values (null,"20210416210716","hello",null,"기숙사 본관에서 책받아와주실분","기숙사 본관에서 제친구 한테서 책 받아와 주실분 구합니다. 저는 한누리관 7층에서 기다리겠습니다~",22.2,22.4,"한누리관 7층",700,"@@Waiting");
insert into orders_tb values (null,"20210416210716","Gwoo",null,"핫식스 급구 합니당","학교 도서관에 있습니다 2시간안에만 와주시면되요",22.2,22.4,"도서관",400,"@@Waiting");
-- insert into orders_tb values (null,"20210416210716","Oks",null,"베라 아이스크림!","베라에서 아이스크림 쿠폰으로 사다주세요~~ 기숙사 구관에서 기다리겠습니다",22.2,22.4,"기숙사",1500,"@@Waiting");
insert into orders_tb values (null,"20210422042411","MisterCha",null,"우산좀요","한누리관 입구로 가져다주세요 최대한 빨리와주실수있는분",22.2,22.4,"한누리관 입구",1000,"@@Waiting");

insert into chatlist_tb values (null,"hi","hello");

insert into notify_tb values (null,"고객센터 개선","이번 업데이트로 고객센터의 신고접수가 추가되었습니다.","20210512221403");
insert into notify_tb values (null,"데이터베이스 정리완료","이번 업데이트로 데이터베이스 정리가 완료되었습니다","20210514221403");
insert into notify_tb values (null,"디자인 개선 완료","이번 업데이트로 디자인이 개선되었습니다","20210516221403");