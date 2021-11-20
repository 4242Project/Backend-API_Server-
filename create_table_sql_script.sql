-- Table Generation -- 

CREATE TABLE `42flatform_db`.`Advertisement`
(
	ad_id                VARCHAR(5) NOT NULL,
	image                VARCHAR(300) NULL,
	hyperlink            VARCHAR(300) NULL,
	PRIMARY KEY (ad_id)
);


CREATE TABLE `42flatform_db`.`category`
(
	category_id          VARCHAR(5) NOT NULL,
	category_name        VARCHAR(20) NULL,
	PRIMARY KEY (category_id)
);



CREATE TABLE `42flatform_db`.`UnivInfo`
(
	univ_id              VARCHAR(5) NOT NULL,
	univ_name            VARCHAR(20) NULL,
	PRIMARY KEY (univ_id)
);


CREATE TABLE `42flatform_db`.`Member`
(
	id                   VARCHAR(10) NOT NULL,
	pw                   VARCHAR(20) NOT NULL,
	name                 VARCHAR(20) NOT NULL,
	email                VARCHAR(20) NOT NULL,
	nickname             VARCHAR(20) NOT NULL,
	age                  INTEGER NOT NULL,
	sai__change_         INTEGER NULL,
	profile_img_root     VARCHAR(300) NULL,
	univ_id              VARCHAR(5) NOT NULL,
	phone                VARCHAR(30) NOT NULL,
	panalty              INTEGER NULL,
	department           VARCHAR(20) NOT NULL,
	timetable            VARCHAR(300) NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (univ_id) REFERENCES UnivInfo (univ_id)
);


CREATE TABLE `42flatform_db`.`Class`
(
	class_id             VARCHAR(5) NOT NULL,
	class_name           VARCHAR(20) NULL,
	class_brief          VARCHAR(100) NULL,
	class_detail         VARCHAR(300) NULL,
	introduce_img_root   VARCHAR(300) NULL,
	class_plcae          VARCHAR(20) NULL,
	class_question       VARCHAR(100) NULL,
	class_change_cancle  VARCHAR(300) NULL,
	start_date           DATE NULL,
	end_date             DATE NULL,
	category_id          VARCHAR(5) NOT NULL,
	univ_id              VARCHAR(5) NOT NULL,
	limit_number         INTEGER NULL,
	class_location       VARCHAR(100) NULL,
	class_day            VARCHAR(3) NULL,
	class_s_time         TIME NULL,
	material             VARCHAR(100) NULL,
	clss_e_time          TIME NULL,
	host_id              VARCHAR(10) NULL,
	fee                  INTEGER NULL,
	PRIMARY KEY (class_id),
	FOREIGN KEY (category_id) REFERENCES category (category_id),
	FOREIGN KEY (univ_id) REFERENCES UnivInfo (univ_id),
	FOREIGN KEY (host_id) REFERENCES Member (id)
);


CREATE TABLE `42flatform_db`.`SignUp`
(
	class_id             VARCHAR(5) NOT NULL,
	member_id            VARCHAR(10) NOT NULL,
	sai_chk              boolean NULL,
	PRIMARY KEY (member_id,class_id),
	FOREIGN KEY (class_id) REFERENCES Class (class_id),
	FOREIGN KEY (member_id) REFERENCES Member (id)
);


CREATE TABLE `42flatform_db`.`Stamp`
(
	id                   VARCHAR(10) NOT NULL,
	category_id          VARCHAR(5) NOT NULL,
	stamp_count          INTEGER NULL,
	PRIMARY KEY (id,category_id),
	FOREIGN KEY (id) REFERENCES Member (id),
	FOREIGN KEY (category_id) REFERENCES category (category_id)
);
