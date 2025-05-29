# README - Trabalho de Sockets e Streams (SD)

Este projeto implementa funcionalidades de comunicação entre processos utilizando Sockets e Streams em Java, com apoio de classes POJO, serialização personalizada (binária e JSON), e comunicação cliente-servidor via TCP.

## Estrutura de Pastas

```
SD-trab1/
├── src/
│   ├── modelo/           # POJOs: Livro, Publicacao, etc
│   ├── stream/           # Streams personalizados (Input/Output)
│   └── tcp_json/         # Versão com JSON via TCP
├── data/                 # Arquivos de dados gerados (ex: livros.dat)
├── lib/                  # Biblioteca gson (gson-2.8.9.jar)
├── bin/                  # Arquivos .class compilados
```

---

## 1. Definição de um serviço remoto com POJOs

**Local:** `src/modelo/`

* `Livro.java`, `Revista.java` (POJOs)
* `Publicacao.java` (superclasse)
* `Biblioteca.java`, `GestaoDeBiblioteca.java` (modelo do serviço)

---

## 2. Subclasse de OutputStream personalizada

**Classe:** `stream.LivroOutputStream`

* Empacota um array de `Livro` e escreve como bytes com tamanho fixo.

### a) Parâmetros do construtor:

* Array de `Livro`
* Número de objetos
* Bytes por atributo (fixo)
* OutputStream de destino

### b) Testes:

#### i. Saída Padrão

```bash
java -cp bin stream.TesteSaidaPadrao
```

#### ii. Arquivo

```bash
java -cp bin stream.TesteArquivo
```

Arquivo gerado em: `data/livros.dat`

#### iii. Servidor TCP

Inicie o servidor:

```bash
java -cp bin stream.ServidorTCP
```

Depois o cliente:

```bash
java -cp bin stream.TesteTCP
```

---

## 3. Subclasse de InputStream personalizada

**Classe:** `stream.LivroInputStream`

* Desempacota os dados binários escritos pelo OutputStream anterior.

### a) Construtor com InputStream

### b) Leitura da entrada padrão:

```bash
java -cp bin stream.TesteStdin < data/livros.dat
```

### c) Leitura do arquivo:

```bash
java -cp bin stream.TesteArquivoLeitura
```

### d) Leitura via socket TCP:

Executado junto ao `ServidorTCP`

---

## 4. Serialização com cliente-servidor TCP (binário)

**Fluxo:**

* `stream.TesteTCP` envia
* `stream.ServidorTCP` recebe

### Compilar:

```bash
javac -cp lib/gson-2.8.9.jar -d bin src/modelo/*.java src/tcp_json/*.java
```

### Executar:

```bash
java -cp lib/gson-2.8.9.jar:bin tcp_json.ServidorJSON
```

Depois:

```bash
java -cp lib/gson-2.8.9.jar:bin tcp_json.ClienteJSON
```

