# Padrão Memento

Controle da situação dos exemplares de uma biblioteca (disponível, emprestado, reservado, em
reparo, extraviado). Cada mudança de situação fica guardada no histórico do exemplar, e o
bibliotecário pode restaurar uma situação anterior quando registra algo errado, por exemplo
quando marca como extraviado um livro que só estava emprestado. As situações são instâncias
únicas, compartilhadas entre todos os exemplares.

## Conteúdo do repositório

- Código-fonte (`Exemplar`, `SituacaoExemplar` e as cinco situações)
- Casos de teste JUnit (`ExemplarTest`)
- Diagrama UML (`diagrama_memento.drawio`)
