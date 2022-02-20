import { Model } from 'vue-mc'

export default class Category extends Model {

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
