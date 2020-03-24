# Api Vencedores Framboesa de Ouro

O Objetivo desta APi é manter os filmes indicados e vencedores da categoria de pior filme do prêmio Framboesa de ouro.

Após clonar o repositório, basta colocar o novo arquivo csv com os dados presetados  no seguinte contexto:

```
{root}/src/main/resources/movielist.csv
```

Lembrando que o mesmo deve seguir o seguinte padrão, contando com o cabeçalho:

| year | title | studios | producers | winner |
| ---- | ----- | ------- | --------- | ------ |
|      |       |         |           |        |

## Endpoints

A API dispões dos seguintes endpoints:

### Novo Filme
HTTP: POST

URL:http://{baseurl}/movies

Parâmetro: Enviar JSON no seguinte padrão:
```
{
 "year": 193,
 "title": "Movie Title",
 "studios": ["Studio1","Studio2"],
 "producers": ["Producer1", "Producer2"],
 "winner": true
}
```

retorno: Registro criado
```
{
  "id": 199,
  "year": 193,
  "winner": true,
  "title": "Movie Title",
  "studios": [
    {
      "id": 56,
      "name": "Studio1"
    },
    {
      "id": 57,
      "name": "Studio2"
    }
  ],
  "producers": [
    {
      "id": 275,
      "name": "Producer1"
    },
    {
      "id": 276,
      "name": "Producer2"
    }
  ]
}
```
### Excluir Filme
HTTP: DELETE

URL:http://{baseurl}/movies/{ID}

Parâmetro: Enviar na URL o id do filme.

retorno: Registro excluído
```
{
  "id": 199,
  "year": 193,
  "winner": true,
  "title": "Movie Title",
  "studios": [
    {
      "id": 56,
      "name": "Studio1"
    },
    {
      "id": 57,
      "name": "Studio2"
    }
  ],
  "producers": [
    {
      "id": 275,
      "name": "Producer1"
    },
    {
      "id": 276,
      "name": "Producer2"
    }
  ]
}
```

### Consulta de intervalo de prêmios
HTTP: GET

URL:http://{baseurl}/range_prize

Parâmetro: -

retorno: 
```
{
  "min": [
    {
      "producer": "Bo Derek",
      "interval": 6,
      "previousWin": 1984,
      "followingWin": 1990
    }
  ],
  "max": [
    {
      "producer": "Matthew Vaughn",
      "interval": 13,
      "previousWin": 2002,
      "followingWin": 2015
    }
  ]
}
```
#### Para auxiliar nos testes, existe na raiz projeto um workspace para o postman.

```RaspberyyAward.postman_collection.json```

