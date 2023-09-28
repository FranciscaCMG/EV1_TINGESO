
INSERT INTO Estudiante (rut, nombres, apellidos, tipo_colegio, nombre_colegio, fecha_nacimiento, anio_egreso, nro_examenes_rendidos, promedio_puntajes, maximo_cuotas, id_matricula) 
VALUES 
('20000000-1', 'Francisca Constanza', 'Marquez Gutierrez', 'Municipal', 'Liceo A', '1998-10-30', 2016, 2, 960, 10, 1),
('20000000-2', 'Nicolas Agustin', 'Diaz Gutierrez', 'Subvencionado', 'Colegio A', '2003-09-13', 2021, 2, 930, 7, 2),
('20000000-3', 'Cristobal Alonso', 'Diaz Gutierrez', 'Privado', 'Colegio Z', '2000-12-11', 2018, 0, 0, 4, 3),
('20000000-4', 'Carla Viviana', 'Polanco Rodriguez', 'Municipal', 'Liceo B', '2001-01-01', 2019, 1, 800, 10, 4),
('20000000-5', 'Joaquin Ignacio', 'Diaz Gutierrez', 'Subvencionado', 'Colegio B', '2002-02-02', 2020, 2, 900, 7, 5),
('20000000-6', 'Benjamin', 'Diaz Gutierrez', 'Privado', 'Colegio Y', '2003-03-03', 2021, 1, 950, 3, 6),
('20000000-7', 'Agustin', 'Diaz Gutierrez', 'Municipal', 'Liceo C', '2004-04-04', 2022, 1, 1000, 10, 7),
('20000000-8', 'Maximiliano', 'Diaz Gutierrez', 'Subvencionado', 'Colegio C', '2005-05-05', 2020, 0, 0, 7, 8),
('20000000-9', 'Sofia', 'Diaz Gutierrez', 'Privado', 'Colegio X', '2006-06-06', 2012, 1, 750, 4, 9);


-- Creación de la tabla Descuento
CREATE TABLE Descuento (
    id_descuento serial PRIMARY KEY,
    dcto_colegio int,
    dcto_egreso int,
    dcto_promedio int,
    interes_meses_atraso int,
    rut varchar(25) REFERENCES Estudiante(rut)
);

INSERT INTO Descuento (id_descuento, dcto_colegio, dcto_egreso, dcto_promedio, interes_meses_atraso, rut)
VALUES 
(1, 20, 0, 10, -, '20000000-1'), -- interes_mes de atraso 
(2, 10, 8, 5, -, '20000000-2'),
(3, 0, 0, 0, -, '20000000-3'),
(4, 20, 4, 0, -, '20000000-4'),
(5, 10, 4, 5, -, '20000000-5'),
(6, 0, 8, 10, -, '20000000-6'),
(7, 20, 8, 10, -, '20000000-7'),
(8, 10, 4, 0, -, '20000000-8'),
(9, 0, 0, 0, -, '20000000-9');


INSERT INTO Estudiante_Prueba (rut, id_prueba)
VALUES 
('20000000-1', 1),
('20000000-1', 2),
('20000000-2', 3),
('20000000-2', 4),
('20000000-3', 5),
('20000000-3', 6),
('20000000-4', 7),
('20000000-4', 8),
('20000000-5', 9);

-- Creación de la tabla Prueba
CREATE TABLE Prueba (
    id_prueba serial PRIMARY KEY,
    fecha_prueba date,
    puntaje int
);

INSERT INTO Prueba (id_prueba, fecha_prueba, puntaje)
VALUES 
(1, '2016-10-30', 960),
(2, '2016-11-30', 960),
(3, '2021-09-13', 930),
(4, '2021-10-13', 930),
(5, '2018-12-11', 500),
(6, '2018-12-11', 500),
(7, '2019-01-01', 800),
(8, '2019-01-01', 800),
(9, '2020-02-02', 900);


