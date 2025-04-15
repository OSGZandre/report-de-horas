# Sistema de Relatório de Horas

Este é um projeto simples em Java para gerenciar relatórios de horas trabalhadas em projetos. O sistema permite cadastrar projetos, registrar horas trabalhadas e gerar relatórios com o total de horas e o custo associado, baseado no valor por hora.

## Funcionalidades
- **Cadastrar Projetos**: Adicione novos projetos com nome e valor por hora.
- **Registrar Horas**: Registre sessões de trabalho com data e hora de início e fim para um projeto específico.
- **Gerar Relatórios**: Veja o total de horas trabalhadas e o custo total de um projeto, ou de todos os projetos cadastrados.

## Pré-requisitos
- **Java Development Kit (JDK)**: Versão 8 ou superior instalada.
- Um terminal ou IDE (como IntelliJ IDEA ou Eclipse) para compilar e executar o código.

## Como Usar

### 1. Clonar o Repositório
Clone o repositório para sua máquina local:
```bash
git clone https://github.com/OSGZandre/report-de-horas.git
cd report-de-horas
```

### 2. Compilar o Código
Compile o arquivo `TimeReportSystem.java`:
```bash
javac TimeReportSystem.java
```

### 3. Executar o Programa
Execute o programa compilado:
```bash
java TimeReportSystem
```

### 4. Interagir com o Sistema
Ao executar, você verá um menu interativo no terminal com as seguintes opções:

```
1. Cadastrar Projeto
2. Registrar Horas
3. Gerar Relatório
4. Sair
```

#### **Cadastrar Projeto**
- Escolha a opção `1`.
- Digite o nome do projeto (ex.: "Sistema de Vendas").
- Informe o valor por hora (ex.: `50.0` para R$50/hora).
- Exemplo:
  ```
  Nome do projeto: Sistema de Vendas
  Valor por hora: 50.0
  Projeto cadastrado com sucesso!
  ```

#### **Registrar Horas**
- Escolha a opção `2`.
- Digite o nome de um projeto existente.
- Informe a data e hora de início e fim no formato `yyyy-MM-dd HH:mm` (ex.: `2025-04-15 09:00`).
- Exemplo:
  ```
  Nome do projeto: Sistema de Vendas
  Formato de data/hora: yyyy-MM-dd HH:mm
  Início (ex: 2025-04-15 09:00): 2025-04-15 09:00
  Fim (ex: 2025-04-15 17:00): 2025-04-15 17:00
  Horas registradas com sucesso!
  ```

#### **Gerar Relatório**
- Escolha a opção `3`.
- Digite o nome de um projeto para ver o relatório específico, ou deixe em branco (pressione Enter) para ver todos os projetos.
- O relatório mostra:
  - Total de horas trabalhadas.
  - Custo total (horas × valor/hora).
  - Lista de sessões registradas.
- Exemplo:
  ```
  Nome do projeto (ou deixe vazio para todos): Sistema de Vendas
  Relatório - Projeto: Sistema de Vendas
  Total de horas: 8
  Custo total: R$400.00
  Sessões:
  - De 2025-04-15T09:00 até 2025-04-15T17:00
  ```

#### **Sair**
- Escolha a opção `4` para encerrar o programa.

## Estrutura do Projeto
- `TimeReportSystem.java`: Arquivo principal com toda a lógica do sistema.
- O sistema armazena dados em memória (não persiste entre execuções).

## Notas
- O sistema usa o formato `yyyy-MM-dd HH:mm` para entradas de data e hora. Certifique-se de seguir esse padrão