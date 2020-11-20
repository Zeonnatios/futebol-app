import { http } from './config'
export default {

    listar: () => {
        return http.get('times');
    },
    salvar: (time) => {
        return http.post('partidas', time);
    }

}