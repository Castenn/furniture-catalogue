import {Model} from "vue-mc";

export default class ProductImage extends Model {

    defaults () {
        return {
            id: null,
            path: null,
            name: null,
            extension: null,
            productId: null,
        }
    }

    mutations () {
        return {
            id: (id) => Number(id) || null,
            path: (path) => String(path) || null,
            name: (name) => String(name) || null,
            extension: (extension) => String(extension) || null,
            productId: (productId) => Number(productId) || null,
        }
    }
}
