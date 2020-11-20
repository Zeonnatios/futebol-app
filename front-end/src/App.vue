<template>
  <div id="app">
    <div class="container">
      <h3 class="center-align">Futebol-app using Vue.js and Axios</h3>
      <div class="row">
        <form class="col s12">
          <div class="row">

            <div class="input-field col s6">
              <select name="nome_time_casa">
                <option value="" disabled selected>Escolha seu time</option>
                <option v-for="time of times" :key="time.id">
                  {{time.nome}}
                </option>
              </select>
              <label>Time da Casa</label>
            </div>

            <div class="input-field col s6">
              <select name="nome_time_visitante">
                <option value="" disabled selected>Escolha seu time</option>
                <option v-for="time of times" :key="time.id">
                  {{time.nome}}
                </option>
              </select>
              <label>Time Visitante</label>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s6">
              <input type="text" name="gols_casa" class="validate">
              <label>Gols do Time da Casa</label>
            </div>
            <div class="input-field col s6">
              <input type="text" name="gols_visitante" class="validate">
              <label>Gols do Time Visitante</label>
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
            <th>Pontos</th>
            <th>Gols</th>
            <th>Partidas Disputadas</th>
            <th>Vitórias</th>
            <th>Derrotas</th>
          </tr>
        </thead>

        <tbody>

          <tr v-for="time of times" :key="time.id">
            <td>{{ time.nome }}</td>
            <td>{{ time.pontos }}</td>
            <td>{{ time.gols }}</td>
            <td>{{ time.partidas }}</td>
            <td>{{ time.vitorias }}</td>
            <td>{{ time.derrotas }}</td>
          </tr>

        </tbody>
      </table>
    </div>
  </div>
</template>


<script>
  import Time from './services/times'

  export default {

    data() {
      return {
        times: []
      }
    },

    mounted() {
      Time.listar().then(r => {
        console.log(r.data)
        this.times = r.data;
      })
    }
  }
</script>

<style>

</style>