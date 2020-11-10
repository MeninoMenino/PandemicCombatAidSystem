# PandemicCombatAidSystem

REST API desenvolvida com Spring para registrar hospitais e recursos, e operar intercâmbio de recursos entre os hospitais.

Arquivo com a query do banco de dados: database-schema/db-query.sql



--------------------------Endpoints--------------------------


# /hospital

-GET /hospital: Retorna uma lista com todos os hospitais registrados.

-GET /hospital/{hospital_id}: Retorna o hospital registrado com o id informado.

-POST /hospital: Registra um novo hospital.
                 Body: name(String), address(String), cnpj(String, localization(String), occupancyRate(float), resources{name(String), quantity(int)}
                
-PATCH /hospital/{hospital_id}: Atualiza a taxa de ocupação do hospital com o id informado.
                                Body: occupancy(float)


# /negotiation

-GET /negotiation: Retorna uma lista com todas as negociações registradas
-POST /negotiation: Registra uma nova negociação
                    Body: id_first_hospital(long), id_second_hospital(long), resources_first_hospital{name(String), quantity(int)}, resources_second_hospital{name(String), quantity(int)}


# /report

-GET /report: Retorna um relatório com:
                                       -Porcentagem de hospitais com taxa de ocupação acima de 90%
                                       -Porcentagem de hospitais com taxa de ocupação abaixo de 90%
                                       -Histórico de negociações
