-- Creación de la tabla Arancel
CREATE TABLE Arancel (
    id_arancel serial PRIMARY KEY,
    monto_arancel int,
    fecha_pago_a date,
    nro_cuotas int,
    tipo_pago varchar(20),
    nro_cuotas_pagadas int,
    monto_total_pagado int,
    fecha_ultimo_pago date,
    saldo_por_pagar int,
    nro_cuotas_atrasadas int
);

-- Creación de la tabla Matricula
CREATE TABLE Matricula (
    id_matricula serial PRIMARY KEY,
    fecha_matricula date,
    monto_matricula int,
    fecha_vencimiento date,
    id_arancel int REFERENCES Arancel(id_arancel)
);

-- Creación de la tabla Estudiante
CREATE TABLE Estudiante (
    rut varchar(25) PRIMARY KEY,
    nombres varchar(50),
    apellidos varchar(50),
    tipo_colegio varchar(20),
    nombre_colegio varchar(50),
    fecha_nacimiento date,
    anio_egreso int,
    nro_examenes_rendidos int,
    promedio_puntajes int,
    maximo_cuotas int,
    id_matricula int REFERENCES Matricula(id_matricula)
);

-- Creación de la tabla Descuento
CREATE TABLE Descuento (
    id_descuento serial PRIMARY KEY,
    dcto_colegio int,
    dcto_egreso int,
    dcto_promedio int,
    interes_meses_atraso int,
    rut varchar(25) REFERENCES Estudiante(rut)
);

-- Creación de la tabla Prueba
CREATE TABLE Prueba (
    id_prueba serial PRIMARY KEY,
    fecha_prueba date,
    puntaje int
);

-- Creación de la tabla Estudiante_Prueba
CREATE TABLE Estudiante_Prueba (
    rut varchar(25) REFERENCES Estudiante(rut),
    id_prueba int REFERENCES Prueba(id_prueba)
);

-- Creación de la tabla Cuota
CREATE TABLE Cuota (
    id_cuota serial PRIMARY KEY,
    fecha_vencimiento_c date,
    nro_cuota int,
    monto_cuota int,
    interes_cuota int,
    estado_cuota boolean,
    fecha_pago_cuota date,
    id_arancel int REFERENCES Arancel(id_arancel)
);