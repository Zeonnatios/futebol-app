import { http } from './config'
export default {

    listar: () => {
        return http.get('times');
    },

    salvar: (time) => {
        return http.post('partidas', time);
    },

    atualizar:(time)=>{
		return http.put('times', time);
    },

    listarPartidas: () =>{
        return http.get('partidas')
    }
        
}