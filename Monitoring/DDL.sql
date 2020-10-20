DROP SCHEMA IF EXISTS MONITORING;
CREATE SCHEMA IF NOT EXISTS MONITORING;

CREATE TABLE UNITY (
    id varchar(255),
    latitude float,
    longitude float,
    videoCamera boolean,
    thermomether boolean,
    co2 boolean,
    ch4 boolean,
    available boolean,
    unityType int,
    primary key(id)
);

select * from unity

INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("321", 9685, 8579, true, true, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("965", 215, 302, true, false, true, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("aaa", 3445, 4250, true, true, false, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("cbv", 120, 350, true, true, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("129", 851, 600, false, true, false, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("23d", 231, 540, false, true, false, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("2ds", 278, 385, true, true, true, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("5tg", 1836, 3265, false, true, false, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("3vc", 5320, 6954, true, true, false, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("gb6", 333, 250, true, false, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("tu4", 489, 748, false, true, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("lp6", 6954, 215, true, true, false, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("98f", 540, 231, false, false, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("02s", 9999, 8579, false, true, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("ddx", 6470, 3265, true, false, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("ac5", 6650, 9568, true, true, false, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("87g", 30, 20, false, false, true, true, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("vc7", 154, 995, false, true, true, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("5v2", 9521, 6598, true, false, true, false, true, 1);
INSERT INTO UNITY (id, latitude, longitude, videoCamera, thermomether, co2, ch4, available, unityType) VALUES ("a0a", 30254, 96015, true, false, false, true, true, 1);