# Instruções para Agentes de IA - SGHSS

## Visão Geral do Projeto
O SGHSS (Sistema de Gestão Hospitalar e Serviços de Saúde) é uma aplicação Spring Boot que gerencia dados hospitalares e serviços de saúde. O projeto utiliza Java 21 e segue uma arquitetura baseada em domínio.

## Tecnologias Principais
- Spring Boot 3.5.6
- Spring Data JPA para persistência
- Spring Validation para validação de dados
- Spring Web para APIs REST

## Estrutura do Projeto
- `src/main/java/com/vidaplus/sghss/` - Código fonte principal
- `src/main/resources/` - Arquivos de configuração
- `src/test/` - Testes automatizados

## Padrões e Convenções
### Modelagem de Domínio
O sistema segue uma modelagem de domínio rica, como exemplificado no diagrama de classes no `README.md`. Os principais conceitos incluem:
- Paciente com informações pessoais e histórico clínico
- Profissionais de Saúde e suas especialidades
- Endereço e Contato como value objects

### Convenções de Código
- Use classes imutáveis quando possível
- Implemente validações usando anotações do Spring Validation
- Siga os princípios RESTful para APIs

## Fluxos de Desenvolvimento
1. Build: `./mvnw clean install`
2. Executar testes: `./mvnw test`
3. Executar aplicação: `./mvnw spring-boot:run`

## Pontos de Integração
- JPA/Hibernate para persistência de dados
- APIs REST para comunicação externa
- Validação de dados através do Spring Validation

## Dicas para Desenvolvimento
- Consulte o diagrama de classes no `README.md` para entender as relações entre entidades
- Use os starters do Spring Boot para adicionar novas funcionalidades
- Mantenha a coesão do domínio seguindo os padrões estabelecidos no código existente