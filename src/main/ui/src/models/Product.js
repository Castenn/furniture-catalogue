import { Model } from 'vue-mc'
import ProductImage from "./ProductImage";

export default class Product extends Model {

    defaults () {
        return {
            id: null,
            article: null,
            name: null,
            description: null,
            price: null,
            image: null,
            height: null,
            width: null,
            depth: null,
            typeId: null,
        }
    }

    mutations () {
        return {
            id: (id) => Number(id) || null,
            article: (article) => Number(article) || null,
            name: (name) => String(name) || null,
            description: (description) => String(description) || null,
            price: (price) => Number(price) || null,
            image: (image) => new ProductImage(image) || null,
            height: (height) => Number(height) || null,
            width: (width) => Number(width) || null,
            depth: (depth) => Number(depth) || null,
            typeId: (typeId) => Number(typeId) || null,
        }
    }
}
