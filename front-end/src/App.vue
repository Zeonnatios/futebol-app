<template>
  <div id="app">
    <div class="container">
      <h3 class="center-align">Futebol-app using Vue.js and Axios</h3>
      <div class="row">
        <form class="col s12">
          <div class="row">

            <div class="input-field col s6">
              <select name="casa">
                <option value="" disabled selected>Choose your option</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
              <label>Time da Casa</label>
            </div>

            <div class="input-field col s6">
              <select name="visitante">
                <option value="" disabled selected>Choose your option</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
              </select>
              <label>Time Visitante</label>
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

        <button class="btn waves-effect waves-light" type="submit" name="action"><i
            class="material-icons right">save</i>Adicionar Partida</button>
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
  </div>
</template>


<script>

</script>

<style>

</style>