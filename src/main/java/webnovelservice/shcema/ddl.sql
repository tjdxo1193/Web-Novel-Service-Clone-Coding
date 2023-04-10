CREATE DATABASE NOVEL_SERVICE;

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

CREATE TABLE VIEW_COUNT (
                            USER_ID		BIGINT	NOT NULL COMMENT '유저 아이디',
                            NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                            VIEWS	    BIGINT NULL DEFAULT 1  COMMENT '유저별 조회 수',
                            VIEW_DATE	datetime default (now()) COMMENT '조회 일시'
);

ALTER TABLE VIEW_COUNT ADD CONSTRAINT FK_USER_TO_VIEW_COUNT_1
    FOREIGN KEY (USER_ID)
        REFERENCES USER (USER_ID);

ALTER TABLE VIEW_COUNT ADD CONSTRAINT FK_NOVEL_TO_VIEW_COUNT_1
    FOREIGN KEY (NOVEL_ID)
        REFERENCES NOVEL (NOVEL_ID);

ALTER TABLE VIEW_COUNT ADD CONSTRAINT PK_VIEW_COUNT
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
                               EPISODE_IDX	BIGINT	NOT NULL  COMMENT '에피소드 인덱스',
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
                             EPISODE_IDX	BIGINT	NOT NULL COMMENT '에피소드 인덱스',
                             NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                             PRICE	BIGINT	NULL COMMENT '가격'
);

CREATE TABLE NOVEL_INFO (
                            NOVEL_ID	BIGINT NOT NULL COMMENT '소설 아이디',
                            NOVEL_COVER_IMAGE	BLOB NULL COMMENT '소설 표지 이미지'
);

CREATE TABLE EPISODE_INFO (
                              EPISODE_IDX	BIGINT	NOT NULL COMMENT '에피소드 인덱스',
                              NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                              EPISODE_IMAGE BLOB NULL COMMENT '에피소드별 대표 이미지'
);

CREATE TABLE NOVEL_PAGE (
                            PAGE_IDX	BIGINT	NOT NULL COMMENT '페이지 인덱스',
                            EPISODE_IDX	BIGINT	NOT NULL COMMENT '에피소드 인덱스',
                            NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
                            PAGE_NUM INTEGER	NOT NULL COMMENT '페이지 번호',
                            CONTEXT	VARCHAR(2000)	NULL
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

ALTER TABLE NOVEL_EPISODE ADD CONSTRAINT PK_NOVEL_EPISODE PRIMARY KEY (
                                                                       EPISODE_IDX,
                                                                       NOVEL_ID
    );

ALTER TABLE NOVEL_PRICE ADD CONSTRAINT PK_NOVEL_PRICE PRIMARY KEY (
                                                                   EPISODE_IDX,
                                                                   NOVEL_ID
    );

ALTER TABLE MAPPING_KEYWORD ADD CONSTRAINT PK_MAPPING_KEYWORD PRIMARY KEY (
                                                                           NOVEL_ID,
                                                                           KEYWORD_IDX
    );

ALTER TABLE NOVEL_INFO ADD CONSTRAINT PK_NOVEL_INFO PRIMARY KEY (
                                                                 NOVEL_ID
    );

ALTER TABLE EPISODE_INFO ADD CONSTRAINT PK_EPISODE_INFO PRIMARY KEY (
                                                                     EPISODE_IDX,
                                                                     NOVEL_ID
    );

ALTER TABLE NOVEL_PAGE ADD CONSTRAINT PK_NOVEL_PAGE PRIMARY KEY (
                                                                 PAGE_IDX,
                                                                 EPISODE_IDX,
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
                                                                                      EPISODE_IDX
    )
    REFERENCES NOVEL_EPISODE (
                              EPISODE_IDX
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
                                                                                        EPISODE_IDX
    )
    REFERENCES NOVEL_EPISODE (
                              EPISODE_IDX
        );

ALTER TABLE EPISODE_INFO ADD CONSTRAINT FK_NOVEL_EPISODE_TO_EPISODE_INFO_2 FOREIGN KEY (
                                                                                        NOVEL_ID
    )
    REFERENCES NOVEL_EPISODE (
                              NOVEL_ID
        );

ALTER TABLE NOVEL_PAGE ADD CONSTRAINT FK_NOVEL_TO_NOVEL_PAGE_1 FOREIGN KEY (
                                                                            NOVEL_ID
    )
    REFERENCES NOVEL (
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

CREATE TABLE OWNED_NOVEL (
        OWNED_IDX	BIGINT	NOT NULL COMMENT '소유한소설 인덱스',
        USER_ID	BIGINT	NOT NULL COMMENT '소유자(유저) 아이디',
        NOVEL_ID	BIGINT	NOT NULL COMMENT '소설 아이디',
        EPISODE_IDX	BIGINT	NOT NULL COMMENT '에피소드 인덱스',
        OWNED_DIV VARCHAR(10) NOT NULL COMMENT '소유 구분(기간제,영구)',
        OWNED_DATE DATE NOT NULL COMMENT '소유일'
);