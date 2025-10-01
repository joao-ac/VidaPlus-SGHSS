Diagrama de Classes e Entidade-Relacionamento:

```mermaid
classDiagram
    %% Classe Paciente
    class Paciente {
        +String id
        +String nome
        +Date dataNascimento
        +String sexo
        +String cpf
        +Endereco endereco
        +Contato contatos
        +List<HistoricoClinico> historicoClinico
        +List<Consulta> consultas
        +List<Notificacao> notificacoes
        %% O prontuario poderia ser 1 por paciente, mas mantemos por consulta conforme seu modelo original
        %% +Prontuario prontuario 
    }

    %% Classe Endereco
    class Endereco {
        +String rua
        +String numero
        +String bairro
        +String cidade
        +String estado
        +String cep
    }

    %% Classe Contato
    class Contato {
        +String telefone
        +String email
    }

    %% Classe HistoricoClinico
    class HistoricoClinico {
        +Date data
        +String descricao
        +ProfissionalDeSaude profissional
    }

    %% Profissional de Saúde não mantém lista de pacientes (pode ser derivada via Consulta)
    class ProfissionalDeSaude {
        +String id
        +String nome
        +String especialidade
        +String registroConselho
        +Contato contatos
        +List<Agenda> agenda
    }

    class Agenda {
        +Date data
        +List<String> horariosDisponiveis
    }

    %% Administração Hospitalar
    class AdministracaoHospitalar {
        +List<Leito> leitos
        +List<RelatorioFinanceiro> relatoriosFinanceiros
        +List<Suprimento> suprimentos
    }

    class Leito {
        +String id
        +String status
        +Paciente paciente
        +Date dataInternacao
    }

    class RelatorioFinanceiro {
        +String id
        +String periodo
        +Float receitas
        +Float despesas
    }

    class Suprimento {
        +String id
        +String nome
        +int quantidade
        +String unidade
    }

    %% Consulta: relação direta com Paciente e Profissional
    class Consulta {
        +String id
        +Paciente paciente
        +ProfissionalDeSaude profissional
        +DateTime dataHora
        +String tipo
        +String status
        +Prontuario prontuario
    }

    class Prontuario {
        +String diagnostico
        +List<Prescricao> prescricao
    }

    class Prescricao {
        +String medicamento
        +String dosagem
        +int frequenciaDia
    }

    %% Teleconsulta especializa Consulta
    class Teleconsulta {
        +String videochamada
        +List<Prescricao> prescricaoOnline
    }

    %% Notificacao explícita
    class Notificacao {
        +String id
        +String mensagem
        +DateTime dataHora
        +Boolean lida
    }

    %% Segurança e Compliance
    class SegurancaECompliance {
        +List<ControleAcesso> controleAcesso
        +List<LogAuditoria> logsAuditoria
        +LGPD lgpd
    }

    class ControleAcesso {
        +String usuarioId
        +String perfil
        +List<String> permissoes
    }

    class LogAuditoria {
        +String id
        +String usuarioId
        +String acao
        +DateTime dataHora
        +String detalhes
    }

    class LGPD {
        +Boolean consentimentoDados
        +Date dataConsentimento
    }

    %% Relacionamentos principais:
    Paciente "1" o-- "1" Endereco : possui
    Paciente "1" o-- "*" Contato : possui
    Paciente "1" o-- "*" HistoricoClinico : possui
    Paciente "1" o-- "*" Consulta : realiza
    Paciente "1" o-- "*" Notificacao : recebe

    ProfissionalDeSaude "1" o-- "*" Contato : possui
    ProfissionalDeSaude "1" o-- "*" Agenda : possui

    %% Consulta-Composição com profissional/paciente/prontuario
    Consulta "*" -- "1" Paciente : refere-se
    Consulta "*" -- "1" ProfissionalDeSaude : realizada_por
    Consulta "1" *-- "1" Prontuario : gera

    Prontuario "1" *-- "*" Prescricao : receita

    Teleconsulta "*" --|> Consulta : é uma

    AdministracaoHospitalar "1" o-- "*" Leito : gerencia
    AdministracaoHospitalar "1" o-- "*" RelatorioFinanceiro : gera
    AdministracaoHospitalar "1" o-- "*" Suprimento : controla

    Leito "*" o-- "0..1" Paciente : ocupado_por

    SegurancaECompliance o-- ControleAcesso
    SegurancaECompliance o-- LogAuditoria
    SegurancaECompliance -- LGPD
```
