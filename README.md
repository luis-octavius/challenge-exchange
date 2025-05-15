# 💱 Conversor de Moedas com Java

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.oracle.com/java/)
[![API Status](https://img.shields.io/badge/API-ExchangeRate--API-green)](https://www.exchangerate-api.com)

Um conversor de moedas que utiliza a **ExchangeRate-API** para obter cotações em tempo real. Desenvolvido em Java com Gson para manipulação de JSON.  
Projeto desenvolvido para o curso 'Java e Orientação a Objetos' da Alura + ONE.

![Badge](https://i.imgur.com/1jRBR5G.png) <!-- Substitua por um screenshot real -->

## 📋 Funcionalidades
- Conversão entre 6 pares de moedas (USD, EUR, BRL)
- Histórico de conversões (em desenvolvimento)
- Interface simples via terminal

## 🚀 Como Executar

### Pré-requisitos
- Java 17+ ([JDK](https://adoptium.net/))
- Chave de API gratuita do [ExchangeRate-API](https://www.exchangerate-api.com)

### Passo a Passo
1. **Clone o repositório**:
```bash

git clone https://github.com/seu-usuario/conversor-moedas.git
```

2. Configure a chave da API:

- Crie um arquivo .env na raiz do projeto:

```env

EXCHANGE_API_KEY=sua_chave_aqui
```

3. Execute o projeto:
```bash

cd challenge-exchange
mvn clean package
java -jar target/challenge-exchange-1.0-jar-with-dependencies.jar
```

## 🛠️ Estrutura do Código

```src/
📁 challenge-exchange/  
├── 📁 src/  
│   ├── 📁 main/  
│   │   ├── 📁 java/  
│   │   │   └── 📁 com/  
│   │   │       ├── Main.java         # Classe com `main()`  
│   │   │       ├── Exchange.java     # Modelo de dados
│   │   │       ├── Menu.java         # Menu da aplicação
│   │   │       └── Request.java      # Responsável pela requisição HTTP
├── 📄 .env                           # Chave da API  
├── 📄 pom.xml                        # Maven 
└── 📄 README.md  
```

## 🌟 Melhorias Futuras
- [ ] Adicionar mais moedas (GBP, JPY)
- [ ] Implementar cache das cotações
- [ ] Criar interface gráfica (JavaFX)

##🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch (git checkout -b feature/nova-moeda)
3. Commit suas mudanças (git commit -m 'Adiciona suporte a JPY')
4. Push para a branch (git push origin feature/nova-moeda)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob a licença MIT.
