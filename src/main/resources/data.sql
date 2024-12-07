CREATE TABLE IF NOT EXISTS masini (
                                      nr_inmatriculare VARCHAR(10) NOT NULL PRIMARY KEY,
                                      marca VARCHAR(40) NOT NULL,
                                      an_fabricatie INT NOT NULL,
                                      culoare VARCHAR(10),
                                      nr_kilometrii INT NOT NULL);
insert into masini values (2018,180000,'negru','Mercedes','TM10ABC');
insert into masini values (2010,250000,'alb','Dacia','TM11DEF');
insert into masini values (2022,90000,'gri','Audi','TM12GHI');
insert into masini values (2012,200000,'rosu','BMW','TM13JKL');
insert into masini values (2023,50000,'negru','Dacia','TM14MNO');