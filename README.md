## doccy

POC para leitura de imagens com OCR e busca em por TAGS

## swagger

http://localhost:8080/swagger-ui.html

## api

url http://localhost:8080/identificadorDocumento

method	POST

Content-Type application/json

payload

{"comprovanteDocumento":{"tipoImagemComprovante":"RG","imagem":"SU1BR0VNIEFRVUk="}}

-------------------------------------------------------------------------------------

url http://localhost:8080/obterUUID/{tipoDocumento}/{valor}

method	GET

Content-Type application/json