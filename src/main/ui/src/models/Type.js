import { Model } from 'vue-mc'

const TYPES_LIST_PATH = 'http://localhost:8080/type/all'

export default class Type extends Model {

    defaults () {
        return {
            id: null,
            name: null,
        }
    }

    mutations () {
        return {
            id: (id) => Number(id) || null,
            name: (name) => String(name) || null,
        }
    }
}
