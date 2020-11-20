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

          <button class="btn waves-effect " type="submit" name="action"><i
              class="material-icons right">save</i>Adicionar
            Partida</button>
        </form>
      </div>

      <h4>Tabela Brasileirão - 
        <a class="waves-effect btn modal-trigger" href="#modal-partidas">Visualizar Resultados</a>
      </h4>
      <!-- Modal Trigger -->

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

    <!-- Modal Structure -->
    <div id="modal-partidas" class="modal">
      <div class="modal-content">
        <table>
          <thead>
            <tr>
              <th>Time da Casa</th>
              <th>Gols da Casa</th>
              <th>Time Visitante</th>
              <th>Gols do Visitante</th>
            </tr>
          </thead>

          <tbody>
            <tr v-for="partida of partidas" :key="partida.id">
              <td>{{ partida.nome_time_casa }}</td>
              <td>{{ partida.gols_time_casa }}</td>
              <td>{{ partida.nome_time_visitante }}</td>
              <td>{{ partida.gols_time_visitante }}</td>
            </tr>
          </tbody>

        </table>
      </div>
      <div class="modal-footer">
        <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
      </div>
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
        times: [],
        partidas: []
      }
    },

    mounted() {
      this.listar()
      this.listarPartidas();
    },

    methods: {



      listar() {
        Time.listar().then(r => {
          this.times = r.data;
        })
      },

      salvar() {
        Time.salvar(this.time).then(resp => {
            this.resp = resp;
            alert('Partida adicionada com sucesso!')
          }),
          Time.atualizar(this.time).then(resp => {
            this.resp = resp;
            this.listar()
            this.listarPartidas();
          })
      },

      listarPartidas() {
        Time.listarPartidas().then(r => {
          this.partidas = r.data;
        })
      }
    }

  }
</script>

<style>

</style>