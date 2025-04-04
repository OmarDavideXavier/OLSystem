<h1>OLSystem</h1>

<p>OLSystem é um sistema de gestão desenvolvido em Java com interface gráfica, projetado para facilitar o gerenciamento de processos relacionados à agricultura, produção de gados e cereais.</p>

<p>O sistema é voltado para praticantes de agricultura, produtores de gados e cereais que desejam organizar e controlar suas operações de maneira eficiente.</p>

<h2>Tecnologias Utilizadas</h2>
<ul>
  <li>Java (Swing para a interface gráfica)</li>
  <li>NetBeans IDE</li>
  <li>MySQL (para armazenamento de dados)</li>
  <li>Conectores JDBC:
    <ul>
      <li>mysql-connector-java-5.1.23-bin.jar</li>
      <li>mysql-connector-java-8.0.29.jar</li>
    </ul>
  </li>
</ul>

<h2>Estrutura do Projeto</h2>
<p>Para a elaboração deste projecto, utilizou-se a arquitetura MVC(Model-View-Controler)</p>
<ul>
  <li>build.xml: Arquivo de configuração de build do NetBeans.</li>
  <li>manifest.mf: Arquivo de manifesto do projeto Java.</li>
  <li>lib/: Diretório contendo os conectores MySQL.</li>
  <li>src/: Código fonte do projeto (classes Java).</li>
  <li>build/classes/: Classes compiladas (.class).</li>
</ul>

<h2>Como Executar o Projeto</h2>
<ol>
  <li>Instale o NetBeans IDE (recomendado).</li>
  <li>Certifique-se de ter o MySQL instalado e configurado.</li>
  <li>Importe o projeto no NetBeans.</li>
  <li>Certifique-se de que os conectores JDBC estejam configurados no classpath do projeto.</li>
  <li>Compile e execute o projeto através do NetBeans.</li>
</ol>

<h2>Banco de Dados</h2>
<ul>
 <li>Certifique-se de instalar o mysql workbench </li>
  <li>Certifique-se de configurar corretamente a conexão com o banco de dados MySQL no código-fonte.</li>
  <li>Faça a criação da base de dados e sua respectiva tabela.</li>
</ul>

<h2>Capturas de Tela</h2>
<ul>
  <li><strong>Tela Principal</strong>: Esta é a interface inicial do sistema OLSystem, exibindo o menu principal e opções para navegação.<br>
    <img [src="Z/Captura%20de%20Ecr╞%20(382).png](https://github.com/OmarDavideXavier/OLSystem/blob/main/CapturasEcra/Captura%20de%20Ecr%C3%A3%20(391).png)" alt="Tela Principal"></li>
  <li><strong>Gestão de Clientes</strong>: Interface para cadastro, edição e visualização de clientes do sistema.<br>
    <img src="Z/Captura%20de%20Ecr╞%20(383).png" alt="Cadastro de Clientes"></li>
  <li><strong>Gestão de Produtos</strong>: Interface para cadastro, edição e visualização de produtos agrícolas, gados e cereais.<br>
    <img src="Z/Captura%20de%20Ecr╞%20(384).png" alt="Cadastro de Produtos"></li>
  <li><strong>Relatórios</strong>: Painel para geração de relatórios personalizados sobre dados cadastrados no sistema.<br>
    <img src="Z/Captura%20de%20Ecr╞%20(387).png" alt="Relatórios"></li>
  <li><strong>Configurações do Sistema</strong>: Seção para configurar parâmetros importantes do sistema, como conexão com o banco de dados.<br>
    <img src="Z/Captura%20de%20Ecr╞%20(390).png" alt="Configurações do Sistema"></li>
</ul>

h2>Observação</h2>
Este projecto foi feito por mim, Omar Davide Xavier, quando estava a aprender programação orientada a objectos.

<h2>Contribuição</h2>
<p>Sinta-se à vontade para contribuir com melhorias ou correções no projeto.</p>

<h2>Licença</h2>
<p>Este projeto é livre para uso e modificação.</p>
