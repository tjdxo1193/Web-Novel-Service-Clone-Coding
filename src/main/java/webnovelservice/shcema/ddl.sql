CREATE TABLE USER (
                      USER_ID	BIGINT NOT NULL AUTO_INCREMENT primary key COMMENT '유저 아이디',
                      EMAIL	varchar(50)	NULL   COMMENT '이메일',
                      PASSWORD	varchar(100)	NOT NULL  COMMENT '비밀번호',
                      USER_NAME	varchar(40)	NULL  COMMENT '이름',
                      BIRTHDAY	DATE	NULL  COMMENT '생일',
                      CREATED_AT	datetime default (now()) COMMENT '유저 생성일'
);

CREATE TABLE LOGIN_HISTORY (
                               ACCESS_IDX	BIGINT NOT NULL AUTO_INCREMENT primary key COMMENT '접속 인덱스',
                               ACCESS_DIV	VARCHAR(10)	NOT NULL COMMENT '접속 구분',
                               ACCESS_USER_ID	BIGINT	NOT NULL COMMENT '접속 유저 아이디',
                               ACCESS_AT	datetime default (now()) COMMENT '접속 일시'
);

CREATE TABLE NOVEL (
                       NOVEL_ID BIGINT AUTO_INCREMENT primary key NOT NULL COMMENT '소설 아이디',
                       TITLE	VARCHAR(100) NOT NULL COMMENT '제목',
                       GENRE	VARCHAR(50)	NOT NULL COMMENT '장르',
                       AUTHOR VARCHAR(40) NOT NULL COMMENT '작가',
                       DESCRIPTION	VARCHAR(500) NULL COMMENT '설명_줄거리',
                       PUBLICATION_DATE	DATE NULL COMMENT '연재일자',
                       PUBLICATION_STATUS VARCHAR(10) NULL COMMENT '연재 상태',
                       CREATED_AT	datetime default (now()) COMMENT '소설 생성일'
);

CREATE TABLE FAVORITE (
                          NOVEL_ID BIGINT	NOT NULL COMMENT '소설 아이디',
                          USER_ID	BIGINT	NOT NULL COMMENT '유저 아이디',
                          THUMB_YN CHAR	NOT NULL	DEFAULT 'Y' COMMENT '좋아요 여부',
                          THUMB_DATE	datetime default (now()) COMMENT '좋아요 일시'
);

ALTER TABLE FAVORITE ADD CONSTRAINT FK_NOVEL_TO_FAVORITE_1
    FOREIGN KEY (NOVEL_ID)
        REFERENCES NOVEL (NOVEL_ID);

ALTER TABLE FAVORITE ADD CONSTRAINT FK_USER_TO_FAVORITE_1
    FOREIGN KEY (USER_ID)
        REFERENCES USER (USER_ID);

ALTER TABLE FAVORITE ADD CONSTRAINT PK_FAVORITE
    PRIMARY KEY (NOVEL_ID, USER_ID );

CREATE TABLE VIEWS (
                            USER_ID		BIGINT	NOT NULL COMMENT '유저 아이디',
                            NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                            VIEW_COUNT	    BIGINT NULL DEFAULT 1  COMMENT '유저별 조회 수',
                            VIEW_DATE	datetime default (now()) COMMENT '조회 일시'
);

ALTER TABLE VIEWS ADD CONSTRAINT FK_USER_TO_VIEWS_1
    FOREIGN KEY (USER_ID)
        REFERENCES USER (USER_ID);

ALTER TABLE VIEWS ADD CONSTRAINT FK_NOVEL_TO_VIEWS_1
    FOREIGN KEY (NOVEL_ID)
        REFERENCES NOVEL (NOVEL_ID);

ALTER TABLE VIEWS ADD CONSTRAINT PK_VIEWS
    PRIMARY KEY (USER_ID,NOVEL_ID);

CREATE TABLE THEME_KEYWORDS (
                                KEYWORD_IDX	BIGINT	NOT NULL  COMMENT '키워드 인덱스',
                                KEYWORD	VARCHAR(100)	NULL  COMMENT '키워드'
);

CREATE TABLE MAPPING_KEYWORD (
                                 NOVEL_ID	BIGINT	NOT NULL  COMMENT '소설 아이디',
                                 KEYWORD_IDX	BIGINT	NOT NULL  COMMENT '키워드 인덱스'
);

CREATE TABLE NOVEL_EPISODE (
                               EPISODE_ID	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '에피소드 아이디',
                               NOVEL_ID	BIGINT	NOT NULL  COMMENT '소설 아이디',
                               TITLE	VARCHAR(100) NULL  COMMENT '에피소드 제목',
                               EPISODE_NUM	INTEGER	NULL  COMMENT '에피소드 회차 번호'
);

CREATE TABLE POINT (
                       POINT_IDX INT NOT NULL AUTO_INCREMENT primary key COMMENT '포인트 인덱스',
                       PRICE	BIGINT	NOT NULL COMMENT '가격',
                       POINT	BIGINT	NOT NULL COMMENT '포인트'
);

CREATE TABLE NOVEL_PRICE (
                             EPISODE_ID	BIGINT PRIMARY KEY NOT NULL COMMENT '에피소드 아이디',
                             NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                             PRICE	BIGINT	NULL COMMENT '가격'
);

CREATE TABLE NOVEL_INFO (
                            NOVEL_ID	BIGINT NOT NULL COMMENT '소설 아이디',
                            NOVEL_COVER_IMAGE	BLOB NULL COMMENT '소설 표지 이미지'
);

CREATE TABLE EPISODE_INFO (
                              EPISODE_ID BIGINT	NOT NULL PRIMARY KEY COMMENT '에피소드 아이디',
                              NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                              EPISODE_IMAGE BLOB NULL COMMENT '에피소드별 대표 이미지'
);

CREATE TABLE BOOK_MARK (
                           NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                           USER_ID	BIGINT	NOT NULL	COMMENT '유저 아이디',
                           LAST_READ_PAGE	INTEGER	NULL COMMENT '마지막 읽은 페이지',
                           COMPLETE_STATUS	VARCHAR(10)	NULL COMMENT '완독 상태'
);


ALTER TABLE THEME_KEYWORDS ADD CONSTRAINT PK_THEME_KEYWORDS PRIMARY KEY (
                                                                         KEYWORD_IDX
    );

ALTER TABLE MAPPING_KEYWORD ADD CONSTRAINT PK_MAPPING_KEYWORD PRIMARY KEY (
                                                                           NOVEL_ID,
                                                                           KEYWORD_IDX
    );

ALTER TABLE NOVEL_INFO ADD CONSTRAINT PK_NOVEL_INFO PRIMARY KEY (
                                                                 NOVEL_ID
    );

ALTER TABLE BOOK_MARK ADD CONSTRAINT PK_BOOK_MARK PRIMARY KEY (
                                                               NOVEL_ID,
                                                               USER_ID
    );

ALTER TABLE NOVEL_EPISODE ADD CONSTRAINT FK_NOVEL_TO_NOVEL_EPISODE_1 FOREIGN KEY (
                                                                                  NOVEL_ID
    )
    REFERENCES NOVEL (
                      NOVEL_ID
        );

ALTER TABLE NOVEL_PRICE ADD CONSTRAINT FK_NOVEL_EPISODE_TO_NOVEL_PRICE_1 FOREIGN KEY (
                                                                                      EPISODE_ID
    )
    REFERENCES NOVEL_EPISODE (
                              EPISODE_ID
        );

ALTER TABLE NOVEL_PRICE ADD CONSTRAINT FK_NOVEL_EPISODE_TO_NOVEL_PRICE_2 FOREIGN KEY (
                                                                                      NOVEL_ID
    )
    REFERENCES NOVEL_EPISODE (
                              NOVEL_ID
        );

ALTER TABLE NOVEL_INFO ADD CONSTRAINT FK_NOVEL_TO_NOVEL_INFO_1 FOREIGN KEY (
                                                                            NOVEL_ID
    )
    REFERENCES NOVEL (
                      NOVEL_ID
        );

ALTER TABLE EPISODE_INFO ADD CONSTRAINT FK_NOVEL_EPISODE_TO_EPISODE_INFO_1 FOREIGN KEY (
                                                                                        EPISODE_ID
    )
    REFERENCES NOVEL_EPISODE (
                              EPISODE_ID
        );

ALTER TABLE EPISODE_INFO ADD CONSTRAINT FK_NOVEL_EPISODE_TO_EPISODE_INFO_2 FOREIGN KEY (
                                                                                        NOVEL_ID
    )
    REFERENCES NOVEL_EPISODE (
                              NOVEL_ID
        );

ALTER TABLE BOOK_MARK ADD CONSTRAINT FK_NOVEL_TO_BOOK_MARK_1 FOREIGN KEY (
                                                                          NOVEL_ID
    )
    REFERENCES NOVEL (
                      NOVEL_ID
        );

ALTER TABLE BOOK_MARK ADD CONSTRAINT FK_USER_TO_BOOK_MARK_1 FOREIGN KEY (
                                                                         USER_ID
    )
    REFERENCES USER (
                     USER_ID
        );


CREATE TABLE USER_DEVICE
(
    USER_ID       BIGINT      NOT NULL COMMENT '유저 아이디',
    DEVICE_SEQ    INTEGER     NOT NULL COMMENT '기기 번호',
    DEVICE_NAME   VARCHAR(40) NOT NULL COMMENT '기기 명',
    DEVICE_DIV    VARCHAR(10) NULL COMMENT '기기 유형',
    DEVICE_REG_AT datetime default (now()) COMMENT '기기 등록 일시'
);

ALTER TABLE USER_DEVICE ADD CONSTRAINT FK_USER_TO_USER_DEVICE_1 FOREIGN KEY (
                                                                             USER_ID
    )
    REFERENCES USER (
                     USER_ID
        );
ALTER TABLE USER_DEVICE ADD CONSTRAINT PK_USER_DEVICE PRIMARY KEY (
                                                                   USER_ID,
                                                                   DEVICE_SEQ
    );

CREATE TABLE USER_READ_SETTING
(
    USER_ID BIGINT NOT NULL COMMENT '유저 아이디',
    DEVICE_SEQ INTEGER NOT NULL COMMENT '기기 번호',
    FONT_SIZE INTEGER DEFAULT 11 COMMENT '폰트사이즈'
);
ALTER TABLE USER_READ_SETTING ADD CONSTRAINT FK_USER_TO_USER_READ_SETTING_1 FOREIGN KEY (
                                                                                         USER_ID, DEVICE_SEQ
    )
    REFERENCES USER_DEVICE (
                            USER_ID, DEVICE_SEQ
        );

ALTER TABLE USER_READ_SETTING ADD CONSTRAINT PK_USER_DEVICE PRIMARY KEY (
                                                                         USER_ID,
                                                                         DEVICE_SEQ
    );


CREATE TABLE LAST_READ
(
    LAST_READ_ID BIGINT AUTO_INCREMENT COMMENT '최근읽은페이지 아이디' primary key ,
    USER_ID BIGINT NOT NULL COMMENT '유저 아이디',
    NOVEL_ID BIGINT NOT NULL COMMENT '소설 아이디',
    EPISODE_ID BIGINT NOT NULL COMMENT '에피소드 아이디',
    LAST_READ_PAGE INTEGER DEFAULT 0 COMMENT '최근읽은페이지 수',
    UPDATED_AT datetime default (now()) COMMENT '수정 일시',
    CREATED_AT datetime default (now()) COMMENT '생성 일시'
);
ALTER TABLE LAST_READ ADD CONSTRAINT FK_USER_TO_LAST_READ_1 FOREIGN KEY (
                                                                         USER_ID
    )
    REFERENCES USER (
                     USER_ID
        );
ALTER TABLE LAST_READ
    ADD CONSTRAINT FK_NOVEL_EPISODE_TO_LAST_READ_1 FOREIGN KEY (
                                                                EPISODE_ID
        )
        REFERENCES NOVEL_EPISODE (
                                  EPISODE_ID
            );
ALTER TABLE LAST_READ
    ADD CONSTRAINT FK_NOVEL_TO_LAST_READ_1 FOREIGN KEY (
                                                        NOVEL_ID
        )
        REFERENCES NOVEL (
                          NOVEL_ID
            );
alter table novel_episode
    add CONTENT TEXT null comment '페이지 내용';

CREATE TABLE OWNED_NOVEL
(
    OWNED_IDX BIGINT AUTO_INCREMENT COMMENT '최근읽은페이지 아이디' primary key ,
    USER_ID BIGINT NOT NULL COMMENT '유저 아이디',
    NOVEL_ID BIGINT NOT NULL COMMENT '소설 아이디',
    EPISODE_ID BIGINT NOT NULL COMMENT '에피소드 아이디',
    OWNED_DATE datetime default (now()) COMMENT '소설 소장일'
);

ALTER TABLE OWNED_NOVEL
    ADD CONSTRAINT FK_NOVEL_EPISODE_TO_OWNED_NOVEL_1 FOREIGN KEY (
                                                                NOVEL_ID, EPISODE_ID
        )
        REFERENCES NOVEL_EPISODE (
                                  NOVEL_ID, EPISODE_ID
);

ALTER TABLE OWNED_NOVEL
    ADD CONSTRAINT FK_USER_TO_OWNED_NOVEL_1 FOREIGN KEY (
                                                                  USER_ID
        )
        REFERENCES USER (
                                  USER_ID
            );