#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastro de Alunos
como um usuario do sistema
eu quero realizar cadastro de alunos
para que eu possa gerenciar alunos

Esquema do Cenário: Definir grau de Escolaridade
Dado Acessar a pagina cadastro de Alunos
E informar nome "Fernando Ruan Alexandre Aragão"
E informar CPF "193.718.224-06"
E informar RG "18.500.853-7"
E informar matricula "2022.01"
E informar data nascimento "21/01/2001"
E selecionar a escolaridade <escolaridade>
Quando Realizar cadastro do aluno
Entao o sistema exibe a mensagem "Aluno cadastrado com sucesso."

Exemplos: 
| escolaridade      |
| "Ensino Médio"    |
| "Ensino Superior" |
| "Pós Graduação"   |

Cenário: Validacão de campos obrigatorios
Dado Acessar a pagina cadastro de Alunos
Quando Realizar cadastro do aluno
Entao o sistema exibe a mensagem campo obrigatorio