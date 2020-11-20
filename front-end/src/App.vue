<template>
  <div id="app">
    <div class="container">
      <h3 class="center-align">Futebol-app using Vue.js and Axios</h3>
      <div class="row">

        <form class="col s12" @submit.prevent="salvar">
          <div class="row">

            <div class="input-field col s6">
              <select name="casa" v-model="time.nome_time_casa">
                <option value="" disabled selected>Escolha seu time</option>
                <option v-for="time of times" :key="time.id">
                  {{time.nome}}
                </option>
              </select>
              <label>Time da Casa</label>
            </div>

            <div class="input-field col s6">
              <select name="visitante" v-model="time.nome_time_visitante">
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
              <input name="golcasa" type="text" v-model="time.gols_time_casa" class="validate">
              <label>Gols do Time da Casa</label>
            </div>
            <div class="input-field col s6">
              <input name="golsivitante" type="text" v-model="time.gols_time_visitante" class="validate">
              <label>Gols do Time Visitante</label>
            </div>
          </div>


          <button class="btn waves-effect waves-light" type="submit" name="action"><i
              class="material-icons right">save</i>Adicionar Partida</button>

        </form>

      </div>
      <h4>Tabela Brasileirão</h4>


      <table>
        <thead>
          <tr>
            <th>Times</th>
            <th>Pontos</th>
            <th>Gols</th>
            <th>Partidas</th>
            <th>Vitórias</th>
            <th>Empates</th>
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
            <td>{{ time.empates }}</td>
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
        time: {
          nome_time_casa: '',
          nome_time_visitante: '',
          gols_time_casa: '',
          gols_time_visitante: '',
        },
        times: []
      }
    },

    mounted() {
      this.listar()
    },

    methods: {

      listar(){
        Time.listar().then(r => {
        this.times = r.data;
      })
    },

      salvar() {
        Time.salvar(this.time).then(resp => {
          this.resp = resp;
          alert('Partida adicionada com sucesso!')
          this.listar()
        }),
        Time.atualizar(this.time).then(resp => {
          this.resp = resp;
        })
      }
    }

  }
</script>

<style>

</style>