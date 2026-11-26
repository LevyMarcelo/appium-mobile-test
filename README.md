# Automação de Testes Mobile com Appium e Java

## 1. Visão geral do projeto

Este repositório apresenta um projeto de automação de testes mobile utilizando Appium e Java, com foco nas plataformas Android e iOS.

## 2. Objetivos

Desenvolver uma solução de automação de testes mobile, priorizando:

- Automação de fluxos funcionais.
- Compatibilidade com Android e iOS.
- Organização e reutilização de código.
- Separação entre testes, locators e componentes de tela.
- Sincronização adequada com os elementos da aplicação.
- Facilidade de manutenção e evolução da automação.

## 3. Aplicação sob teste

Aplicativo de onboarding de uma cooperativa, utilizado para validar o fluxo de preenchimento de dados pessoais e navegação entre etapas do processo.

**Plataformas utilizadas:**

- Android.
- iOS.

## 4. Tecnologias utilizadas

- **Java:** linguagem utilizada no desenvolvimento dos testes.
- **Appium:** framework de automação de aplicações mobile.
- **Appium Java Client 7.3.0:** biblioteca de integração entre Java e Appium.
- **Selenium Server 3.141.59:** dependência utilizada na integração com os recursos de automação.
- **TestNG 7.1.0:** framework para organização e execução dos testes.
- **Hamcrest 1.3:** biblioteca de apoio às verificações.
- **Gradle:** ferramenta de gerenciamento de dependências e execução do projeto.

## 5. Estratégia de testes

A estratégia contempla a automação de um fluxo de onboarding, com foco no preenchimento de informações pessoais e na validação da navegação entre etapas.

Na implementação, são adotadas práticas que favorecem a organização e a manutenibilidade:

- Separação dos locators conforme a plataforma.
- Utilização de Page Object Model.
- Encapsulamento de elementos e interações nos componentes de tela.
- Organização dos testes utilizando TestNG.
- Utilização de esperas explícitas para sincronização com a interface.
- Configuração de capabilities específicas para Android e iOS.
- Separação das configurações de execução por plataforma.

## 6. Escopo de testes

O escopo automatizado contempla o fluxo de preenchimento de dados pessoais no aplicativo.

| Etapa | Validação |
|---|---|
| Início do onboarding | Acesso ao fluxo de cadastro |
| CPF | Preenchimento do documento |
| Nome completo | Preenchimento do nome |
| Estado | Seleção da unidade federativa |
| Cidade | Seleção da cidade |
| Termos | Aceite dos termos |
| Continuação | Avanço para a próxima etapa |
| Tela de contatos | Validação da apresentação da etapa seguinte |

A validação final verifica a apresentação da tela **Contatos**, após a conclusão do preenchimento dos dados pessoais.

Os testes foram executados em ambientes Android e iOS.

## 7. Arquitetura do projeto

A automação utiliza o padrão **Page Object Model (POM)** para separar os elementos e as interações da interface da implementação dos testes.

A arquitetura está organizada em componentes com responsabilidades específicas:

- **Locators:** centralização dos identificadores de elementos, separados por plataforma.
- **Screens:** encapsulamento dos elementos e das interações com as telas.
- **Tests:** implementação dos cenários automatizados e respectivas validações.
- **Utils:** métodos auxiliares, interações e recursos de sincronização.
- **BaseTest:** estrutura compartilhada para configuração, inicialização e encerramento do driver.

A configuração de execução utiliza arquivos XML do TestNG, permitindo organizar a execução por plataforma e disponibilizar uma configuração para execução paralela.

O gerenciamento das dependências e a configuração da tarefa de testes são realizados pelo Gradle.

## 8. Estrutura do projeto

```text
appium-mobile-test/
│
├── src/
│   └── test/
│       ├── java/
│       │   └── br/com/appium/
│       │       ├── locators/
│       │       │   ├── AndroidLocators.java
│       │       │   └── IOSLocators.java
│       │       │
│       │       ├── screens/
│       │       │   └── PersonalDataScreen.java
│       │       │
│       │       ├── tests/
│       │       │   ├── BaseTest.java
│       │       │   └── PersonalDataTest.java
│       │       │
│       │       └── utils/
│       │           └── Utils.java
│       │
│       └── resources/
│           └── suites/
│               ├── android_test.xml
│               ├── ios_test.xml
│               └── parallel_tests.xml
│
├── .gitignore
├── build.gradle
├── settings.gradle
└── README.md
```

## 9. Pré-requisitos

A execução dos testes requer a configuração do ambiente e a disponibilidade da aplicação sob teste.

**Ferramentas e dependências utilizadas:**

- Java Development Kit (JDK).
- Gradle.
- Node.js e npm.
- Appium Server.
- Android Studio e Android SDK para execução Android.
- Xcode e ferramentas de desenvolvimento e execução iOS.
- Emulador Android ou simulador iOS.
- Git.

**Configuração adicional no macOS:**

- Arquivo `.bash_profile` configurado com as variáveis de ambiente e os caminhos necessários para utilização das ferramentas de desenvolvimento.

## 10. Instalação e configuração

**Clonar o repositório:**

```bash
git clone https://github.com/LevyMarcelo/appium-mobile-test.git
```

**Acessar o diretório:**

```bash
cd appium-mobile-test
```

**Preparar o ambiente:**

- Instalar e configurar o JDK.
- Instalar e configurar o Gradle.
- Instalar o Node.js e o Appium Server.
- Configurar o ambiente Android ou iOS.
- Disponibilizar o dispositivo ou emulador correspondente.
- Configurar as capabilities conforme os arquivos de suíte do TestNG.

O Appium Server deve estar disponível no endereço configurado nos arquivos XML do TestNG:

```text
http://localhost:4723/wd/hub
```

## 11. Execução dos testes

O projeto utiliza TestNG para organizar a execução dos testes por plataforma.

Os arquivos de configuração estão disponíveis em:

- `android_test.xml`: configuração da execução Android.
- `ios_test.xml`: configuração da execução iOS.
- `parallel_tests.xml`: configuração para execução paralela em Android e iOS.

**Execução com Gradle:**

```bash
# Executar os testes Android
gradle test -Psuite=android_test

# Executar os testes iOS
gradle test -Psuite=ios_test

# Executar a suíte configurada para execução paralela
gradle test -Psuite=parallel_tests
```

**Execução pela IDE IntelliJ IDEA:**

Também é possível executar as suítes diretamente pela IDE, selecionando o arquivo XML desejado no diretório:

```text
src/test/resources/suites/
```

A execução requer o Appium Server ativo, o ambiente da plataforma devidamente configurado e a aplicação sob teste disponível para utilização.

## 12. Resultados

O projeto foi executado e validado em ambientes Android e iOS.

O fluxo automatizado realiza o preenchimento dos dados pessoais e verifica a navegação.
