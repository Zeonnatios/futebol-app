<template>
  <div class="container">
    <div class="row">
      <form class="col s12">
        <div class="row">
          <div class="input-field col s6">
            <input id="icon_prefix" type="text" name="casa" class="validate">
            <label for="icon_prefix">Time da Casa</label>
          </div>
          <div class="input-field col s6">
            <input id="icon_telephone" type="text" name="visitante" class="validate">
            <label for="icon_telephone">Time Visitante</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field col s6">
            <input id="icon_prefix" type="text" name="golscasa" class="validate">
            <label for="icon_prefix">Gols do Time da Casa</label>
          </div>
          <div class="input-field col s6">
            <input id="icon_telephone" type="text" name="golsvisitante" class="validate">
            <label for="icon_telephone">Gols do Time Visitante</label>
          </div>
        </div>
      </form>

      <button class="btn waves-effect waves-light" type="submit" name="action">Adicionar Partida</button>
    </div>
    <h4>Tabela Brasileirão</h4>


    <table>
      <thead>
        <tr>
          <th>Times</th>
          <th>Partidas Jogadas</th>
          <th>Gols</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>Corinthians</td>
          <td>18</td>
          <td>9</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    props: {
      msg: String
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h3 {
    margin: 40px 0 0;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>